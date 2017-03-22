package com.akshay.samplekotlin.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun toHourMinFormat(millis: Long): String {
    return parseDate("HH:mm", millis)
}

fun parseDate(pattern: String, millis: Long): String {
    return SimpleDateFormat(pattern, Locale.getDefault()).format(Date(millis))
}

fun convertToMillis(hour: Int = 7, min: Int = 30): Long {
    return ((hour * 60 * 60000) + (min * 60000)).toLong()
}

fun getPercentLeft(timeLeftInMillis: Long): Float {
    return timeLeftInMillis.toFloat() / convertToMillis().toFloat() * 100
}

fun getRemainingTime(context: Context): Long {
    return convertToMillis() - (System.currentTimeMillis() - getStartTime(context))
}

fun getEndTime(context: Context): Long {
    return getStartTime(context) + convertToMillis()
}

fun toReadableTime(millis: Long): String {
    return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)))
}
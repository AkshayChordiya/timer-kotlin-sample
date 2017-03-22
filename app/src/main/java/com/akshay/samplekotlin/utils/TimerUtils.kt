package com.akshay.samplekotlin.utils

import android.content.Context

val PREF_TIME_KEY = "Start_time"

fun didTimeStart(context: Context): Boolean {
    when {
        exists(context, PREF_TIME_KEY) -> return true
        else -> return getStartTime(context) != 0L
    }
}

fun removeStartTime(context: Context) {
    remove(context, PREF_TIME_KEY)
}

fun getStartTime(context: Context): Long {
    return getLong(context, PREF_TIME_KEY, 0)
}

fun setStartTime(context: Context, time: Long) {
    putLong(context, PREF_TIME_KEY, time)
}

package com.akshay.samplekotlin.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

fun getString(context: Context, key: String, defValue: String): String {
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    return pref.getString(key, defValue)
}

fun putString(context: Context, key: String, value: String) {
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    val editor = pref.edit()
    editor.putString(key, value)
    editor.apply()
}

fun getLong(context: Context, key: String, defValue: Long): Long {
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    return pref.getLong(key, defValue)
}

fun putLong(context: Context, key: String, value: Long) {
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    val editor = pref.edit()
    editor.putLong(key, value)
    editor.apply()
}

fun exists(context: Context, key: String): Boolean {
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    return pref.contains(key)
}

fun remove(context: Context, key: String) {
    val pref = PreferenceManager.getDefaultSharedPreferences(context)
    val editor = pref.edit()
    editor.remove(key)
    editor.apply()
}
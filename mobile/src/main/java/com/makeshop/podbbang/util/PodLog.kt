package com.makeshop.podbbang.util

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.google.android.datatransport.BuildConfig
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object LineLog {
    val TAG = "LineLog"

    /** Log Level Error **/
    fun e(message: String) {
        if (BuildConfig.DEBUG) {
            val filename = String.format(
                " (%s:%s)",
                Throwable().stackTrace[1].fileName,
                Throwable().stackTrace[1].lineNumber
            )
            Log.e(TAG, message + filename)
        }
    }

    fun p(message: String) {
//        if (BuildConfig.DEBUG) {
            val filename = String.format(
                " (%s:%s)",
                Throwable().stackTrace[1].fileName,
                Throwable().stackTrace[1].lineNumber
            )
            val methodName = String.format(" %s() ", Throwable().stackTrace[1].methodName)
            Log.d(TAG, message + filename)
//        }
    }
}
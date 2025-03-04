package com.makeshop.podbbang.shared.util

import android.util.Log

object LineLog {
    val TAG = "LineLog"

    /** Log Level Error **/
    fun e(message: String) {
            val filename = String.format(
                " (%s:%s)",
                Throwable().stackTrace[1].fileName,
                Throwable().stackTrace[1].lineNumber
            )
            Log.e(TAG, message + filename)
    }

    fun d(message: String) {
            val filename = String.format(
                " (%s:%s)",
                Throwable().stackTrace[1].fileName,
                Throwable().stackTrace[1].lineNumber
            )
            Log.e(TAG, message + filename)
    }
}

//val methodName = String.format(" %s() ", Throwable().stackTrace[1].methodName)
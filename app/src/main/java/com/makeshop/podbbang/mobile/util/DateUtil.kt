package com.makeshop.podbbang.mobile.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateUtil {
    fun isTodayFromStringPattern(date: String?): Boolean {
        if (date.isNullOrEmpty()) {
            return false
        }

        return try {
            val convertDate =  date.replace("/","-").replace(".","-")
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val targetDay = Calendar.getInstance()
            targetDay.time = dateFormat.parse(convertDate)

            val today = Calendar.getInstance()
            today.timeInMillis = System.currentTimeMillis()

            today.get(Calendar.YEAR) == targetDay.get(Calendar.YEAR) &&
                    today.get(Calendar.MONTH) == targetDay.get(Calendar.MONTH) &&
                    today.get(Calendar.DAY_OF_MONTH) == targetDay.get(Calendar.DAY_OF_MONTH)
        } catch (e : Exception) {
            false
        }
    }
}
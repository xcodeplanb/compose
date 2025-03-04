package com.makeshop.podbbang.mobile

import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(true,isTodayFromStringPattern("2024.06.20 00:00:00"))
        Assert.assertEquals(true,isTodayFromStringPattern("2024.06.21 00:00:00"))
    }
}

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
        println("convertDate " + e.message)
        false
    }
}
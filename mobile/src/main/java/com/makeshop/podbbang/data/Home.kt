package com.makeshop.podbbang.data

data class Home(
    val id: String,
    val title: String,
) {
    companion object {
        fun mock() = Home(
            id = "no1",
            title = "보아",
        )
    }
}
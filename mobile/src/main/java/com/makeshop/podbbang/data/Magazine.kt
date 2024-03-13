package com.makeshop.podbbang.data

data class Magazine(
    var inputText: String
) {
    companion object {
        fun mock() = Magazine(
            inputText = ""
        )
    }
}
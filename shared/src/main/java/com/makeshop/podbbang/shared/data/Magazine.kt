package com.makeshop.podbbang.shared.data

data class Magazine(
    var inputText: String
) {
    companion object {
        fun mock() = Magazine(
            inputText = ""
        )
    }
}
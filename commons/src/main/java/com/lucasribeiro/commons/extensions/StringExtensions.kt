package com.lucasribeiro.commons.extensions

fun String.setImageSize(widht: Int, height: Int): String {
    return replace("{width}", widht.toString())
        .replace("{height}", height.toString())
}
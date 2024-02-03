package com.agvber.network

import com.google.gson.GsonBuilder


fun printPrettyJson(src: Any) {
    val gson = GsonBuilder().setPrettyPrinting().create()
    println(gson.toJson(src))
}
package com.jasmeet.myapplication_1.model

data class Record(
    val arrival_date: String,
    val commodity: String,
    val district: String,
    val market: String,
    val max_price: Double,
    val min_price: Double,
    val modal_price: Int,
    val state: String,
    val variety: String
)
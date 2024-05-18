package com.newsapis.dto

data class BaseDTO<T>(
    val status: Int,
    val message: String,
    val data: T
)

package com.newsapis.dto

data class NewsDTO(
        val id: Int,
        val title: String,
        val description: String,
        val createdDate: Long,
        val updatedDate: Long,
        val createdBy: String
)

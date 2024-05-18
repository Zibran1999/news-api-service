package com.newsapis.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "news")
data class News(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,
        val title: String,
        val description: String,
        val createdDate: Long,
        val updatedDate: Long,
        val createdBy: String
)

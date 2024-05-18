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
        var title: String,
        var description: String,
        var createdDate: Long,
        var updatedDate: Long,
        var createdBy: String
)

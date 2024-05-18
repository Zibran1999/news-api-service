package com.newsapis.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int?,
        var fullName: String,
        var mobileNumber: String,
        var email: String,
        var userName: String,
        var password: String
)

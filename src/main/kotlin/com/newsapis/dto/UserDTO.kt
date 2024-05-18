package com.newsapis.dto

import jakarta.validation.constraints.NotBlank

data class UserDTO(
        val id: Int? = null,
        @get:NotBlank(message = "full name should not be empty")
        val fullName: String,
        @get:NotBlank(message = "mobile number should not be empty")
        val mobileNumber: String,
        @get:NotBlank(message = "email should not be empty")
        val email: String,
        @get:NotBlank(message = "username should not be empty")
        val userName: String,
        @get:NotBlank(message = "password should not be empty")
        val password: String
)

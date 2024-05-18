package com.newsapis.utils.extensions

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.UserDTO
import com.newsapis.entity.User

fun UserDTO.toUser(): User {
    return User(
            id = id,
            fullName = fullName,
            mobileNumber = mobileNumber,
            email = email,
            userName = userName,
            password = password
    )
}

fun User.toUserDTO(): UserDTO {
    return UserDTO(
            id = id,
            fullName = fullName,
            mobileNumber = mobileNumber,
            email = email,
            userName = userName,
            password = password
    )
}

fun UserDTO.toBaseDTO(status: Int, message: String): BaseDTO<UserDTO> {
    return BaseDTO(status = status, message = message, data = this)
}

fun List<UserDTO>.toBaseDTO(status: Int, message: String): BaseDTO<List<UserDTO>> {
    return BaseDTO(status = status, message = message, data = this)
}
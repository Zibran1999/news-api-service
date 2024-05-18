package com.newsapis.service

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.UserDTO
import com.newsapis.exception.CourseNotFoundException
import com.newsapis.repository.UserRepository
import com.newsapis.utils.extensions.toBaseDTO
import com.newsapis.utils.extensions.toUser
import com.newsapis.utils.extensions.toUserDTO
import jakarta.annotation.Nullable
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun createUser(userDTO: UserDTO): BaseDTO<UserDTO> {
        val user = userDTO.toUser()
        repository.save(user)
        return user.toUserDTO().toBaseDTO(status = 1, message = "User created successfully")
    }

    fun getUsers(): BaseDTO<List<UserDTO>> = repository.findAll().map { it.toUserDTO() }.toBaseDTO(status = 1, message = "Data fetched successfully")

    fun updateUser(userDTO: UserDTO): BaseDTO<UserDTO> {
        val existUser = repository.findById(userDTO.id!!)

        val userDTOResult = if (existUser.isPresent) {
            existUser.get().let {
                it.fullName = userDTO.fullName
                it.mobileNumber = userDTO.mobileNumber
                it.email = userDTO.email
                it.userName = userDTO.userName
                it.password = userDTO.password
                repository.save(it)
                it.toUserDTO()
            }
        } else {
            throw CourseNotFoundException("No user exists for the passed id: ${userDTO.id}")
        }
        return userDTOResult.toBaseDTO(status = 1, message = "User updated successfully")
    }

    fun deleteUser(userDTO: UserDTO): BaseDTO<Nullable> {
        repository.delete(userDTO.toUser())
        return BaseDTO(status = 1, message = "User Deleted successfully", data = Nullable())
    }

    fun getUser(userId: Int): BaseDTO<UserDTO> {
        val userDTO = repository.findById(userId).map { it.toUserDTO() }.get()

        return BaseDTO(status = 1, message = "User Fetched successfully", data = userDTO)
    }
}
package com.newsapis.controller

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.UserDTO
import com.newsapis.service.UserService
import jakarta.annotation.Nullable
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/user")
@Validated
class UserController(private val userService: UserService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody @Valid userDTO: UserDTO): BaseDTO<UserDTO> = userService.createUser(userDTO)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getUsers(): BaseDTO<List<UserDTO>> = userService.getUsers()

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    fun getUser(@PathVariable("userId") userId: Int): BaseDTO<UserDTO> = userService.getUser(userId)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateUser(@RequestBody userDTO: UserDTO): BaseDTO<UserDTO> = userService.updateUser(userDTO)

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun deleteUser(@RequestBody userDTO: UserDTO): BaseDTO<Nullable> = userService.deleteUser(userDTO)
}
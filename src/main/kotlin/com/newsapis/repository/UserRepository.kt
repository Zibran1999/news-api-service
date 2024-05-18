package com.newsapis.repository

import com.newsapis.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int>
package com.newsapis.repository

import com.newsapis.entity.News
import org.springframework.data.repository.CrudRepository

interface NewsRepository : CrudRepository<News, Int>
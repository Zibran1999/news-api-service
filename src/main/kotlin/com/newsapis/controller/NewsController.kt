package com.newsapis.controller

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.NewsDTO
import com.newsapis.service.NewsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/news")
class NewsController(private val service: NewsService) {

    @PostMapping
    fun createNews(@RequestBody newsDTO: NewsDTO): BaseDTO<NewsDTO> = service.createNews(newsDTO = newsDTO)

    @GetMapping
    fun getAllNews(): BaseDTO<List<NewsDTO>> = service.getAllNews()
}
package com.newsapis.controller

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.NewsDTO
import com.newsapis.service.NewsService
import jakarta.annotation.Nullable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/news")
class NewsController(private val service: NewsService) {

    @PostMapping
    fun createNews(@RequestBody newsDTO: NewsDTO): BaseDTO<NewsDTO> = service.createNews(newsDTO = newsDTO)

    @GetMapping
    fun getAllNews(): BaseDTO<List<NewsDTO>> = service.getAllNews()

    @PutMapping("/{newsId}")
    fun updateNews(@PathVariable("newsId") id: Int, @RequestBody newsDTO: NewsDTO): BaseDTO<NewsDTO> = service.updateNews(id = id, newsDTO = newsDTO)

    @DeleteMapping("/{newsId}")
    fun deleteNews(@PathVariable("newsId") id: Int): BaseDTO<Nullable> = service.deleteNews(id)
}
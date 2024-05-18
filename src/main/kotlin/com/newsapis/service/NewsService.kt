package com.newsapis.service

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.NewsDTO
import com.newsapis.repository.NewsRepository
import com.newsapis.utils.extensions.toNews
import com.newsapis.utils.extensions.toNewsDTO
import org.springframework.stereotype.Service

@Service
class NewsService(private val newsRepository: NewsRepository) {


    fun createNews(newsDTO: NewsDTO): BaseDTO<NewsDTO> {
        val newsResponse = newsRepository.save(newsDTO.toNews())

        return BaseDTO(1, "News Created Successfully", data = newsResponse.toNewsDTO())
    }

    fun getAllNews(): BaseDTO<List<NewsDTO>> {
        val newsList = newsRepository.findAll()
        return BaseDTO(status = 1, message = "News fetched successfully", data = newsList.map { it.toNewsDTO() })

    }


}
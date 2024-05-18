package com.newsapis.service

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.NewsDTO
import com.newsapis.exception.CourseNotFoundException
import com.newsapis.repository.NewsRepository
import com.newsapis.utils.extensions.toNews
import com.newsapis.utils.extensions.toNewsDTO
import jakarta.annotation.Nullable
import org.springframework.stereotype.Service

@Service
class NewsService(private val newsRepository: NewsRepository) {


    fun createNews(newsDTO: NewsDTO): BaseDTO<NewsDTO> {
        val newsResponse = newsRepository.save(newsDTO.toNews())

        return BaseDTO(1, "News Created Successfully", data = newsResponse.toNewsDTO())
    }

    fun getAllNews(): BaseDTO<List<NewsDTO>> {
        val newsList = newsRepository.findAll().sortedBy { it.id }
        return BaseDTO(status = 1, message = "News fetched successfully", data = newsList.map { it.toNewsDTO() })

    }

    fun updateNews(id: Int, newsDTO: NewsDTO): BaseDTO<NewsDTO> {
        val news = newsRepository.findById(id)
        val result = if (news.isPresent) {
            news.get().let {
                it.title = newsDTO.title
                it.description = newsDTO.description
                it.createdBy = newsDTO.createdBy
                it.createdDate = newsDTO.createdDate
                it.updatedDate = newsDTO.updatedDate
                newsRepository.save(it)
                it.toNewsDTO()
            }
        } else {
            throw CourseNotFoundException("No user exists for the passed id: ${newsDTO.id}")
        }
        return BaseDTO(status = 1, message = "News fetched successfully", data = result)


    }

    fun deleteNews(id: Int): BaseDTO<Nullable> {
        newsRepository.deleteById(id)
        return BaseDTO(status = 1, message = "News Deleted Successfully", data = Nullable())
    }


}
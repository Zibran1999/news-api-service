package com.newsapis.utils.extensions

import com.newsapis.dto.BaseDTO
import com.newsapis.dto.NewsDTO
import com.newsapis.entity.News

fun NewsDTO.toNews(): News {
    return News(id = id, title = title, description = description, createdDate = createdDate, updatedDate = updatedDate, createdBy = createdBy)
}

fun News.toNewsDTO(): NewsDTO {
    return NewsDTO(id = id, title = title, description = description, createdDate = createdDate, updatedDate = updatedDate, createdBy = createdBy)
}

fun NewsDTO.toBaseDTO(status: Int, message: String): BaseDTO<NewsDTO> {
    return BaseDTO(status = status, message = message, data = this)
}

fun List<NewsDTO>.toBaseDTO(status: Int, message: String): BaseDTO<List<NewsDTO>> {
    return BaseDTO(status = status, message = message, data = this)
}
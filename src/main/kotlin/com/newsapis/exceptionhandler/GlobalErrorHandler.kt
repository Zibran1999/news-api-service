package com.newsapis.exceptionhandler

import mu.KLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Component
@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {
    companion object : KLogging()

    override fun handleMethodArgumentNotValid(
            ex: MethodArgumentNotValidException,
            headers: HttpHeaders,
            status: HttpStatusCode,
            request: WebRequest
    ): ResponseEntity<Any>? {
        val map = HashMap<String, String>()
        val errors = ex.bindingResult.allErrors
                .map { error ->
                    val fieldName = (error as FieldError).field
                    val errorMessage = error.defaultMessage!!
                    map.put(fieldName, errorMessage)
                }
        logger.info("errors : $errors")


        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors)
    }
}
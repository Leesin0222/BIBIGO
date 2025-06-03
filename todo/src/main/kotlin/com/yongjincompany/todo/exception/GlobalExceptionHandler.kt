package com.yongjincompany.todo.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    //TODO: joinToString말고 커스텀 errorResponse로 반환하도록 수정해도 좋을 것 같음.
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(e: MethodArgumentNotValidException): ResponseEntity<String> {
        val message = e.bindingResult.fieldErrors.joinToString(", ") { it.defaultMessage ?: "Invalid" }
        return ResponseEntity(message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleOtherException(e: Exception): ResponseEntity<String> {
        return ResponseEntity("error Message: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
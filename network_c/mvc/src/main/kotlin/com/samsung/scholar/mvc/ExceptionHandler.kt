package com.samsung.scholar.mvc

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun handleSikshaException(exception: CustomException): ResponseEntity<ErrorBody> {
        return ResponseEntity(
            ErrorBody(exception.errorMessage),
            exception.httpStatus,
        )
    }
}

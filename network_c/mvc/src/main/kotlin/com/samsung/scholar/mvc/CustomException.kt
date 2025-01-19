package com.samsung.scholar.mvc

import org.springframework.http.HttpStatus

open class CustomException(
    val httpStatus: HttpStatus,
    val errorMessage: String,
) : RuntimeException(errorMessage)

data class ErrorBody(
    // 추후 code 추가 가능
    val message: String,
)

class UserNotFoundException : CustomException(HttpStatus.NOT_FOUND, "User not found")


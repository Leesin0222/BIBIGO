package com.yongjincompany.todo.exception

import org.springframework.http.HttpStatus

enum class ExceptionCode(
    val status: HttpStatus,
    val message: String
) {
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "할 일을 찾을 수 없습니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.")
}
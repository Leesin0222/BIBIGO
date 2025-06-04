package com.yongjincompany.todo.exception

open class BusinessException(
    val code: ExceptionCode
) : RuntimeException(code.message)
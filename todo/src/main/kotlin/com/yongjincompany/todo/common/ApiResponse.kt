package com.yongjincompany.todo.common

data class ApiResponse<T> (
    val success: Boolean,
    val data: T?,
    val message: String? = null
)
package com.yongjincompany.todo.dto

data class TodoResponse (
    val id: Long,
    val title: String,
    val completed: Boolean
)


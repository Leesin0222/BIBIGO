package com.yongjincompany.todo.dto

import jakarta.validation.constraints.NotBlank

data class AddTodoRequest(
    @field:NotBlank(message = "할 일의 제목을 입력해주세요")
    val title: String
)

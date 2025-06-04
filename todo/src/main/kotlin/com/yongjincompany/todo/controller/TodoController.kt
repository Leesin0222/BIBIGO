package com.yongjincompany.todo.controller

import com.yongjincompany.todo.common.ApiResponse
import com.yongjincompany.todo.dto.AddTodoRequest
import com.yongjincompany.todo.dto.TodoResponse
import com.yongjincompany.todo.entity.Todo
import com.yongjincompany.todo.entity.toDto
import com.yongjincompany.todo.service.TodoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class TodoController(private val todoService: TodoService) {

    @GetMapping
    fun getAllTodos(): ApiResponse<List<TodoResponse>> {
        val todoList = todoService.getAllTodos().map { it.toDto() }
        return ApiResponse(success = true, data = todoList)
    }

    @PostMapping
    fun addTodo(
        @RequestBody @Valid request: AddTodoRequest,
    ): ApiResponse<TodoResponse> {
        val todo = todoService.addTodo(request.title).toDto()
        return ApiResponse(success = true, data = todo)
    }

    @PutMapping("/{id}")
    fun updateTodo(
        @PathVariable id: Long,
        @RequestParam completed: Boolean,
    ): ApiResponse<TodoResponse?> {
        val todo = todoService.updateTodo(id, completed)?.toDto()
        return ApiResponse(success = todo != null, data = todo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(
        @PathVariable id: Long,
    ): ApiResponse<String> {
        todoService.deleteTodo(id)
        return ApiResponse(success = true, data = "삭제 완료")
    }
}
package com.yongjincompany.todo.controller

import com.yongjincompany.todo.dto.AddTodoRequest
import com.yongjincompany.todo.entity.Todo
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
    fun getAllTodos(): List<Todo> = todoService.getAllTodos()

    @PostMapping
    fun addTodo(
        @RequestBody @Valid request: AddTodoRequest,
    ): Todo = todoService.addTodo(request.title)

    @PutMapping("/{id}")
    fun updateTodo(
        @PathVariable id: Long,
        @RequestParam completed: Boolean,
    ): Todo? = todoService.updateTodo(id, completed)

    @DeleteMapping("/{id}")
    fun deleteTodo(
        @PathVariable id: Long,
    ) {
        todoService.deleteTodo(id)
    }
}
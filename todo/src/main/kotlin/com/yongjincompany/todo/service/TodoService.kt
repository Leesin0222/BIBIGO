package com.yongjincompany.todo.service

import com.yongjincompany.todo.entity.Todo
import com.yongjincompany.todo.exception.TodoNotFoundException
import com.yongjincompany.todo.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoRepository) {
    fun getAllTodos(): List<Todo> = todoRepository.findAll()

    fun addTodo(title: String): Todo {
        val newTodo = Todo(title = title)

        return todoRepository.save(newTodo)
    }

    fun updateTodo(id: Long, completed: Boolean): Todo? {
        val todo = todoRepository.findById(id).orElseThrow { TodoNotFoundException() }
        todo.completed = completed
        return todoRepository.save(todo)
    }

    fun deleteTodo(id: Long) {
        if (todoRepository.existsById(id))
            todoRepository.deleteById(id)
        else
            throw TodoNotFoundException()
    }
}
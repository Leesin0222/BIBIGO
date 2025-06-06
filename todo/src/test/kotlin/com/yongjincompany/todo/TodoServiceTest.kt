package com.yongjincompany.todo

import com.yongjincompany.todo.repository.TodoRepository
import com.yongjincompany.todo.service.TodoService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TodoServiceTest : AbstractContainerBaseTest() {

    @Autowired
    private lateinit var todoService: TodoService

    @Autowired
    private lateinit var todoRepository: TodoRepository

    @Test
    fun `할 일을 추가하면 DB에 할 일이 저장된다`() {
        val title = "밥 먹기"
        val saved = todoService.addTodo(title)

        val found = todoRepository.findById(saved.id)
        assertTrue(found.isPresent)
        assertEquals(title, found.get().title)
    }

}
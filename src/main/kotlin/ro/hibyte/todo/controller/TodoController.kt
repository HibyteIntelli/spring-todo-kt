package ro.hibyte.todo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ro.hibyte.todo.dto.TodoDto
import ro.hibyte.todo.service.TodoService

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping("/api/todos")
class TodoController {

    @Autowired
    private lateinit var todoService: TodoService

    @GetMapping
    fun getAll(): List<TodoDto> {
        val todos = todoService.getAll()
        return todos.map { TodoDto(it) }
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): TodoDto {
        val todo = todoService.get(id)
        return TodoDto(todo)
    }

    @PostMapping
    fun create(@RequestBody dto: TodoDto): TodoDto {
        val todo = todoService.create(dto)
        return TodoDto(todo)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: TodoDto): TodoDto {
        val todo = todoService.update(dto)
        return TodoDto(todo)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = todoService.delete(id)
}

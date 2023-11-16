package ro.hibyte.todo.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ro.hibyte.todo.dto.TodoDto
import ro.hibyte.todo.entity.Todo
import ro.hibyte.todo.repository.TodoRepository

@Service
class TodoService {

    @Autowired
    private lateinit var todoRepository: TodoRepository

    fun getAll(): List<Todo> = todoRepository.findAll()

    fun get(id: Long): Todo = todoRepository.findById(id).orElseThrow()

    fun create(dto: TodoDto): Todo = todoRepository.save(Todo(dto))

    fun update(dto: TodoDto): Todo {
        val todo = todoRepository.findById(dto.id!!).orElseThrow()

        todo.update(dto)
        return todoRepository.save(todo)
    }

    fun delete(id: Long) = todoRepository.deleteById(id)
}

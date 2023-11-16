package ro.hibyte.todo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ro.hibyte.todo.entity.Todo

interface TodoRepository : JpaRepository<Todo, Long>

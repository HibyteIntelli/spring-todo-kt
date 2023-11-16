package ro.hibyte.todo.entity

import jakarta.persistence.*
import ro.hibyte.todo.dto.TodoDto
import java.sql.Timestamp

@Entity
data class Todo(

    @Id
    @GeneratedValue
    var id: Long? = null,

    @Temporal(TemporalType.TIMESTAMP)
    var dueDate: Timestamp? = null,

    var title: String? = null,

    var description: String? = null,
) {

    constructor(dto: TodoDto) : this(
        id = dto.id,
        dueDate = dto.dueDate?.let { Timestamp.from(it) },
        title = dto.title,
        description = dto.description,
    )

    fun update(dto: TodoDto) {
        dueDate = dto.dueDate?.let { Timestamp.from(it) }
        title = dto.title
        description = dto.description
    }
}


package ro.hibyte.todo.dto

import ro.hibyte.todo.entity.Todo
import java.time.Instant

class TodoDto(
    var id: Long? = null,
    var dueDate: Instant? = null,
    var title: String? = null,
    var description: String? = null,
) {

    constructor(todo: Todo) : this(
        id = todo.id,
        dueDate = todo.dueDate?.toInstant(),
        title = todo.title,
        description = todo.description,
    )
}

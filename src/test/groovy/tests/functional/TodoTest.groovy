package tests.functional

import app.actions.TodoActions
import app.datatypes.Todo
import ru.yandex.qatools.allure.annotations.Features
import ru.yandex.qatools.allure.annotations.Stories
import tests.BaseSpec

@Features("Todo management")
@Stories("User should be able to add new todo")
class TodoTest extends BaseSpec{

    Todo todo = new Todo()

    def "Add new todo"()
    {
        setup:
        todo.userId = 1
        todo.title = "New Todo Item"
        todo.completed = false

        when:
        def todoId = TodoActions.addTodo(todo).data.id

        then:
        TodoActions.getTodoById(todoId).data.title == todo.title
    }
}

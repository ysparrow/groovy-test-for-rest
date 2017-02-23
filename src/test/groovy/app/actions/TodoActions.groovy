package app.actions

import app.datatypes.Todo
import app.datatypes.User
import app.requests.todos.TodoRequest
import app.requests.users.UserRequest
import groovyx.net.http.HttpResponseDecorator
import ru.yandex.qatools.allure.annotations.Step

class TodoActions {

    static HttpResponseDecorator response

    @Step
    def static addTodo(Todo todo) {
        response = TodoRequest.addTodo(todo.userId, todo.title, todo.completed)
        assert response.status == 201
        return response
    }

    @Step
    def static getTodoById(id) {
        response = TodoRequest.getTodoById(id)
        assert response.status == 200
        return response
    }
}

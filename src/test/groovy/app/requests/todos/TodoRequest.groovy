    package app.requests.todos

import app.Settings
import core.RESTClientFactory
import groovyx.net.http.HttpResponseDecorator
import ru.yandex.qatools.allure.annotations.Step

import static groovyx.net.http.ContentType.JSON

class TodoRequest {

    @Step
    def static addTodo(UserId, title, status) {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.getAPP_URL()}/todos").
                post(contentType: JSON, body: MessageBody.getBody(UserId, title, status))
    }

    @Step
    def static getTodoById(id) {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.APP_URL}/todos/${id}").
                get(contentType: JSON)
    }
}

class MessageBody {

    def static getBody(userId, title, status) {
        return """
        {
            "userId": ${userId},
            "title": "${title}",
            "completed": ${status}
        } """
    }
}
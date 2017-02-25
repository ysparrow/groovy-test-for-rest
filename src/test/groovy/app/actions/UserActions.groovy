package app.actions

import app.datatypes.User
import app.requests.users.UserRequest
import groovy.util.logging.Log4j
import groovyx.net.http.HttpResponseDecorator
import ru.yandex.qatools.allure.annotations.Step


@Log4j
class UserActions {

    static HttpResponseDecorator response

    @Step
    def static getAllUsers() {
        response = UserRequest.getAllUsers()
        assert response.status == 200
        return response
    }

    @Step
    def static deleteUser(String id) {
        response = UserRequest.deleteUser(id)
        assert response.status == 200
        return response
    }

    @Step
    def static deleteAllUsers() {
        response = UserRequest.getAllUsers()
        if (response.data != null) {

            log.info("${response.data.size()} users found")

            (response.data.id).each {
                response = UserRequest.deleteUser(it.toString())
                assert response.status == 200
            }

            log.info("Users are deleted")
        }
    }

    @Step
    def static getUserById(String id) {
        response = UserRequest.getUserById(id)
        assert response.status == 200
        return response
    }

    @Step
    def static addUser(User user) {
        response = UserRequest.addUser(user)
        assert response.status == 201
        return response
    }
}

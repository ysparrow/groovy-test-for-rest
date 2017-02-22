package app.actions

import app.datatypes.User
import app.requests.users.UserRequest
import groovyx.net.http.HttpResponseDecorator
import ru.yandex.qatools.allure.annotations.Step

class UserActions {
    public static HttpResponseDecorator response

    @Step
    def static getAllUsers()
    {
        response = UserRequest.getAllUsers()
        assert response.status == 200

        return response
    }

    @Step
    def static getUserById(String id)
    {
        response = UserRequest.getUserById(id)
        assert response.status == 200

        return response
    }


    @Step
    def static addUser(User user)
    {
        response = UserRequest.addUser(user)

        println(response.data)
        assert response.status == 201

        return response
    }

}

package app.requests.users

import app.Settings
import app.datatypes.User
import app.requests.DefaultRequest
import core.RESTClientFactory
import groovyx.net.http.HttpResponseDecorator
import ru.yandex.qatools.allure.annotations.Step

import static groovyx.net.http.ContentType.JSON


class UserRequest extends DefaultRequest {

    @Step
    def static getAllUsers() {
        restClient =  RESTClientFactory.defaultClient("${Settings.getAppUrl()}/users")
        return (HttpResponseDecorator) restClient.get(headers: [cookie: Settings.getCOOKIE()], contentType: JSON )
    }

    @Step
    def static getUserById(String id) {
        restClient =  RESTClientFactory.defaultClient("${Settings.getAppUrl()}/users/${id}")
        return (HttpResponseDecorator) restClient.get(headers: [cookie: Settings.getCOOKIE()], contentType: JSON )
    }

    @Step
    def static addUser(User user) {
        restClient =  RESTClientFactory.defaultClient("${Settings.getAppUrl()}/users")
        return (HttpResponseDecorator) restClient.post(headers: [cookie: Settings.getCOOKIE()], contentType: JSON ,body: UserBody.getBody(user))
    }

}

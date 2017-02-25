package app.requests.users

import app.Settings
import app.datatypes.User

import core.RESTClientFactory
import groovy.json.JsonOutput
import groovyx.net.http.HttpResponseDecorator
import ru.yandex.qatools.allure.annotations.Step

import static groovyx.net.http.ContentType.JSON


class UserRequest {

    @Step
    def static getAllUsers() {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.APP_URL}/users").
                get(headers: [cookie: Settings.getCOOKIE()], contentType: JSON)
    }

    @Step
    def static getUserById(String id) {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.APP_URL}/users/${id}").
                get(headers: [cookie: Settings.getCOOKIE()], contentType: JSON)
    }

    @Step
    def static addUser(User user) {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.getAPP_URL()}/users").
                post(headers: [cookie: Settings.getCOOKIE()], contentType: JSON, body: user)
    }

    @Step
    def static deleteUser(String id) {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.APP_URL}/users/${id}").
                delete(headers: [cookie: Settings.COOKIE], contentType: JSON)
    }
}

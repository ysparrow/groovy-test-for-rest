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

    @Step
    def static deleteUser(String id) {
        restClient =  RESTClientFactory.defaultClient("${Settings.getAppUrl()}/users/${id}")
        return (HttpResponseDecorator) restClient.delete(headers: [cookie: Settings.getCOOKIE()], contentType: JSON)
    }

}

class UserBody {

    def static getBody(User user) {
        return """
    {
    "name": "${user.getName()}",
    "username": "${user.getUsername()}",
    "email": "${user.getEmail()}",
    "address": {
      "street": "",
      "suite": "",
      "city": "",
      "zipcode": "",
      "geo": {
        "lat": "",
        "lng": ""
      }
    },
    "phone": "${user.getPhone()}",
    "website": "${user.getWebsite()}",
    "company": []
    }"""

    }
}
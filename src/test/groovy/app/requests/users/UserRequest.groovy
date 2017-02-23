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

    @Step ("Add user: {1}")
    def static addUser(User user, String name) {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.getAPP_URL()}/users").
                post(headers: [cookie: Settings.getCOOKIE()], contentType: JSON, body: JsonOutput.toJson(user))
        //                                                                       body: MessageBody.getBody(user))
    }

    @Step
    def static deleteUser(String id) {
        return (HttpResponseDecorator) RESTClientFactory.defaultClient("${Settings.APP_URL}/users/${id}").
                delete(headers: [cookie: Settings.COOKIE], contentType: JSON)
    }
}

class MessageBody {

    def static getBody(User user) {
        return """
                {
                    "name": "${user.getName()}",
                    "username": "${user.getUsername()}",
                    "email": "${user.getEmail()}",
                    "address": {
                                    "street": "${user.address.street}",
                                    "suite": "${user.address.suite}",
                                    "city": "${user.address.city}",
                                    "zipcode": "${user.address.zipcode}",
                                "geo": {
                                    "lat": "${user.address.geo.lat}",
                                    "lng": "${user.address.geo.lng}"
                                        }
                                },
                    "phone": "${user.getPhone()}",
                    "website": "${user.getWebsite()}",
                    "company": {
                                    "name": "${user.company.name}",
                                    "catchPhrase": "${user.company.catchPhrase}",
                                    "bs": "${user.company.bs}"
                               }
                }"""
    }
}
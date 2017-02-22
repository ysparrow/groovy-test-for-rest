package tests

import app.actions.UserActions
import app.datatypes.User
import groovy.util.logging.Log4j
import groovyx.net.http.HttpResponseDecorator

@Log4j
class UserServiceTest extends BaseSpec {

    HttpResponseDecorator response

    User user =new User();

    def setup() {

        user.setName("Name")
        user.setUsername("Username")

    }


    def "Test Get all users"() {

        when:
        response = UserActions.addUser(user)

        then:
        response.data.username == user.getUsername()
        response.data.name == user.getName()
    }




}

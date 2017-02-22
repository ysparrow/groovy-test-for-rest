package tests

import app.actions.UserActions
import app.datatypes.User
import groovy.util.logging.Log4j
import groovyx.net.http.HttpResponseDecorator
import spock.lang.Unroll

@Log4j
class UserServiceTest extends BaseSpec {

    HttpResponseDecorator response

    User user = new User();

    def setup() {


    }


    @Unroll
    def "Test Get all users"() {

        setup:
        user.setName(name)
        user.setUsername(username)
        user.setEmail(email)

        when:
        response = UserActions.addUser(user)
        then:
        response.data.username == user.getUsername()
        response.data.name == user.getName()
        response.data.email == user.getEmail()

        when:
        UserActions.deleteUser(response.data.id.toString())
        UserActions.getUserById(response.data.id.toString())

        then:
        def e = thrown(groovyx.net.http.HttpResponseException)
        e.message == 'Not Found'

        where:

        name                | username    | email
        "Named Petro"       | "vasks"     | "zalupka@aaa.ss"
        "Named ewq"         | "veasks"    | "zalupka@aaa.ss"
        "Nqwed Pqwero"      | "vdfsasks"  | "zalupka@aaa.ss"
        "Named Petro"       | "vasksdfs"  | "zalupka@aaa.ss"
        "Nawqeqwed Petro"   | "vasdfsks"  | "zalupka@aaa.ss"
        "Namqweqwd Petro"   | "vask432s"  | "zalupka@aaa.ss"
        "Named Peewqeqwtro" | "vas6543ks" | "zalupka@aaa.ss"
    }


}

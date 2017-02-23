package tests.functional

import app.actions.UserActions
import app.datatypes.User
import groovyx.net.http.HttpResponseDecorator
import spock.lang.Unroll
import tests.BaseSpec

class UserTest extends BaseSpec{


    HttpResponseDecorator response, resp2

    User user = new User();

    def setup() {


    }

    @Unroll
    def "Test Get all users"() {

        setup:
        user.name = name
        user.username =username
        user.email = email
        user.address.geo.lat="12.32"
        user.address.geo.lng="34.44"
        user.address.street="sdddddd"
        user.company.catchPhrase=""



        when:
        response = UserActions.addUser(user)
        then:
        response.data.username == user.username
        response.data.name == user.name
        response.data.email == user.email

        when:
        UserActions.deleteUser(response.data.id.toString())
        UserActions.getUserById(response.data.id.toString())

        then:
        def e = thrown(groovyx.net.http.HttpResponseException)
        e.message == 'Not Found'

        where:

        name                | username    | email
        "Named Petro"       | "vasks"     | "dsafs@sd"
        "Named ewq"         | "veasks"    | "dsafs@aaa.ss"
        "Nqwed Pqwero"      | "vdfsasks"  | "dsafs@aaa.ss"
        "Named Petro"       | "vasksdfs"  | "dsafs@aaa.ss"
        "Nawqeqwed Petro"   | "vasdfsks"  | "dsafs@aaa.ss"
        "Namqweqwd Petro"   | "vask432s"  | "dsafs@aaa.ss"
        "Named Peewqeqwtro" | "vas6543ks" | "dsafs@aaa.ss"
    }

}

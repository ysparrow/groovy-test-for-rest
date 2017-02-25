package tests.functional

import app.actions.UserActions
import app.datatypes.User
import groovy.util.logging.Log4j
import groovyx.net.http.HttpResponseDecorator
import ru.yandex.qatools.allure.annotations.Features
import ru.yandex.qatools.allure.annotations.Step
import ru.yandex.qatools.allure.annotations.Stories
import spock.lang.Stepwise
import spock.lang.Unroll
import tests.BaseSpec

@Log4j
@Features("User management")
@Stories("Customer should be able to Add/Delete User entity")
class UserTest extends BaseSpec {

    HttpResponseDecorator response
    User user = new User();

    def setupSpec() {
        UserActions.deleteAllUsers()
    }

    @Unroll
    def "Create new user: #name"() {

        setup:
        user.name = name
        user.username = username
        user.email = email
        user.phone = phone
        user.website = website
        user.company.name = companyname

        when:
        def userId = UserActions.addUser(user).data.id.toString()
        response = UserActions.getUserById(userId)

        then:
        verifyUserData(response, user)

        where:
        name              | username | email             | phone          | website          | companyname
        "John Dou"        | "jdou"   | "jdou@mail.com"   | "0-800-500-50" | "www.site.name"  | "Site Company"
        "Peter Bro"       | ""       | "single@mail.com" | "0-800-500-51" | "www.site2.name" | "Erricson"
        "Василь Петрович" | "vpetr"  | ""                | "0-800-500-52" | "www.site4.name" | "АБТ"
        ""                | "none"   | "none@mail.com"   | ""             | "www.site5.name" | "Сільпо"
        "Бабагаля"        | "bgalya" | "bgalya@mail.com" | "0-800-500-54" | ""               | "Школа 23"
    }

    def "Verify that 5 users where created on previous step"() {
        expect:
        UserActions.getAllUsers().data.size() == 5
    }

    def "Explicitly verify delete user"() {
        setup:
        UserActions.deleteAllUsers()

        when:
        UserActions.addUser(user)

        then:
        UserActions.getAllUsers().data.size == 1

        when:
        UserActions.deleteUser("1")

        then:
        UserActions.getAllUsers().data.size == 0
    }

    void verifyUserData(response, user) {
        assert response.data.username == user.username
        assert response.data.name == user.getName()
        assert response.data.email == user.email
        assert response.data.phone == user.phone
        assert response.data.website == user.website
        assert response.data.company.name == user.company.name
    }
}

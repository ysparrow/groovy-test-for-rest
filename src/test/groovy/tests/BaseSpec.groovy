package tests

import app.Settings
import groovy.util.logging.Log4j
import ru.yandex.qatools.allure.annotations.Step
import spock.lang.Specification

@Log4j
class BaseSpec extends Specification {

    @Step
    def setupSpec() {
        log.info("Test Preparation Started")
        Settings.logSettings()
    }

    @Step
    def cleanupSpec() {
        log.info("All Tests Finished")
    }
}

package tests

import app.Settings
import groovy.util.logging.Log4j
import spock.lang.Specification

@Log4j
class BaseSpec extends Specification {

    def setupSpec() {
        log.info("Test Preparation Started")
        Settings.logSettings()
    }

    def cleanupSpec() {
        log.info("All Tests Finished")
    }
}

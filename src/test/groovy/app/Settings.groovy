package app

import core.ConfigReader
import groovy.util.logging.Log4j
import ru.qatools.properties.PropertyLoader

@Log4j
class Settings {

    static ConfigReader config = PropertyLoader.newInstance().populate(ConfigReader.class);

    static String APP_URL = config.getAppUrl()
    static String COOKIE = "";

    def static logSettings ()
    {
        config.getProperties().each{log.info(it)}
    }
}

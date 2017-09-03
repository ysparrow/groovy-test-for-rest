package core

import ru.qatools.properties.*;

@Resource.Classpath("test.properties")
interface ConfigReader {

    @Property("app.url")
    String getAppUrl();

}

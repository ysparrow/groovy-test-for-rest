package core

import ru.qatools.properties.*;

@Resource.Classpath("test.properties")
public interface ConfigReader {

    @Property("app.url")
    String getAppUrl();

}

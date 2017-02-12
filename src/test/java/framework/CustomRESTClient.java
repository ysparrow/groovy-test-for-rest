package framework;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import groovyx.net.http.RESTClient;

/**
 * Proxy for RESTClient which allows to send DELETE request with body message
 **/
public class CustomRESTClient extends RESTClient {

    private static class HttpDeleteWithEntity extends HttpEntityEnclosingRequestBase {
        public final static String METHOD_NAME = "DELETE";

        @Override
        public String getMethod() {
            return METHOD_NAME;
        }
    }

    public CustomRESTClient(Object defaultURI) throws URISyntaxException {
        super(defaultURI);
    }

    @Override
    public Object delete(Map<String, ?> args) throws URISyntaxException, ClientProtocolException, IOException {
        return doRequest(new RequestConfigDelegate(args, new HttpDeleteWithEntity(), null));
    }
}
package framework.restclient

import groovyx.net.http.HttpURLClient
import groovyx.net.http.ContentEncoding
import groovyx.net.http.RESTClient

class RESTClientFactory {

/*
 * @param defaultURI default request URI (String, URI, URL or {@link URIBuilder})
 *
 */

    public static RESTClient defaultClient(Object defaultURI) {
        RESTClient client = new RESTClient(defaultURI, "application/json;charset=utf-8")
        client.setContentEncoding(ContentEncoding.Type.GZIP, ContentEncoding.Type.DEFLATE)
        return client
    }
}

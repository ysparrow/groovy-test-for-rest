package core

import groovyx.net.http.ContentEncoding
import groovyx.net.http.RESTClient

class RESTClientFactory {

    public static RESTClient defaultClient(def defaultURI) {
        RESTClient client = new RESTClient(defaultURI, "application/json;charset=utf-8")
        client.setContentEncoding(ContentEncoding.Type.GZIP, ContentEncoding.Type.DEFLATE)
        return client
    }
}

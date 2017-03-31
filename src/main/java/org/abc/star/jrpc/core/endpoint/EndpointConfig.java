package org.abc.star.jrpc.core.endpoint;

import org.abc.star.jrpc.core.Configuration;

/**
 * Created by whs on 2017/3/31.
 */
public class EndpointConfig extends Configuration {
    private static final String ENDPOINT_ID = "endpoint.id";

    private static final String ENDPOINT_NAME = "endpoint.name";

    private static final String DEFAULT_TIMEOUT_KEY = "default.timeout";

    private static final int DEFAULT_TIMEOUT = 3000;

    public EndpointConfig() {
        super();
    }

    public EndpointConfig(Configuration config) {
        super(config);
    }

    public EndpointConfig(String configLocation) {
        super(configLocation);
    }

    public EndpointConfig setDefaultTimeout(int defaultTimeout) {
        setInt(DEFAULT_TIMEOUT_KEY, defaultTimeout);
        return this;
    }

    public int getDefaultTimeout() {
        return getInt(DEFAULT_TIMEOUT_KEY, DEFAULT_TIMEOUT);
    }

    public EndpointConfig setEndpointId(String id) {
        set(ENDPOINT_ID, id);
        return this;
    }

    public EndpointConfig setEndpointName(String name) {
        set(ENDPOINT_NAME, name);
        return this;
    }

    public String getEndpointId() {
        return get(ENDPOINT_ID);
    }

    public String getEndpointName() {
        return get(ENDPOINT_NAME);
    }
}

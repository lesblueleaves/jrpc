package org.abc.star.jrpc.core.registry;

import org.abc.star.jrpc.core.Configuration;

/**
 * Created by whs on 2017/3/30.
 */
public class RegistryConfig extends Configuration {
    private String schema;

    public RegistryConfig() {
        super();
    }

    public RegistryConfig(Configuration config) {
        super();
    }

    public RegistryConfig(String configLocation) {
        super(configLocation);
    }

    public String getSchema() {
        return schema;
    }

    public RegistryConfig setSchema(String schema) {
        this.schema = schema;
        return this;
    }
}

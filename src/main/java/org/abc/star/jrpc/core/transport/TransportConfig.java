package org.abc.star.jrpc.core.transport;

import org.abc.star.jrpc.core.Configuration;
import org.abc.star.jrpc.core.serializer.SerializeType;

/**
 * Created by whs on 2017/3/30.
 */
public class TransportConfig extends Configuration {
    // max size
    private static final String MAX_SIZE = "rpc.max.size";

    // serialize type
    private static final String SERIALIZE_TYPE = "rpc.serialize.type";

    // Connect Timeout
    private static final String CONNECT_TIMEOUT = "rpc.connect.timeout";

    private static final String HEARTBEAT_INTERVAL_SECONDS = "heartbeat.interval.seconds";

    private static final String CONNECT_POOL_SIZE = "connect.pool.size";

    // parallel count
    private static final String BUSINESS_PROCESSOR_COUNT = "business.processor.count";

    private static final String NIO_PROCESSOR_COUNT = "nio.processor.count";

    private static final String MAX_CONNECTION_COUNT = "max.connection.count";

    // transport schema, default is 'mina'
    private String schema = "mina";

    public TransportConfig() {

    }

    public TransportConfig(Configuration config) {
        super(config);
    }

    public TransportConfig(String configLocation) {
        super(configLocation);
    }

    public int getMaxSize() {
        return getInt(MAX_SIZE, Integer.MAX_VALUE);
    }

    public TransportConfig setMaxSize(int maxSize) {
        setInt(MAX_SIZE, maxSize);
        return this;
    }

    public TransportConfig setSerializeType(SerializeType type) {
        set(SERIALIZE_TYPE, type.name());
        return this;
    }


    public SerializeType getSerializeType() {
        String name = get(SERIALIZE_TYPE, SerializeType.JACKSON.name()).toUpperCase();
        return SerializeType.valueOf(name);
    }

    public int getConnectTimeout() {
        return getInt(CONNECT_TIMEOUT, 30000);
    }

    public TransportConfig setConnectTimeout(int timeout) {
        setInt(CONNECT_TIMEOUT, timeout);
        return this;
    }

    public TransportConfig setSchema(String schema) {
        if (schema != null && !schema.isEmpty()) {
            this.schema = schema;
        }
        return this;
    }

    public String getSchema() {
        return schema;
    }

    public int getHeartbeatIntervalSeconds() {
        return getInt(HEARTBEAT_INTERVAL_SECONDS, 60);
    }

    public TransportConfig setHeartbeatIntervalSeconds(int interval) {
        setInt(HEARTBEAT_INTERVAL_SECONDS, interval);
        return this;
    }

    public int getConnectPoolSize() {
        return getInt(CONNECT_POOL_SIZE, 2);
    }

    public TransportConfig setConnectPoolSize(int size) {
        if (size > 0) {
            setInt(CONNECT_POOL_SIZE, size);
        }
        return this;
    }

    public int getNioProcessorCount() {
        return getInt(NIO_PROCESSOR_COUNT, Runtime.getRuntime().availableProcessors());
    }

    public TransportConfig setNioProcessorCount(int count) {
        if (count > 0) {
            setInt(NIO_PROCESSOR_COUNT, count);
        }
        return this;
    }

    public int getBusinessProcessorCount() {
        return getInt(BUSINESS_PROCESSOR_COUNT, 0);
    }

    public TransportConfig setBusinessProcessorCount(int count) {
        setInt(BUSINESS_PROCESSOR_COUNT, count);
        return this;
    }

    public int getMaxConnectionCount() {
        return getInt(MAX_CONNECTION_COUNT, 1000);
    }

    public TransportConfig setMaxConnectionCount(int count) {
        if (count > 0) {
            setInt(MAX_CONNECTION_COUNT, count);
        }
        return this;
    }
}

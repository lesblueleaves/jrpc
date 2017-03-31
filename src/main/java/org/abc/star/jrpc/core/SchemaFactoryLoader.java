package org.abc.star.jrpc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by whs on 2017/3/28.
 */
public class SchemaFactoryLoader<T> {
    private static final Logger LOG = LoggerFactory.getLogger(SchemaFactoryLoader.class);

    private static ConcurrentHashMap<Class<?>, SchemaFactoryLoader> loaderMap = new ConcurrentHashMap<>();

    public static <T> SchemaFactoryLoader<T> getInstance(Class<T> type) {
        if (!type.isInterface()) {
            throw new IllegalArgumentException(type.getName() + " is not interface");
        }
        if (!SchemaFactory.class.isAssignableFrom(type)) {
            throw new IllegalArgumentException(type.getName() + " is not " + SchemaFactory.class.getName());
        }
        SchemaFactoryLoader<T> loader = loaderMap.get(type);
        if (loader == null) {
            loaderMap.putIfAbsent(type, new SchemaFactoryLoader(type));
            loader = loaderMap.get(type);
        }
        return loader;
    }

    private final ConcurrentHashMap<String, T> schemaFactoryMap = new ConcurrentHashMap<>();

    private SchemaFactoryLoader(Class<T> type) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(type);
        for (T factory : serviceLoader) {
            String schema = ((SchemaFactory) factory).getSchema();
            LOG.info("load {} provider for schema:{}", type.getSimpleName(), schema);
            schemaFactoryMap.put(schema, factory);
        }
    }

    public T getSchemaFactory(String schema) {
        return schemaFactoryMap.get(schema);
    }

}

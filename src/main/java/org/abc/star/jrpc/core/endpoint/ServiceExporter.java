package org.abc.star.jrpc.core.endpoint;

/**
 * Created by whs on 2017/3/31.
 */
public interface ServiceExporter {
    public abstract <T> void exportService(Class<T> serviceInterface, T serviceImplement);

    public abstract <T> void exportService(Class<T> serviceInterface, String group, T serviceImplement);

    public abstract <T> void exportService(Class<T> serviceInterface, String group, int timeout, T serviceImplement);

    public abstract void destroy();
}

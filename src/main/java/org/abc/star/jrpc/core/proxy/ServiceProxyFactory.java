package org.abc.star.jrpc.core.proxy;

/**
 * Created by whs on 2017/3/29.
 */
public interface ServiceProxyFactory {
    public <T> ServiceProxy<T> create(Class<T> service, String group, int timeout, T instance) throws Exception;
}

package org.abc.star.jrpc.core.proxy;

/**
 * Created by whs on 2017/3/29.
 */
public class SkeletonProxyFactory implements ServiceProxyFactory {

    public SkeletonProxyFactory() {

    }

    @Override
    public <T> ServiceProxy<T> create(Class<T> serviceInterface, String group, int timeout, T serviceObject) throws Exception {
        if (!serviceInterface.isInterface()) {
            throw new IllegalArgumentException(serviceInterface.getName() + " is not interface");
        }
        if (!serviceInterface.isInstance(serviceObject)) {
            throw new IllegalArgumentException(serviceObject + " is not an instance of " + serviceInterface);
        }
        return new ServiceProxy<T>(serviceInterface, group, timeout, serviceObject);
    }
}

package org.abc.star.jrpc.core.registry;

/**
 * Created by whs on 2017/3/30.
 */
public interface ServiceRegistry {

    public void register(ServiceDescription service) throws Exception;

    public void unregister(ServiceDescription service) throws Exception;

    public void destroy();
}

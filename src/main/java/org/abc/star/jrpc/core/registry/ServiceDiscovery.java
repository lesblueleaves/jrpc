package org.abc.star.jrpc.core.registry;

import java.util.List;

/**
 * Created by whs on 2017/3/30.
 */
public interface ServiceDiscovery {
    public abstract void destroy();

    public abstract void cancel(ServiceDescription description);

    public abstract void listen(ServiceDescription description) throws Exception;

    public abstract List<ServiceDescription> discovery(String serviceName) throws Exception;
}

package org.abc.star.jrpc.core.registry;

import org.abc.star.jrpc.core.SchemaFactory;

import javax.imageio.spi.ServiceRegistry;

/**
 * Created by whs on 2017/3/30.
 */
public interface RegistryFactory extends SchemaFactory {
    public abstract ServiceRegistry createServiceRegistry(RegistryConfig registryConfig);

    public abstract ServiceDiscovery createServiceDiscovery(RegistryConfig registryConfig);
}

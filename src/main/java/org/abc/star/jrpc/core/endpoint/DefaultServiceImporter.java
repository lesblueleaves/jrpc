package org.abc.star.jrpc.core.endpoint;

import org.abc.star.jrpc.core.binding.ReferenceBinding;
import org.abc.star.jrpc.core.invoker.StubServiceInvoker;
import org.abc.star.jrpc.core.proxy.ServiceProxyFactory;
import org.abc.star.jrpc.core.proxy.StubProxyFactory;
import org.abc.star.jrpc.core.transport.ConnectionManager;
import org.abc.star.jrpc.core.transport.TransportConfig;

/**
 * Created by whs on 2017/3/31.
 */
public class DefaultServiceImporter implements ServiceImporter {

    private final EndpointConfig endpointConfig;

    private final ReferenceBinding referenceBinding;

    private final ConnectionManager connectionManager;

//    private final ServiceProxyFactory serviceProxyFactory;

    public DefaultServiceImporter(EndpointConfig endpointConfig, TransportConfig transportConfig,
                                  ReferenceBinding referenceBinding) {
        if (endpointConfig == null) {
            throw new IllegalArgumentException("endpointConfig is null");
        }
        this.endpointConfig = endpointConfig;

        if (transportConfig == null) {
            throw new IllegalArgumentException("transportConfig is null");
        }
        this.connectionManager = new ConnectionManager(transportConfig);

        if (referenceBinding == null) {
            throw new IllegalArgumentException("referenceBinding is null");
        }
        this.referenceBinding = referenceBinding;
//        this.serviceProxyFactory = new StubProxyFactory(new StubServiceInvoker());
    }

    @Override
    public <T> T importService(Class<T> sic) {
        return null;
    }

    @Override
    public <T> T importService(Class<T> sic, String group) {
        return null;
    }

    @Override
    public <T> T importService(Class<T> sic, String group, int timeout) {
        return null;
    }

    @Override
    public void destroy() {

    }
}

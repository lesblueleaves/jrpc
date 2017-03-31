package org.abc.star.jrpc.core.binding;

import org.abc.star.jrpc.core.endpoint.EndpointConfig;
import org.abc.star.jrpc.core.proxy.ServiceProxy;

import java.net.InetSocketAddress;

/**
 * Created by whs on 2017/3/31.
 */
public interface ReferenceBinding {

    public <T> void bind(ServiceProxy<T> wrapper, EndpointConfig endpointConfig);

    public <T> InetSocketAddress getServiceAddress();

    public void destroy();
}

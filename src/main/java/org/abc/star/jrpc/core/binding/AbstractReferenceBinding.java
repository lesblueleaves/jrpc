package org.abc.star.jrpc.core.binding;

import org.abc.star.jrpc.core.endpoint.EndpointConfig;
import org.abc.star.jrpc.core.proxy.ServiceProxy;
import org.abc.star.jrpc.core.registry.ServiceDiscovery;
import org.abc.star.jrpc.core.transport.NetworkAddressUtil;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by whs on 2017/3/31.
 */
public class AbstractReferenceBinding implements ReferenceBinding{
    private final AtomicInteger index = new AtomicInteger(0);

    protected InetSocketAddress consumerAddress;

    protected ServiceDiscovery serviceDiscovery;

    protected List<InetSocketAddress> backupServiceAddresses = new ArrayList<>();

    public AbstractReferenceBinding() {
        try {
            InetAddress addr = NetworkAddressUtil.getPrivateInetAddress().get(0);
            consumerAddress = new InetSocketAddress(addr, 0);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> void bind(ServiceProxy<T> wrapper, EndpointConfig endpointConfig) {
        if (serviceDiscovery != null) {

        }
    }

    @Override
    public <T> InetSocketAddress getServiceAddress() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

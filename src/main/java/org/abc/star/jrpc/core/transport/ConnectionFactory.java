package org.abc.star.jrpc.core.transport;

import org.abc.star.jrpc.core.SchemaFactory;

import java.net.InetSocketAddress;

/**
 * Created by whs on 2017/3/30.
 */
public interface ConnectionFactory extends SchemaFactory {
    public abstract Connection create(TransportConfig transportConfig, InetSocketAddress sa);
}

package org.abc.star.jrpc.core.transport;

import org.abc.star.jrpc.core.protocol.Call;

import java.net.InetSocketAddress;

/**
 * Created by whs on 2017/3/30.
 */
public interface Connection {
    public ResultFuture call(Call call);

    public InetSocketAddress getRemoteAddress();

    public InetSocketAddress getLocalAddress();

    public boolean isAlive();

    public void destroy();
}

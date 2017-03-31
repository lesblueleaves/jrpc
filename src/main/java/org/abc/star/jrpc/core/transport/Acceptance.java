package org.abc.star.jrpc.core.transport;

import org.abc.star.jrpc.core.protocol.Request;
import org.abc.star.jrpc.core.protocol.Response;

/**
 * Created by whs on 2017/3/29.
 */
public interface Acceptance {
    public abstract Response handle(Request request);

    Acceptance bind();

    void destroy();
}

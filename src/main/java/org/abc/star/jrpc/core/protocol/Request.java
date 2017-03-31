package org.abc.star.jrpc.core.protocol;

import org.abc.star.jrpc.core.serializer.SerializeType;

import java.io.Serializable;

/**
 * Created by whs on 2017/3/29.
 */
public class Request extends Message<Call> implements Serializable {
    private static final long serialVersionUID = 1L;

    public Request(int messageId, SerializeType serializeType, Call call) {
        super(messageId, serializeType, MessageType.REQUEST, call);
    }

    public String getMethod() {
        return content.getMethod();
    }

    public Object[] getParams() {
        return content.getParams();
    }

    public Call getCall() {
        return content;
    }
}

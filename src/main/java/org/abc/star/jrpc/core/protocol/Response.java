package org.abc.star.jrpc.core.protocol;

import org.abc.star.jrpc.core.serializer.SerializeType;

import java.io.Serializable;

/**
 * Created by whs on 2017/3/29.
 */
public class Response extends Message<Result> implements Serializable {
    private static final long serialVersionUID = 1L;

    public Response(int messageId, SerializeType serializeType, Result result) {
        super(messageId, serializeType, MessageType.RESPONSE, result);
    }

    public Result getResult() {
        return content;
    }
}

package org.abc.star.jrpc.core.protocol;

import org.abc.star.jrpc.core.serializer.SerializeType;

import java.io.Serializable;

/**
 * Created by whs on 2017/3/29.
 */
public class Heartbeat extends Message<Tick> implements Serializable {
    private static final long serialVersionUID = 1L;

    public Heartbeat(int messageId, SerializeType serializeType, Tick content) {
        super(messageId, serializeType, MessageType.HEARTBEAT, content);
    }

}

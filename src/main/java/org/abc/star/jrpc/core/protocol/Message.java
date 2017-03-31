package org.abc.star.jrpc.core.protocol;

import org.abc.star.jrpc.core.serializer.SerializeType;

import java.io.Serializable;

/**
 * Created by whs on 2017/3/29.
 */
public abstract class Message<C extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int messageId;

    private MessageType messageType;

    private SerializeType serializeType;

    protected C content;

    public Message(int messageId, SerializeType serializeType, MessageType messageType, C content) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.serializeType = serializeType;
        this.content = content;
    }

    public int getMessageId() {
        return messageId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public SerializeType getSerializeType() {
        return serializeType;
    }

    public C getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageType=" + messageType +
                ", serializeType=" + serializeType +
                ", content=" + content +
                '}';
    }
}

package org.abc.star.jrpc.core.protocol;

/**
 * Created by whs on 2017/3/29.
 */
public enum MessageType {
    REQUEST((byte) 1), RESPONSE((byte) 2), HEARTBEAT((byte) 3);

    private byte value;

    private MessageType(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public static MessageType valueOf(int value) {
        switch (value) {
            case 1:
                return REQUEST;
            case 2:
                return RESPONSE;
            case 3:
                return HEARTBEAT;
            default:
                break;
        }
        throw new IllegalArgumentException("unsupported message type [" + value + "]");
    }

}

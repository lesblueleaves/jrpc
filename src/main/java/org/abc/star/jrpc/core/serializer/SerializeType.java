package org.abc.star.jrpc.core.serializer;

/**
 * Created by whs on 2017/3/29.
 */
public enum SerializeType {
    JACKSON((byte) 1), PROTOBUFF((byte) 2);
    private byte value;

    private SerializeType(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public static SerializeType valueOf(int type) {
        switch (type) {
            case 1:
                return JACKSON;
            case 2:
                return PROTOBUFF;
            default:
                break;
        }
        throw new IllegalArgumentException("unsupported serialize type [" + type + "]");
    }
}

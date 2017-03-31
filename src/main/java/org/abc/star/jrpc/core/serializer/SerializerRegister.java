package org.abc.star.jrpc.core.serializer;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by whs on 2017/3/29.
 */
public class SerializerRegister {
    private static SerializerRegister INSTANCE = new SerializerRegister();

    private Map<SerializeType, Serializer> serializerMap = new EnumMap<SerializeType, Serializer>(SerializeType.class);

    public static SerializerRegister getInstance() {
        return INSTANCE;
    }

    protected SerializerRegister() {
        regist(SerializeType.JACKSON, new JacksonSerializer());
    }

    public void regist(SerializeType type, Serializer serializer) {
        serializerMap.put(type, serializer);
    }

    public Serializer find(SerializeType serializeType) {
        return serializerMap.get(serializeType);
    }

}

package org.abc.star.jrpc.core.serializer;

/**
 * Created by whs on 2017/3/29.
 */
public interface Serializer {
    public <T> byte[] serialize(T data) throws Exception;

    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws Exception;

    public <T> T deserialize(byte[] bytes, int offset, int length, Class<T> clazz) throws Exception;

}

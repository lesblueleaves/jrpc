package org.abc.star.jrpc.core.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by whs on 2017/3/29.
 */
public class JacksonSerializer implements Serializer {

    private ObjectMapper objectMapper;

    public JacksonSerializer() {
        objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();
//        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    @Override

    public <T> byte[] serialize(T data) throws Exception {
        return objectMapper.writeValueAsBytes(data);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws Exception {
        return objectMapper.readValue(bytes, clazz);
    }

    @Override
    public <T> T deserialize(byte[] bytes, int offset, int length, Class<T> clazz) throws Exception {
        return objectMapper.readValue(bytes, offset, length, clazz);
    }
}

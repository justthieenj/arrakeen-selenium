package io.github.justthieenj.arrakeenselenium.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.InputStream;
import java.util.Collection;

public class JsonUtils {
    public static <T> T getObject(InputStream file, Class<T> clazz) {
        T object;
        try {
            var mapper = new ObjectMapper();
            object = mapper.readValue(file, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public static ObjectNode getObjectNode(InputStream file) {
        ObjectNode objectNode;
        try {
            var mapper = new ObjectMapper();
            objectNode = mapper.readTree(file).deepCopy();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return objectNode;
    }

    public static <T> Collection<T> getCollection(InputStream file, Class<T> clazz) {
        Collection<T> collection;
        try {
            var mapper = new ObjectMapper();
            collection = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(Collection.class, clazz));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return collection;
    }
}

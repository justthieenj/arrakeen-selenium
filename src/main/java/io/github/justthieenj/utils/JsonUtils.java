package io.github.justthieenj.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class JsonUtils {
    public static <T> T getObject(String filePath, Class<T> clazz) {
        T object;
        try {
            ObjectMapper mapper = new ObjectMapper();
            object = mapper.readValue(new File(filePath), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public static ObjectNode getObjectNode(String filePath) {
        ObjectNode object;
        try {
            ObjectMapper mapper = new ObjectMapper();
            object = mapper.readTree(new File(filePath)).deepCopy();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}

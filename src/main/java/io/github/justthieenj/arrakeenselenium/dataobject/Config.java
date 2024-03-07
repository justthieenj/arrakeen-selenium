package io.github.justthieenj.arrakeenselenium.dataobject;


import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.justthieenj.arrakeenselenium.utils.JsonUtils;
import lombok.Data;

import java.io.IOException;

@Data
public class Config {
    private String browser;
    private boolean headless;
    private boolean savePageSource;
    private long timeout;
    private long checkTimeout;
    private long navigationTimeout;
    private String baseUrl;

    private static Config instance;
    private static ObjectNode objectNode;

    public static Config get() {
        try (var inputStream = Config.class.getClassLoader().getResourceAsStream("config.json")) {
            return instance = instance != null ? instance : JsonUtils.getObject(inputStream, Config.class);
        } catch (IOException e) {
            throw new RuntimeException("config.json not found in resources folder");
        }
    }

    public static ObjectNode getObjectNode() {
        try (var inputStream = Config.class.getClassLoader().getResourceAsStream("config.json")) {
            return objectNode = objectNode != null ? objectNode : JsonUtils.getObjectNode(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("config.json not found in resources folder");
        }
    }
}

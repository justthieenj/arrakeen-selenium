package io.github.justthieenj.arrakeenselenium.dataobject;


import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.justthieenj.arrakeenselenium.utils.JsonUtils;
import lombok.Data;

import java.util.Objects;

@Data
public class Config {
    private String keenBrowser;
    private boolean keenHeadless;
    private boolean keenSavePageSource;
    private long keenTimeout;
    private long keenNavigationTimeout;
    private String keenBaseUrl;

    private static final String FULL_PATH = Objects.requireNonNull(Config.class.getClassLoader().getResource("config.json")).getPath();
    private static Config instance;
    private static ObjectNode objectNode;

    public static Config get() {
        return instance = instance != null ? instance : JsonUtils.getObject(FULL_PATH, Config.class);
    }

    public static ObjectNode getObjectNode() {
        return objectNode = objectNode != null ? objectNode : JsonUtils.getObjectNode(FULL_PATH);
    }
}

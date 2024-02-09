package io.github.justthieenj.arrakeenselenium.utils;

import io.github.justthieenj.arrakeenselenium.dataobject.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PropertyUtils {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void initSystemProperties() {
        var jsonNode = Config.getObjectNode();
        LOGGER.info("Initializing system properties from json file...");
        var keys = new ArrayList<String>();
        jsonNode.fieldNames().forEachRemaining(keys::add);
        // set system properties from json file if not exists
        var setKeys = new ArrayList<String>(); // for logging purpose
        keys.forEach(key -> {
            if (System.getProperty(key) == null) {
                var value = jsonNode.get(key).asText();
                System.setProperty(key, value);
                setKeys.add(key);
            }
        });
        LOGGER.info("System properties initialized: {}", setKeys);
    }
}

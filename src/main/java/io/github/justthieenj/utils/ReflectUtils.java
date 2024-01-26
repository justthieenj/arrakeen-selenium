package io.github.justthieenj.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class ReflectUtils {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Initialize an object with the given class if the object is not initialized yet
     *
     * @param object the object to initialize
     * @param clz    the class of the object
     * @return the initialized object, if it already initialized, return the object itself
     */
    public static <T> T initObject(T object, Class<T> clz) {
        return Optional.ofNullable(object).orElseGet(() -> createInstance(clz));
    }

    private static <T> T createInstance(Class<T> clz) {
        try {
            return clz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            LOGGER.error("Failed to initialize page object %s".formatted(clz.getSimpleName()));
            throw new RuntimeException(e);
        }
    }

    /**
     * Get property from system property if it is set, otherwise get from config file
     *
     * @param key         key of property
     * @param configValue value from config file
     * @param clz         type of property
     * @return property value
     */
    public static <T> T getProperty(String key, Object configValue, Class<T> clz) {
        T value;
        var prop = System.getProperty(key);
        if (prop == null) value = clz.cast(configValue);
        else value = switch (clz.getSimpleName()) {
            case "String" -> clz.cast(prop);
            case "Boolean" -> clz.cast(Boolean.parseBoolean(prop));
            case "Integer" -> clz.cast(Integer.parseInt(prop));
            case "Long" -> clz.cast(Long.parseLong(prop));
            case "Double" -> clz.cast(Double.parseDouble(prop));
            default -> throw new IllegalArgumentException("Unsupported class type: " + clz.getSimpleName());
        };
        return value;
    }

    public static String getProperty(String key, Object configValue) {
        // default to String
        return getProperty(key, configValue, String.class);
    }
}

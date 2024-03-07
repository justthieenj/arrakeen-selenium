package io.github.justthieenj.arrakeenselenium.utils;

import io.github.justthieenj.arrakeenselenium.dataobject.Config;
import io.github.justthieenj.arrakeenselenium.enums.Browser;

public class ArrakeenConfig {
    private static final Config CONFIG = Config.get();
    public static final Browser BROWSER = Browser.fromStr(ReflectUtils.getProperty("browser", CONFIG.getBrowser()));
    public static final boolean HEADLESS = ReflectUtils.getProperty("headless", CONFIG.isHeadless(), Boolean.class);
    public static final boolean SAVE_PAGE_SOURCE = ReflectUtils.getProperty("savePageSource", CONFIG.isSavePageSource(), Boolean.class);
    // timeout for waiting element to interact
    public static final long TIMEOUT = ReflectUtils.getProperty("timeout", CONFIG.getTimeout(), Long.class);
    // timeout for checking element state
    public static final long CHECK_TIMEOUT = ReflectUtils.getProperty("checkTimeout", CONFIG.getCheckTimeout(), Long.class);
    public static final long NAVIGATION_TIMEOUT = ReflectUtils.getProperty("navigationTimeout", CONFIG.getNavigationTimeout(), Long.class);
    public static final String BASE_URL = ReflectUtils.getProperty("baseUrl", CONFIG.getBaseUrl());
}

package io.github.justthieenj.arrakeenselenium.utils;

import io.github.justthieenj.arrakeenselenium.dataobject.Config;
import io.github.justthieenj.arrakeenselenium.enums.Browser;

public class ArrakeenConfig {
    private static final Config CONFIG = Config.get();
    public static final Browser BROWSER = Browser.fromStr(ReflectUtils.getProperty("keenBrowser", CONFIG.getKeenBrowser()));
    // timeout for waiting element to interact
    public static final long TIMEOUT = ReflectUtils.getProperty("keenTimeout", CONFIG.getKeenTimeout(), Long.class);
    // timeout for checking element state
    public static final long CHECK_TIMEOUT = 4000;
    public static final long NAVIGATION_TIMEOUT = ReflectUtils.getProperty("keenNavigationTimeout", CONFIG.getKeenNavigationTimeout(), Long.class);
    public static final boolean HEADLESS = ReflectUtils.getProperty("keenHeadless", CONFIG.isKeenHeadless(), Boolean.class);
    public static final boolean SAVE_PAGE_SOURCE = ReflectUtils.getProperty("keenSavePageSource", CONFIG.isKeenSavePageSource(), Boolean.class);
    public static final String BASE_URL = ReflectUtils.getProperty("keenBaseUrl", CONFIG.getKeenBaseUrl());
}

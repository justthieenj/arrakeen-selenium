package io.github.justthieenj.arrakeenselenium.utils;

import io.github.justthieenj.arrakeenselenium.dataobject.Config;
import io.github.justthieenj.arrakeenselenium.enums.Browser;

public class ArrakeenConfig {
    public static final Config CONFIG = Config.get();
    public static final Browser BROWSER = Browser.fromStr(ReflectUtils.getProperty("keenBrowser", CONFIG.getKeenBrowser()));
    public static final long TIMEOUT = ReflectUtils.getProperty("keenTimeout", CONFIG.getKeenTimeout(), Long.class);
    public static final long NAVIGATION_TIMEOUT = 60000;
    public static final boolean HEADLESS = ReflectUtils.getProperty("keenHeadless", CONFIG.isKeenHeadless(), Boolean.class);
    public static final boolean SAVE_PAGE_SOURCE = ReflectUtils.getProperty("keenSavePageSource", CONFIG.isKeenSavePageSource(), Boolean.class);
    public static final String BASE_URL = ReflectUtils.getProperty("keenBaseUrl", CONFIG.getKeenBaseUrl());
}

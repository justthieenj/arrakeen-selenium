package utils;

import dataobject.Config;

public class ArrakeenConfig {
    public static final Config CONFIG = Config.get();
    public static final String BROWSER = ReflectUtils.getProperty("keenBrowser", CONFIG.getKeenBrowser());
    public static final long TIMEOUT = ReflectUtils.getProperty("keenTimeout", CONFIG.getKeenTimeout(), Long.class);
    public static final long NAVIGATION_TIMEOUT = 60000;
    public static final boolean HEADLESS = ReflectUtils.getProperty("keenHeadless", CONFIG.isKeenHeadless(), Boolean.class);
    public static final boolean SAVE_PAGE_SOURCE = ReflectUtils.getProperty("keenSavePageSource", CONFIG.isKeenSavePageSource(), Boolean.class);
}

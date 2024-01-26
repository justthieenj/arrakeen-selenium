package io.github.justthieenj.utils;

import io.github.justthieenj.dataobject.Config;
import io.github.justthieenj.enums.Browser;

public class ArrakeenConfig {
    public static final Config CONFIG = Config.get();
    public static final Browser BROWSER = Browser.fromStr(ReflectUtils.getProperty("keenBrowser", CONFIG.getKeenBrowser()));
    public static final long TIMEOUT = ReflectUtils.getProperty("keenTimeout", CONFIG.getKeenTimeout(), Long.class);
    public static final long NAVIGATION_TIMEOUT = 60000;
    public static final boolean HEADLESS = ReflectUtils.getProperty("keenHeadless", CONFIG.isKeenHeadless(), Boolean.class);
    public static final boolean SAVE_PAGE_SOURCE = ReflectUtils.getProperty("keenSavePageSource", CONFIG.isKeenSavePageSource(), Boolean.class);
}

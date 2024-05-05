package io.github.justthieenj.arrakeenselenium.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Arrakeen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    public static void initDriver() {
        var driver = ArrakeenBrowser.initDriverAndCapabilities();
        DRIVERS.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVERS.get();
    }

    public static void open(String url) {
        var driver = getDriver();
        if (!ArrakeenConfig.HEADLESS) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(ArrakeenConfig.NAVIGATION_TIMEOUT));
        String finalUrl = null;
        if (url.startsWith("http") || url.startsWith("https") || url.startsWith("www."))
            finalUrl = url;
        else if (url.startsWith("/") || url.isEmpty()) {
            // if both BASE_URL and url are empty, throw exception
            if (ArrakeenConfig.BASE_URL.isEmpty()) {
                throw new IllegalArgumentException("Base URL is not set");
            }
            finalUrl = ArrakeenConfig.BASE_URL + url;
        }
        LOGGER.info("Opening {} in {}...", finalUrl, ArrakeenConfig.BROWSER);
        driver.get(finalUrl);
    }

    public static void quitDriver() {
        LOGGER.info("Quitting {} driver...", ArrakeenConfig.BROWSER);
        getDriver().quit();
    }

    public static ArrakeenElement find(String locator) {
        return new ArrakeenElementImpl(locator);
    }

    public static ArrakeenElement find(By locator) {
        return new ArrakeenElementImpl(locator);
    }

    public static ArrakeenElement findByText(String text) {
        var xpath = "//*[contains(text(),'%s')]".formatted(text);
        return find(xpath);
    }

    public static ArrakeenElements finds(String locator) {
        return new ArrakeenElementImpl(locator);
    }

    public static ArrakeenElements finds(By locator) {
        return new ArrakeenElementImpl(locator);
    }


    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception ignored) {
        }
    }
}
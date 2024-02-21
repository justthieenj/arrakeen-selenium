package io.github.justthieenj.arrakeenselenium.core;

import io.github.justthieenj.arrakeenselenium.utils.ArrakeenConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Arrakeen {
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    public static void initDriver() {
        var driver = switch (ArrakeenConfig.BROWSER) {
            case chrome -> new ChromeDriver();
            case msedge -> new EdgeDriver();
            case firefox -> new FirefoxDriver();
        };
        DRIVERS.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVERS.get();
    }

    public static void open(String url) {
        getDriver().manage().window().maximize();
        url = url.equals("/") ? ArrakeenConfig.BASE_URL : url;
        if (url.isEmpty())
            throw new IllegalArgumentException("Base URL is not set");
        getDriver().get(url);
    }

    public static void quitDriver() {
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
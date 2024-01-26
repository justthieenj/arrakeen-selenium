package io.github.justthieenj.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.justthieenj.utils.ArrakeenConfig;

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
        getDriver().get(url);
    }

    public static void quitDriver() {
        getDriver().quit();
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception ignored) {
        }
    }
}
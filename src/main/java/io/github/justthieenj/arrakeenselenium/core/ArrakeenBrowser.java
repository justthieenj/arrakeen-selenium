package io.github.justthieenj.arrakeenselenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.List;

public class ArrakeenBrowser {
    public static WebDriver initDriverAndCapabilities() {
        var options = getBrowserOptions();
        return switch (ArrakeenConfig.BROWSER) {
            case chrome -> new ChromeDriver(new ChromeOptions().addArguments(options));
            case msedge -> new EdgeDriver(new EdgeOptions().addArguments(options));
            case firefox -> new FirefoxDriver(new FirefoxOptions().addArguments(options));
        };
    }

    private static List<String> getBrowserOptions() {
        var options = new ArrayList<>(List.of("--remote-allow-origins=*"));
        if (ArrakeenConfig.HEADLESS) {
            options.addAll(List.of("--headless", "--no-sandbox", "--disable-dev-shm-usage"));
        }
        return options;
    }
}

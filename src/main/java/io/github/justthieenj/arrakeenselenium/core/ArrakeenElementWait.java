package io.github.justthieenj.arrakeenselenium.core;

import io.github.justthieenj.arrakeenselenium.enums.ElementState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

class ArrakeenElementWait {
    private final WebDriver driver;
    private final By byLocator;
    private final Duration defaultTimeout = Duration.ofMillis(ArrakeenConfig.TIMEOUT);

    public ArrakeenElementWait(WebDriver driver, By byLocator) {
        this.driver = driver;
        this.byLocator = byLocator;
    }

    public void waitUntil(List<ElementState> states, Duration timeout) {
        var wait = new WebDriverWait(driver, timeout);
        states.forEach(state -> {
            switch (state) {
                case attached -> wait.until(presenceOfElementLocated(byLocator));
                case visible -> wait.until(visibilityOfElementLocated(byLocator));
                case invisible -> wait.until(invisibilityOfElementLocated(byLocator));
                case enabled, editable -> wait.until(elementToBeClickable(byLocator));
            }
        });
    }

    public void waitUntil(ElementState state, long timeoutInMillis) {
        waitUntil(List.of(state), Duration.ofMillis(timeoutInMillis));
    }

    public void waitUntil(List<ElementState> states) {
        waitUntil(states, defaultTimeout);
    }

    public void waitUntil(ElementState... states) {
        waitUntil(Arrays.asList(states), defaultTimeout);
    }
}

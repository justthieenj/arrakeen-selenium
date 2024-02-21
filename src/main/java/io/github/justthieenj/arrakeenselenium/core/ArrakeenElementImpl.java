package io.github.justthieenj.arrakeenselenium.core;

import io.github.justthieenj.arrakeenselenium.enums.Attribute;
import io.github.justthieenj.arrakeenselenium.enums.ElementState;
import io.github.justthieenj.arrakeenselenium.enums.ElementWaitAction;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ArrakeenElementImpl implements ArrakeenElement, ArrakeenElements {
    protected String locator;
    protected By byLocator;
    protected ArrakeenElementWait wait;

    protected ArrakeenElementImpl(String locator) {
        this.locator = locator;
        this.byLocator = getByLocator();
        this.wait = new ArrakeenElementWait(getDriver(), byLocator);
    }

    protected ArrakeenElementImpl(By byLocator) {
        this.byLocator = byLocator;
        this.wait = new ArrakeenElementWait(getDriver(), byLocator);
    }

    private WebDriver getDriver() {
        return Arrakeen.getDriver();
    }

    @Override
    public By getByLocator() {
        if (byLocator != null) return byLocator;
        return locator.startsWith("//") || locator.startsWith("(//") ? By.xpath(locator) : By.cssSelector(locator);
    }

    @Override
    public WebElement getWebElement() {
        wait.waitUntil(ElementState.attached);
        return getDriver().findElement(byLocator);
    }

    /**
     * Get the web element with the given states (attached state is already included)
     */
    private WebElement getWebElementWithStates(List<ElementState> states) {
        WebElement e = getWebElement();
        wait.waitUntil(states);
        return e;
    }

    @Override
    public void click() {
        getWebElementWithStates(ElementWaitAction.click.getStates()).click();
    }

    @Override
    public void type(String text) {
        getWebElementWithStates(ElementWaitAction.type.getStates()).sendKeys(text);
    }

    @Override
    public String getText() {
        return getWebElement().getText();
    }

    @Override
    public String getAttribute(@NotNull Attribute attribute) {
        return getWebElement().getAttribute(attribute.getVal());
    }

    @Override
    public String getValue() {
        return getAttribute(Attribute.value);
    }

    @Override
    public boolean is(ElementState state) {
        try {
            wait.waitUntil(state);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean has(Map<Attribute, String> attributeValuePair) {
        return attributeValuePair
                .entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().equals(getAttribute(entry.getKey())));
    }

    @Override
    public boolean containsText(String text) {
        return getText().contains(text);
    }

    @Override
    public List<WebElement> getWebElements() {
        wait.waitUntil(ElementState.attached);
        return getDriver().findElements(byLocator);
    }

    @Override
    public List<String> getTexts() {
        return getWebElements().stream().map(WebElement::getText).toList();
    }

    @Override
    public List<String> getAttributeValues(Attribute attribute) {
        return getWebElements().stream().map(e -> e.getAttribute(attribute.getVal())).toList();
    }
}

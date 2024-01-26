package io.github.justthieenj.element;

import io.github.justthieenj.driver.Arrakeen;
import io.github.justthieenj.enums.Attribute;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArrakeenElementImpl implements ArrakeenElement {
    protected String locator;
    protected By byLocator;
    protected String dynamicLocator;

    public ArrakeenElementImpl(String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
    }

    public ArrakeenElementImpl(By byLocator) {
        this.byLocator = byLocator;
    }

    private WebDriver getDriver() {
        return Arrakeen.getDriver();
    }

    private By getByLocator() {
        return locator.startsWith("//") || locator.startsWith("(//") ? By.xpath(locator) : By.cssSelector(locator);
    }

    @Override
    public WebElement getElement() {
        return getDriver().findElement(byLocator);
    }

    @Override
    public void click() {
        getElement().click();
    }

    @Override
    public void type(String text) {
        getElement().sendKeys(text);
    }

    @Override
    public String getText() {
        return getElement().getText();
    }

    @Override
    public String getAttribute(@NotNull Attribute attribute) {
        return getElement().getAttribute(attribute.getVal());
    }

    @Override
    public String getValue() {
        return getAttribute(Attribute.value);
    }
}

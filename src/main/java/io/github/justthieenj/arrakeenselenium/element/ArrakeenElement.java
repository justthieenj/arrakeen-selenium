package io.github.justthieenj.arrakeenselenium.element;

import io.github.justthieenj.arrakeenselenium.enums.Attribute;
import io.github.justthieenj.arrakeenselenium.enums.ElementState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public interface ArrakeenElement {
    By getByLocator();

    WebElement getWebElement();

    void click();

    void type(String text);

    String getText();

    String getAttribute(Attribute attribute);

    String getValue();

    boolean is(ElementState state);

    boolean has(Map<Attribute, String> attributes);

    boolean containsText(String text);
}

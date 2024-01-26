package io.github.justthieenj.element;

import io.github.justthieenj.enums.Attribute;
import org.openqa.selenium.WebElement;

public interface ArrakeenElement {
    WebElement getElement();

    void click();

    void type(String text);

    String getText();

    String getAttribute(Attribute attribute);

    String getValue();
}

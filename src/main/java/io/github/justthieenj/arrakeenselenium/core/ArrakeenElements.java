package io.github.justthieenj.arrakeenselenium.core;

import io.github.justthieenj.arrakeenselenium.enums.Attribute;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ArrakeenElements {
    List<WebElement> getWebElements();
    List<String> getTexts();
    List<String> getAttributeValues(Attribute attribute);
}

package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Attribute {
    id("id"),
    name("name"),
    className("class"),
    value("value"),
    href("href"),
    src("src"),
    title("title"),
    alt("alt"),
    type("type"),
    placeholder("placeholder"),
    role("role"),
    ariaLabel("aria-label");

    private final String val;
}

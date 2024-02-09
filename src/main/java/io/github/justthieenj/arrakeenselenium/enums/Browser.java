package io.github.justthieenj.arrakeenselenium.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Browser {
    chrome,
    msedge,
    firefox;

    public static Browser fromStr(String browser) {
        return switch (browser) {
            case "chrome" -> chrome;
            case "edge", "msedge" -> msedge;
            case "firefox" -> firefox;
            default -> throw new IllegalArgumentException("Browser " + browser + " not supported");
        };
    }
}

package io.github.justthieenj.arrakeenselenium.utils;

import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public static boolean isMatch(String input, String regex) {
        return input.matches(regex);
    }

    public static String getSubstring(String str, String regex) {
        var pattern = Pattern.compile(regex);
        var matchResults = pattern.matcher(str);
        String desiredStr = null;
        if (matchResults.find()) {
            desiredStr = matchResults.group();
        }
        return desiredStr;
    }

    public static String removeText(String str, String text) {
        return str.replaceAll(text, "");
    }

    public static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }
}

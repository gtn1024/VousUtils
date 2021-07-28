package com.vousutils.text;

import com.vousutils.text.enums.TextType;

import java.util.Random;

public class UtilsText {
    /**
     * Delete the text on the left.
     *
     * @param s      The text you want to operate
     * @param length the length you want to delete
     * @return String
     * @author Taoning Ge
     * @since 0.2.0
     */
    public static String deleteLeft(String s, int length) {
        if (s == null || s.length() <= length) return "";
        return s.substring(length);
    }

    /**
     * Delete the text on the right.
     *
     * @param s      The text you want to operate
     * @param length The length you want to delete
     * @return String
     * @author Taoning Ge
     * @since 0.2.0
     */
    public static String deleteRight(String s, int length) {
        if (s == null || s.length() <= length) return "";
        return s.substring(0, s.length() - length);
    }

    /**
     * Delete the text in the middle.
     *
     * @param s      The text you want to operate.
     * @param index  The index of the text you want to operate.
     * @param length The length you want to delete
     * @return String
     * @author Taoning Ge
     * @since 0.2.0
     */
    public static String deleteMiddle(String s, int index, int length) {
        if (s == null || s.length() <= index || s.length() <= length) return "";
        return s.substring(0, index - 1) + s.substring(index + length - 1);
    }

    /**
     * Delete first and last blanks in the text.
     *
     * @param s The text you want to operate.
     * @return String
     * @author Taoning Ge
     * @since 0.2.0
     */
    public static String deleteFirstAndLastBlanks(String s) {
        if (s == null) return "";
        return s.trim();
    }

    /**
     * Reverse Text.
     *
     * @param s The text you want to operate.
     * @return Reversed text.
     * @author Taoning Ge
     * @since 0.2.1
     */
    public static String reverseText(String s) {
        if (s == null) return "";
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Join array element to a text with one character.
     *
     * @param ss        The String array.
     * @param character The character between each array element.
     * @return String
     * @author Taoning Ge
     * @since 0.2.1
     */
    public static String joinArrayString(String[] ss, String character) {
        if (ss == null || ss.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (var s : ss) {
            sb.append(s).append(character);
        }
        return sb.substring(0, sb.length() - character.length());
    }

    /**
     * Determine whether the specified text in the text is repeated
     *
     * @param s    The original text
     * @param text The specified text
     * @return Whether it is repeated
     * @author Taoning Ge
     * @since 0.2.1
     */
    public static boolean isTextRepeated(String s, String text) {
        var i = s.indexOf(text);
        if (i == -1) return false;
        var i2 = s.indexOf(text, i + 1);
        return i2 != -1;
    }

    /**
     * Get the text left.
     *
     * @param s    The original text.
     * @param text The specified text.
     * @return Result.
     * @author Taoning Ge
     * @since 0.2.2
     */
    public static String getTextLeft(String s, String text) {
        if (s == null || text == null) return "";
        var i = s.indexOf(text);
        if (i <= 0) return "";
        return s.substring(0, i);
    }

    /**
     * Get the text right.
     *
     * @param s    The original text.
     * @param text The specified text.
     * @return Result.
     * @author Taoning Ge
     * @since 0.2.2
     */
    public static String getTextRight(String s, String text) {
        if (s == null || text == null) return "";
        var i = s.indexOf(text);
        if (i <= 0) return "";
        return s.substring(i + 1);
    }

    /**
     * Get random text.
     *
     * @param length Length
     * @param type   The enum `TextType`.
     * @return Random text.
     * @author Taoning Ge
     * @since 0.2.2
     */
    public static String getRandomString(int length, TextType type) {
        String str;
        switch (type) {
            case LOWERCASE_ONLY:
                str = "abcdefghijklmnopqrstuvwxyz";
                break;
            case UPPERCASE_ONLY:
                str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case MIX:
                str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            default:
                throw new RuntimeException("Cannot process " + type);
        }
        var random = new Random();
        var sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    /**
     * Get Random IP.
     *
     * @return Random IP.
     * @author Taoning Ge
     * @since 0.2.3
     */
    public static String getRandomIP() {
        var random = new Random();
        final var MIN = 50;
        final var MAX = 254;
        var s = (random.nextInt(MAX - MIN) + MIN) +
                "." +
                (random.nextInt(MAX - MIN) + MIN) +
                "." +
                (random.nextInt(MAX - MIN) + MIN) +
                "." +
                (random.nextInt(MAX - MIN) + MIN);
        return s;
    }
}

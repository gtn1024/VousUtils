package com.vousutils.text;

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
}

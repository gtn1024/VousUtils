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
        return s.trim();
    }
}

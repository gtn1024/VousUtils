package com.vousutils.number;

public class UtilsNumber {
    /**
     * Determine whether a specific number in range.
     *
     * @param num the specific number
     * @param min range - min
     * @param max range - max
     * @return whether a specific number in range
     * @author Taoning Ge
     * @since 0.2.3
     */
    public static boolean isNumInRange(int num, int min, int max) {
        return num >= min && num <= max;
    }
}

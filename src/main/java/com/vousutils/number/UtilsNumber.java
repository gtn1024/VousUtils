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

    /**
     * Returns the value of the specified integer that is limited to the specified range
     *
     * @param i   Provide the integer value to be checked
     * @param min Provide the minimum allowed
     * @param max Provide the maximum allowed
     * @return int
     * @author Taoning Ge
     * @since 0.3.0
     */
    public static int getRangeInt(int i, int min, int max) {
        return (i < min ? min : Math.min(i, max));
    }


}

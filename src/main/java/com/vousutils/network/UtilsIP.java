package com.vousutils.network;

/**
 * Provide IP convert method.
 */
public class UtilsIP {
    /**
     * Convert IP to decimal. If it goes wrong, you will get `-1`.
     *
     * @param ip For example: `192.168.1.1`
     * @return Decimal or `-1`
     */
    public static long ipConvertToDec(String ip) {
        String[] temp;
        temp = ip.split("\\.");
        if (temp.length >= 3) {
            return Integer.parseInt(temp[3]) + Integer.parseInt(temp[2]) * 256L
                    + Integer.parseInt(temp[1]) * 256L * 256L + Integer.parseInt(temp[0]) * 256L * 256L * 256L;
        }
        return -1;
    }
}

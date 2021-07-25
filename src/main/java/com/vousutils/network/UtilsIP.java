package com.vousutils.network;

import java.nio.ByteBuffer;
import java.util.Arrays;

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


    /**
     * Convert IP String to Hexadecimal
     * @param ip For example: `192.168.1.1`.
     * @return Hexadecimal
     */
    public static String ipConvertToHex(String ip) {
//        num ＝ IP_转至10进制 (IP地址)
//        返回 (进制_十到十六 (num))

        return Long.toHexString(ipConvertToDec(ip));
    }

    /**
     * Convert decimal to IP String.
     * @param dec For example: `3232235777L`.
     * @return IP String.
     */
    public static String decConvertToIP(long dec) {
        byte[] bytes = ByteBuffer.allocate(Long.BYTES).putLong(dec).array();
        byte[] bytes1 = Arrays.copyOfRange(bytes, 4, bytes.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 3; i++) {
            sb.append(bytes1[i] & 0xff);
            sb.append(".");
        }
        return sb.substring(0, sb.toString().length() - 1);
    }

    /**
     * Convert Hexadecimal to IP String.
     * @param hex For example: `C0A80101`.
     * @return IP String.
     */
    public static String hexConvertToIP(String hex) {
        return decConvertToIP(Long.parseLong(hex,16));
    }
}

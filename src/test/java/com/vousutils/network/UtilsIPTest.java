package com.vousutils.network;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsIPTest {
    @Test
    @DisplayName("Test ipConvertToDec")
    void testIpConvertToDec() {
        assertAll("ipConvertToDec",
                () -> assertEquals(3232235777L, UtilsIP.ipConvertToDec("192.168.1.1")),
                () -> assertEquals(16843009L, UtilsIP.ipConvertToDec("1.1.1.1")),
                () -> assertEquals(167772417L, UtilsIP.ipConvertToDec("10.0.1.1")),
                () -> assertEquals(4294967295L, UtilsIP.ipConvertToDec("255.255.255.255"))
        );
    }

    @Test
    @DisplayName("Test ipConvertToHex")
    void testIpConvertToHex() {
        assertAll("ipConvertToHex",
                () -> assertEquals("C0A80101", UtilsIP.ipConvertToHex("192.168.1.1").toUpperCase()),
                () -> assertEquals("1010101", UtilsIP.ipConvertToHex("1.1.1.1").toUpperCase()),
                () -> assertEquals("A000101", UtilsIP.ipConvertToHex("10.0.1.1").toUpperCase()),
                () -> assertEquals("FFFFFFFF", UtilsIP.ipConvertToHex("255.255.255.255").toUpperCase())
        );
    }

    @Test
    @DisplayName("Test decConvertToIP")
    void testDecConvertToIP() {
        assertAll("decConvertToIP",
                () -> assertEquals("192.168.1.1", UtilsIP.decConvertToIP(3232235777L)),
                () -> assertEquals("1.1.1.1", UtilsIP.decConvertToIP(16843009L)),
                () -> assertEquals("10.0.1.1", UtilsIP.decConvertToIP(167772417L)),
                () -> assertEquals("255.255.255.255", UtilsIP.decConvertToIP(4294967295L))
        );
    }

    @Test
    @DisplayName("Test hexConvertToIP")
    void testHexConvertToIP() {
        assertAll("hexConvertToIP",
                () -> assertEquals("192.168.1.1", UtilsIP.hexConvertToIP("C0A80101")),
                () -> assertEquals("1.1.1.1", UtilsIP.hexConvertToIP("1010101")),
                () -> assertEquals("10.0.1.1", UtilsIP.hexConvertToIP("A000101")),
                () -> assertEquals("255.255.255.255", UtilsIP.hexConvertToIP("FFFFFFFF"))
        );
    }
}

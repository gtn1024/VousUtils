package com.vousutils.network;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsIPTest {
    @Test
    @DisplayName("Test ipConvertToDecimal")
    void testIpConvertToDecimal() {
        assertAll("ipConvertToDecimal",
                () -> assertEquals(3232235777L, UtilsIP.ipConvertToDec("192.168.1.1")),
                () -> assertEquals(16843009L, UtilsIP.ipConvertToDec("1.1.1.1")),
                () -> assertEquals(167772417L, UtilsIP.ipConvertToDec("10.0.1.1")),
                () -> assertEquals(4294967295L, UtilsIP.ipConvertToDec("255.255.255.255"))
        );

    }
}

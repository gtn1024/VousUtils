package com.vousutils.file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.vousutils.file.UtilsFile.*;
import static org.junit.jupiter.api.Assertions.*;

public class UtilsFileTest {

    @Test
    @DisplayName("Test isFileOccupied")
    void testIsFileOccupied() {
        // TODO
    }

    @Test
    @DisplayName("Test isFileNameOK")
    void testIsFileNameOK() {
        assertAll("isFileNameOK",
                () -> assertTrue(isFileNameOK("VousUtils Yes!")),
                () -> assertFalse(isFileNameOK("\\VousUtils")),
                () -> assertFalse(isFileNameOK("Google.com/")),
                () -> assertFalse(isFileNameOK("https://vousutils.com")),
                () -> assertFalse(isFileNameOK("*important")),
                () -> assertFalse(isFileNameOK("<>")),
                () -> assertFalse(isFileNameOK("||"))
        );

    }
}

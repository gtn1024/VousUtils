package com.vousutils.text;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTextTest {
    @Test
    @DisplayName("Test deleteLeft")
    void testDeleteLeft() {
        assertAll("deleteLeft",
                () -> assertEquals("sUtils", UtilsText.deleteLeft("VousUtils", 3)),
                () -> assertEquals("llo World", UtilsText.deleteLeft("Hello World", 2)),
                () -> assertEquals("tHub", UtilsText.deleteLeft("GitHub", 2)),
                () -> assertEquals("", UtilsText.deleteLeft("Hello World", 15)),
                () -> assertEquals("", UtilsText.deleteLeft(null, 15))
        );
    }

    @Test
    @DisplayName("Test deleteRight")
    void testDeleteRight() {
        assertAll("deleteRight",
                () -> assertEquals("VousUt", UtilsText.deleteRight("VousUtils", 3)),
                () -> assertEquals("Hello Wor", UtilsText.deleteRight("Hello World", 2)),
                () -> assertEquals("GitH", UtilsText.deleteRight("GitHub", 2)),
                () -> assertEquals("", UtilsText.deleteRight("Hello World", 15)),
                () -> assertEquals("", UtilsText.deleteRight(null, 15))
        );
    }

    @Test
    @DisplayName("Test deleteMiddle")
    void testDeleteMiddle() {
        assertAll("deleteMiddle",
                () -> assertEquals("Votils", UtilsText.deleteMiddle("VousUtils", 3, 3)),
                () -> assertEquals("Ho World", UtilsText.deleteMiddle("Hello World", 2, 3)),
                () -> assertEquals("Gub", UtilsText.deleteMiddle("GitHub", 2, 3)),
                () -> assertEquals("", UtilsText.deleteMiddle("Hello World", 15, 2)),
                () -> assertEquals("", UtilsText.deleteMiddle("Hello World", 2, 15)),
                () -> assertEquals("", UtilsText.deleteMiddle(null, 1, 2))
        );
    }

    @Test
    @DisplayName("Test deleteFirstAndLastBlanks")
    void testDeleteFirstAndLastBlanks() {
        assertAll("deleteFirstAndLastBlanks",
                () -> assertEquals("VousUtils", UtilsText.deleteFirstAndLastBlanks("  VousUtils  ")),
                () -> assertEquals("Hello World", UtilsText.deleteFirstAndLastBlanks(" Hello World ")),
                () -> assertEquals("GitHub", UtilsText.deleteFirstAndLastBlanks("GitHub ")),
                () -> assertEquals("GitHub", UtilsText.deleteFirstAndLastBlanks(" GitHub"))
        );
    }

    @Test
    @DisplayName("Test reverseText")
    void testReverseText() {
        assertAll("reverseText",
                () -> assertEquals("slitUsuoV", UtilsText.reverseText("VousUtils")),
                () -> assertEquals("dlroW olleH", UtilsText.reverseText("Hello World")),
                () -> assertEquals("buHtiG", UtilsText.reverseText("GitHub"))
        );
    }

    @Test
    @DisplayName("Test joinArrayString")
    void testJoinArrayString() {
        assertAll("joinArrayString",
                () -> assertEquals("Hello World", UtilsText.joinArrayString(new String[]{"Hello", "World"}, " ")),
                () -> assertEquals("a, b, c", UtilsText.joinArrayString(new String[]{"a", "b", "c"}, ", ")),
                () -> assertEquals("GitHub,Google,Amazon,Apple,Microsoft",
                        UtilsText.joinArrayString(new String[]{"GitHub", "Google", "Amazon", "Apple", "Microsoft"}, ","))
        );
    }

    @Test
    @DisplayName("Test isTextRepeated")
    void testIsTextRepeated() {
        assertAll("isTextRepeated",
                () -> assertTrue(UtilsText.isTextRepeated("Hello World!", "o")),
                () -> assertFalse(UtilsText.isTextRepeated("GitHub", "o")),
                () -> assertFalse(UtilsText.isTextRepeated("GitHub", "H"))
        );
    }

}

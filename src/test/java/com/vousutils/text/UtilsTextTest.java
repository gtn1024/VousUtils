package com.vousutils.text;

import com.vousutils.number.UtilsNumber;
import com.vousutils.text.enums.TextType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.vousutils.text.UtilsText.*;
import static org.junit.jupiter.api.Assertions.*;

public class UtilsTextTest {
    @Test
    @DisplayName("Test deleteLeft")
    void testDeleteLeft() {
        assertAll("deleteLeft",
                () -> assertEquals("sUtils", deleteLeft("VousUtils", 3)),
                () -> assertEquals("llo World", deleteLeft("Hello World", 2)),
                () -> assertEquals("tHub", deleteLeft("GitHub", 2)),
                () -> assertEquals("", deleteLeft("Hello World", 15)),
                () -> assertEquals("", deleteLeft(null, 15))
        );
    }

    @Test
    @DisplayName("Test deleteRight")
    void testDeleteRight() {
        assertAll("deleteRight",
                () -> assertEquals("VousUt", deleteRight("VousUtils", 3)),
                () -> assertEquals("Hello Wor", deleteRight("Hello World", 2)),
                () -> assertEquals("GitH", deleteRight("GitHub", 2)),
                () -> assertEquals("", deleteRight("Hello World", 15)),
                () -> assertEquals("", deleteRight(null, 15))
        );
    }

    @Test
    @DisplayName("Test deleteMiddle")
    void testDeleteMiddle() {
        assertAll("deleteMiddle",
                () -> assertEquals("Votils", deleteMiddle("VousUtils", 3, 3)),
                () -> assertEquals("Ho World", deleteMiddle("Hello World", 2, 3)),
                () -> assertEquals("Gub", deleteMiddle("GitHub", 2, 3)),
                () -> assertEquals("", deleteMiddle("Hello World", 15, 2)),
                () -> assertEquals("", deleteMiddle("Hello World", 2, 15)),
                () -> assertEquals("", deleteMiddle(null, 1, 2))
        );
    }

    @Test
    @DisplayName("Test deleteFirstAndLastBlanks")
    void testDeleteFirstAndLastBlanks() {
        assertAll("deleteFirstAndLastBlanks",
                () -> assertEquals("VousUtils", deleteFirstAndLastBlanks("  VousUtils  ")),
                () -> assertEquals("Hello World", deleteFirstAndLastBlanks(" Hello World ")),
                () -> assertEquals("GitHub", deleteFirstAndLastBlanks("GitHub ")),
                () -> assertEquals("GitHub", deleteFirstAndLastBlanks(" GitHub"))
        );
    }

    @Test
    @DisplayName("Test reverseText")
    void testReverseText() {
        assertAll("reverseText",
                () -> assertEquals("slitUsuoV", reverseText("VousUtils")),
                () -> assertEquals("dlroW olleH", reverseText("Hello World")),
                () -> assertEquals("buHtiG", reverseText("GitHub"))
        );
    }

    @Test
    @DisplayName("Test joinArrayString")
    void testJoinArrayString() {
        assertAll("joinArrayString",
                () -> assertEquals("Hello World", joinArrayString(new String[]{"Hello", "World"}, " ")),
                () -> assertEquals("a, b, c", joinArrayString(new String[]{"a", "b", "c"}, ", ")),
                () -> assertEquals("GitHub,Google,Amazon,Apple,Microsoft",
                        joinArrayString(new String[]{"GitHub", "Google", "Amazon", "Apple", "Microsoft"}, ","))
        );
    }

    @Test
    @DisplayName("Test isTextRepeated")
    void testIsTextRepeated() {
        assertAll("isTextRepeated",
                () -> assertTrue(isTextRepeated("Hello World!", "o")),
                () -> assertFalse(isTextRepeated("GitHub", "o")),
                () -> assertFalse(isTextRepeated("GitHub", "H"))
        );
    }

    @Test
    @DisplayName("Test getTextLeft")
    void testGetTextLeft() {
        assertAll("getTextLeft",
                () -> assertEquals("V", getTextLeft("VousUtils", "o")),
                () -> assertEquals("Hell", getTextLeft("Hello World!", "o")),
                () -> assertEquals("", getTextLeft("GitHub", "o")),
                () -> assertEquals("Git", getTextLeft("GitHub", "H")),
                () -> assertEquals("", getTextLeft("GitHub", null)),
                () -> assertEquals("", getTextLeft(null, null)),
                () -> assertEquals("", getTextLeft(null, "H"))
        );
    }

    @Test
    @DisplayName("Test getTextRight")
    void testGetTextRight() {
        assertAll("getTextRight",
                () -> assertEquals("usUtils", getTextRight("VousUtils", "o")),
                () -> assertEquals(" World!", getTextRight("Hello World!", "o")),
                () -> assertEquals("", getTextRight("GitHub", "o")),
                () -> assertEquals("ub", getTextRight("GitHub", "H")),
                () -> assertEquals("", getTextRight("GitHub", null)),
                () -> assertEquals("", getTextRight(null, null)),
                () -> assertEquals("", getTextRight(null, "H"))
        );
    }

    @Test
    @DisplayName("Test getRandomString")
    void testGetRandomString() {
        assertAll("getRandomString",
                () -> {
                    var text = getRandomString(100000, TextType.MIX);
                    var str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    for (int i = 0; i < text.length(); i++) {
                        assert str.contains(String.valueOf(text.charAt(i))) : "getRandomString TextType.MIX failed";
                    }
                },
                () -> {
                    var text = getRandomString(100000, TextType.LOWERCASE_ONLY);
                    var str = "abcdefghijklmnopqrstuvwxyz";
                    for (int i = 0; i < text.length(); i++) {
                        assert str.contains(String.valueOf(text.charAt(i))) : "getRandomString TextType.LOWERCASE_ONLY failed";
                    }
                },
                () -> {
                    var text = getRandomString(100000, TextType.UPPERCASE_ONLY);
                    var str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    for (int i = 0; i < text.length(); i++) {
                        assert str.contains(String.valueOf(text.charAt(i))) : "getRandomString TextType.UPPERCASE_ONLY failed";
                    }
                }
        );
    }

    @Test
    @DisplayName("Test getRandomIP")
    void testGetRandomIP() {
        assertAll("getRandomIP",
                () -> {
                    var ip = getRandomIP();
                    var split = ip.split("\\.");
                    assert split.length == 4 : "IP string length is not 4.";
                    final var MIN = 50;
                    final var MAX = 254;
                    for (var s : split) {
                        assert UtilsNumber.isNumInRange(Integer.parseInt(s), MIN, MAX);
                    }
                }
        );
    }
}
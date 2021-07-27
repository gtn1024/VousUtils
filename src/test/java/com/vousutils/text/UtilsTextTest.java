package com.vousutils.text;

import com.vousutils.text.enums.TextType;
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

    @Test
    @DisplayName("Test getTextLeft")
    void testGetTextLeft() {
        assertAll("getTextLeft",
                () -> assertEquals("V", UtilsText.getTextLeft("VousUtils", "o")),
                () -> assertEquals("Hell", UtilsText.getTextLeft("Hello World!", "o")),
                () -> assertEquals("", UtilsText.getTextLeft("GitHub", "o")),
                () -> assertEquals("Git", UtilsText.getTextLeft("GitHub", "H")),
                () -> assertEquals("", UtilsText.getTextLeft("GitHub", null)),
                () -> assertEquals("", UtilsText.getTextLeft(null, null)),
                () -> assertEquals("", UtilsText.getTextLeft(null, "H"))
        );
    }

    @Test
    @DisplayName("Test getTextRight")
    void testGetTextRight() {
        assertAll("getTextRight",
                () -> assertEquals("usUtils", UtilsText.getTextRight("VousUtils", "o")),
                () -> assertEquals(" World!", UtilsText.getTextRight("Hello World!", "o")),
                () -> assertEquals("", UtilsText.getTextRight("GitHub", "o")),
                () -> assertEquals("ub", UtilsText.getTextRight("GitHub", "H")),
                () -> assertEquals("", UtilsText.getTextRight("GitHub", null)),
                () -> assertEquals("", UtilsText.getTextRight(null, null)),
                () -> assertEquals("", UtilsText.getTextRight(null, "H"))
        );
    }

    @Test
    @DisplayName("Test getRandomString")
    void testGetRandomString() {
        assertAll("getRandomString",
                () -> {
                    var text = UtilsText.getRandomString(100000, TextType.MIX);
                    var str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    for (int i = 0; i < text.length(); i++) {
                        assert str.contains(String.valueOf(text.charAt(i))) : "getRandomString TextType.MIX failed";
                    }
                },
                () -> {
                    var text = UtilsText.getRandomString(100000, TextType.LOWERCASE_ONLY);
                    var str = "abcdefghijklmnopqrstuvwxyz";
                    for (int i = 0; i < text.length(); i++) {
                        assert str.contains(String.valueOf(text.charAt(i))) : "getRandomString TextType.LOWERCASE_ONLY failed";
                    }
                },
                () -> {
                    var text = UtilsText.getRandomString(100000, TextType.UPPERCASE_ONLY);
                    var str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    for (int i = 0; i < text.length(); i++) {
                        assert str.contains(String.valueOf(text.charAt(i))) : "getRandomString TextType.UPPERCASE_ONLY failed";
                    }
                }
        );
    }
}

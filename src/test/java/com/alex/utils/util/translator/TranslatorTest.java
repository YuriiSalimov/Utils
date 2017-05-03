package com.alex.utils.util.translator;

import com.alex.utils.translator.Translator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public final class TranslatorTest {

    @Test
    public void whenTranslateNullValueFromCyrillicToLatinThenReturnNotNull() {
        assertNotNull(Translator.fromCyrillicToLatin(null));
    }

    @Test
    public void whenTranslateInvalidValueFromCyrillicToLatinThenReturnNotNull() {
        assertNotNull(Translator.fromCyrillicToLatin(""));
        assertNotNull(Translator.fromCyrillicToLatin(" "));
        assertNotNull(Translator.fromCyrillicToLatin("   "));
    }

    @Test
    public void whenTranslateValidValueFromCyrillicToLatinThenReturnTranslateValue() {
        String value = "some text";
        String result = Translator.fromCyrillicToLatin(value);
        value = "some_text";
        assertNotNull(result);
        assertEquals(result, value);

        value = "SoMe TeXt";
        result = Translator.fromCyrillicToLatin(value);
        value = "some_text";
        assertEquals(result, value);

        value = "некоторой текст";
        result = Translator.fromCyrillicToLatin(value);
        value = "nekotoroy_tekst";
        assertEquals(result, value);
    }

    @Test
    public void whenTranslateNullValueToAsciiThenReturnEmptyString() {
        assertNotNull(Translator.toAscii(null));
    }

    @Test
    public void whenTranslateInvalidValueToAsciiThenReturnEmptyString() {
        assertNotNull(Translator.toAscii(""));
        assertNotNull(Translator.toAscii(" "));
        assertNotNull(Translator.toAscii("   "));
    }

    @Test
    public void whenTranslateValidValueToAsciiThenReturnTranslateValue() {
        assertNotNull(Translator.toAscii("SoMe VaLuE"));
    }

    @Test
    public void whenTranslateValidIntegerToAsciiThenReturnTranslateValue() {
        assertNotNull(Translator.toAscii(123));
    }

    @Test
    public void whenTranslateNullValueFromAsciiThenReturnEmptyString() {
        assertNotNull(Translator.fromAscii(null));
    }

    @Test
    public void whenTranslateInvalidValueFromAsciiThenReturnEmptyString() {
        assertNotNull(Translator.fromAscii(""));
        assertNotNull(Translator.fromAscii(" "));
        assertNotNull(Translator.fromAscii("   "));
    }

    @Test
    public void whenTranslateValidValueFromAsciiThenReturnTranslateValue() {
        assertNotNull(Translator.fromAscii("123"));
    }

    @Test
    public void whenTranslateValidIntegerFromAsciiThenReturnTranslateValue() {
        assertNotNull(Translator.fromAscii(123));
    }

    @Test
    public void whenTranslateValidValueToAsciiAndBackThenEqualsResults() {
        final String value = "SoMe VaLuE";
        final String temp = Translator.toAscii(value);
        assertNotNull(temp);
        final String result = Translator.fromAscii(temp);
        assertNotNull(result);
        assertEquals(value, result);
    }
}

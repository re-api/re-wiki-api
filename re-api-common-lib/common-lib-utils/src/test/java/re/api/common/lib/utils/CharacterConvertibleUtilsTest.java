package re.api.common.lib.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CharacterConvertibleUtilsTest {


    @ParameterizedTest
    @ValueSource(strings = {"[1]foo bar", "c. foo bar [9]", "c.foo bar[3]", "c.foo bar", "c. foo bar", "foo bar[1]",
            "foo bar[notes 585]"})
    void testingRemoveSourceReference(final String given){

        // When
        final String result = CharacterConverterUtils.removeSourceReferences(given);

        // Then
        Assertions.assertEquals("foo bar", result);
    }

    @Test
    void negativeTestCase(){
        // Given
        final String expected = "This is a period.";

        final String resultingString = CharacterConverterUtils.removeSourceReferences(expected);

        Assertions.assertEquals(expected, resultingString);
    }



}
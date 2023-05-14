package rest.re.app.api.rest.scraper.converter.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "150 cm",
            "150cm",
            "150 cm (4 feet)",
            " 150cm ",
            "150cm ",
            " 150cm",
            " 150cm(4feet)",
            "150cm(4feet)"
    })
    void shouldMatchCentimeterFormattedString(final String s){

        final String result = StringUtils.matchCentimeter(s);

        Assertions.assertEquals("150 cm", result);
    }

    @ParameterizedTest
    @NullSource()
    void shouldReturnEmptyStringWhenNull(final String s){
        Assertions.assertEquals("", StringUtils.matchCentimeter(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "daslh",
            "foo bar",
            "++++++"
    })
    void shouldReturnEmptyStringWhenCmDoesntMatch(final String s){
        Assertions.assertEquals("", StringUtils.matchCentimeter(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(4 feet 2 inches)",
            "(4 feet 2 in)",
            "(4 feet,2 in)",
            "(4 feet, 2 in)",
            "(4 ft 2 in)",
            "4 feet 2 in",
            "4 ft 2 in",
            "4 feet 2 inches",
            "4 feet, 2 inches",
            "4 feet,2 inches",
            "4ft2",
            "4ft2in",
            "4ft,2in",
            "4feet,2inches",
    })
    void shouldMatchFeetIfFeetFormatted(final String s){

        final String result = StringUtils.matchFeet(s);

        Assertions.assertEquals("4 ft 2 in", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(4 feet)",
            "(4 ft)",
            "4 ft",
            "4 feet",
            " 4   feet ",
            " 4   ft ",

    })
    void soloFeetValueShouldStillMatch(final String s){

        final String result = StringUtils.matchFeet(s);

        Assertions.assertEquals("4 ft 0 in", result);
    }
}
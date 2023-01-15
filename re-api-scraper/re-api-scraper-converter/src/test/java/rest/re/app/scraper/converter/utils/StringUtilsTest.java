package rest.re.app.scraper.converter.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "150 cm",
            "150cm",
            "150",
            "150 cm (4 feet)",
            "150 (4 feet 2 in)",
            "150 4 feet 2 in",
            "150 4",
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
}
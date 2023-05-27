package re.api.common.lib.parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rest.re.app.api.rest.api.model.Height;


class ScrapedHeightParserTest {



    @ParameterizedTest
    @ValueSource(strings = {
            "187 cm (6 ft 2 in)",
            "187 cm (8 ft 3 in)",
            "187 cm",
            "187cm",
            "187cm (6 ft 2 in)",
            "187cm (6ft2 in)",
            "187cm(6 ft 2 in)",
            "187cm(6ft2in)",
            "187 cm 6 ft 2 in",
            "187cm6ft2in",
            "187 cm, (6 ft 2 in)",
            "187 cm,(6 ft 2 in)"
    })
    void shouldSuccessfullyParseStringIfFormatIsCorrect(String s){
        // All string parameters above should be parsed into
        // Height ("187", "6.14")

        final Height height= new ScrapedHeightParser().parse(s);
        final Height expectedHeight = new Height();
        expectedHeight.setCentimeters("187");
        expectedHeight.setFeet("6.14");

        Assertions.assertEquals(expectedHeight, height);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(6 ft 2 in)",
            "6 ft 2 in",
            "6 ft 2",
            "6 ft2",
            "6ft2",
            "6ft2 ",
            " 6ft2",
            " 6ft2 ",

    })
    void shouldBaseCentimeterOnFeetIfCentimeterIsNotProvided(final String feet){
        final Height expectedHeight = new Height();
        expectedHeight.setCentimeters("188");
        expectedHeight.setFeet("6.17");
        Assertions.assertEquals(expectedHeight, new ScrapedHeightParser().parse(feet));
    }

}
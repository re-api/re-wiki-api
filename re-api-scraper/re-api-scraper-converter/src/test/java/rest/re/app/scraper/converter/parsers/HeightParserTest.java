package rest.re.app.scraper.converter.parsers;

import common.lib.models.serializable.Height;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class HeightParserTest {



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

        final Height height= new HeightParser().parse(s);

        Assertions.assertEquals(new Height().setCentimeters("187").setFeet("6.14"), height);

    }

}
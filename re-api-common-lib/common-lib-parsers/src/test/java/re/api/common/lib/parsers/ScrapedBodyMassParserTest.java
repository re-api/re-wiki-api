package re.api.common.lib.parsers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import rest.re.app.api.rest.api.model.BodyMass;


class ScrapedBodyMassParserTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "70.2 kg (155 lb) 75 kg (165 lb)",
            "70.2 KILOGRAM (155 lb) 75 kg (165 lb)",
            "70.2 kilograms (155 lb) 75 kg (165 lb)",
            "70.2 KILOGRAMS (155 lb) 75 kg (165 lb)",
            "70.2 kg (155 lb)",
            "70.2 kg, (155 lb)",
            "70.2 kilos, (155 lb)",
            "70.2 KILO, (155 lb)",
            "70.2 kg,(155 lb)",
            "70.2 kg 155 lb",
            "70.2 KILOS 155 lb",
            "70.2 kg,155 lb",
            "70.2 kg",

    })
    void kilogramTakingPrecedenceOverLb(final String bodyMass){
        final BodyMass expectedBodyMass = new BodyMass();
        expectedBodyMass.setKilogram("70.2");
        expectedBodyMass.setPound("154.76");
        Assertions.assertEquals(
                expectedBodyMass, new ScrapedBodyMassParser().parse(bodyMass)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "155 lb 165 lb",
            "155 libra 165 libra",
            "155 libra pondo 165 libra pondo",
            "155 LB",
            "155 LIBRA",
            "155 LIBRA PONDO",
            "155 LIBRA pondo",
            "155 LB 145 lb",

    })
    void calculatingKiloFromPoundWhenKiloIsNotSpecified(final String bodyMass){
        final BodyMass expectedBodyMass = new BodyMass();
        expectedBodyMass.setKilogram("70.31");
        expectedBodyMass.setPound("155");
        Assertions.assertEquals(
                expectedBodyMass, new ScrapedBodyMassParser().parse(bodyMass)
        );
    }


}
package re.api.common.lib.parsers;

import common.lib.models.serializable.BodyMass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


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
        Assertions.assertEquals(
                new BodyMass().setKilogram("70.2").setPound("154.76"), new ScrapedBodyMassParser().parse(bodyMass)
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
        Assertions.assertEquals(
                new BodyMass().setKilogram("70.31").setPound("155"), new ScrapedBodyMassParser().parse(bodyMass)
        );
    }


}
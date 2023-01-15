package rest.re.app.scraper.converter.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class MathUtilsTest {

    @Test
    void shouldBe6Point14Feet(){
        // Given
        final Integer centimeters = 187;

        // When
        final Double result = MathUtils.convertCentimetersToFeet(centimeters);

        //Then
        Assertions.assertEquals(
                MathUtils.formatDoubleTo2DecimalPlace(6.14), MathUtils.formatDoubleTo2DecimalPlace(result)
        );
    }

}
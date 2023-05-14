package rest.re.app.api.rest.scraper.converter.utils;

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

    @Test
    void shouldBe1Point25Feet(){
        // Given
        final Double inches = 15.;

        // When
        final Double result = MathUtils.convertInchToFeet(inches);

        //Then
        Assertions.assertEquals(
                MathUtils.formatDoubleTo2DecimalPlace(1.25), MathUtils.formatDoubleTo2DecimalPlace(result)
        );
    }

    @Test
    void convertingKiloToPound(){
        // Given
        final Double kilo = 70.2;

        // When
        final Double result = MathUtils.convertKilogramToPound(kilo);

        //Then
        Assertions.assertEquals(
                MathUtils.formatDoubleTo2DecimalPlace(154.76), MathUtils.formatDoubleTo2DecimalPlace(result)
        );
    }

    @Test
    void convertingPoundToKilogram(){
        // Given
        final Double pound = 154.76;

        // When
        final Double result = MathUtils.convertPoundToKilogram(pound);

        //Then
        Assertions.assertEquals(
                MathUtils.formatDoubleTo2DecimalPlace(70.2), MathUtils.formatDoubleTo2DecimalPlace(result)
        );
    }

}
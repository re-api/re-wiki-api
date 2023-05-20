package rest.re.app.api.rest.scraper.service.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeInMillisecondsInterpreterTest {


    @ParameterizedTest
    @CsvSource(value = {
            "24,m,1440000",
            "24,h,86400000",
            "1,d,86400000",
            "2,s,2000"
    })
    @DisplayName("When interpret invoked then should convert to convert value.")
    void testingInterpret(final String timePortion, final Character unitPortion, final Integer expectedResult){
        Assertions.assertEquals(expectedResult, TimeInMillisecondsInterpreter.of(timePortion, unitPortion).interpret());
    }
}
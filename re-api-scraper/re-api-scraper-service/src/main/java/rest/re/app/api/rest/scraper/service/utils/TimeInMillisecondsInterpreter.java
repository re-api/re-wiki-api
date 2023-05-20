package rest.re.app.api.rest.scraper.service.utils;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor(staticName = "of")
public class TimeInMillisecondsInterpreter implements Interpreter<Integer>{
    private static final Integer HOUR_MIN_SEC_CONVERSION_RATE = 60;
    private static final Integer DAY_CONVERSION_RATE = 24;

    private String timePortion;
    private Character unitPortion;
    @Override
    public Integer interpret() {
        final Map<Character, Integer> conversionMapping = new HashMap<>();
        conversionMapping.put('d', DAY_CONVERSION_RATE * (int) Math.pow(HOUR_MIN_SEC_CONVERSION_RATE, 2) * 1000);
        conversionMapping.put('h', 1000 * (int) Math.pow(HOUR_MIN_SEC_CONVERSION_RATE, 2));
        conversionMapping.put('m', 1000 * HOUR_MIN_SEC_CONVERSION_RATE);
        conversionMapping.put('s', 1000);

        return Integer.parseInt(timePortion) * conversionMapping.get(unitPortion);
    }
}

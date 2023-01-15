package rest.re.app.scraper.converter.utils;

import java.text.DecimalFormat;

public class MathUtils {

    private static final Double CENTIMETER_TO_FEET_RATE = 0.0328084;

    private MathUtils(){

    }

    public static Double convertCentimetersToFeet(Integer centimeters){
        return centimeters * CENTIMETER_TO_FEET_RATE;
    }

    public static String formatDoubleTo2DecimalPlace(Double d){
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }
}

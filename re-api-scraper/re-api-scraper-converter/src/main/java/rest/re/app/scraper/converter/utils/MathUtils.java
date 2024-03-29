package rest.re.app.scraper.converter.utils;

import java.text.DecimalFormat;

public class MathUtils {

    private static final Double CENTIMETER_TO_FEET_RATE = 0.0328084;
    private static final Double INCH_TO_FEET_RATE = 0.083;
    private static final Double KILOGRAM_TO_POUND_RATE = 2.20462;

    private MathUtils(){

    }

    public static Double convertCentimetersToFeet(Integer centimeters){
        return centimeters * CENTIMETER_TO_FEET_RATE;
    }

    public static String formatDoubleTo2DecimalPlace(Double d){
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(d);
    }

    public static String formatToInteger(Double d){
        DecimalFormat df = new DecimalFormat("0");
        return df.format(d);
    }

    public static Double convertFeetToCentimeter(Double feet) {
        return feet / CENTIMETER_TO_FEET_RATE;
    }

    public static Double convertInchToFeet(Double inch){
        return inch * INCH_TO_FEET_RATE;
    }

    public static Double convertKilogramToPound(Double kilogram){
        return kilogram * KILOGRAM_TO_POUND_RATE;
    }

    public static Double convertPoundToKilogram(Double pound){
        return pound / KILOGRAM_TO_POUND_RATE;
    }
}

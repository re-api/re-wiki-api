package rest.re.app.scraper.converter.utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils(){

    }

    public static String matchCentimeter(String stringWithCentimeterFormat){
        return Optional.ofNullable(stringWithCentimeterFormat)
                .map(String::trim)
                .map(s->{
                    Pattern p = Pattern.compile("\\d+\\s*(cm)?");
                    Matcher m = p.matcher(s);
                    if (m.find()) {
                        return String.format("%s %s", m.group(0).trim().replaceAll("\\s*cm",""), "cm");
                    }else{
                        return "";
                    }
                })
                .orElse("");
    }
}

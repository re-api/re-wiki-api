package rest.re.app.scraper.converter.utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String STRING_FORMAT_WITH_TWO_PLACEHOLDERS = "%s %s";

    private StringUtils(){

    }

    public static String matchCentimeter(String stringWithCentimeterFormat){
        return Optional.ofNullable(stringWithCentimeterFormat)
                .map(String::trim)
                .map(s->{
                    Pattern p = Pattern.compile("\\d+\\s*cm");
                    Matcher m = p.matcher(s);
                    if (m.find()) {
                        return String.format(STRING_FORMAT_WITH_TWO_PLACEHOLDERS, m.group(0).trim().replaceAll("\\s*cm",""), "cm");
                    }else{
                        return "";
                    }
                })
                .orElse("");
    }

    public static String matchKilogram(String stringWithKilogramFormat){
        return Optional.ofNullable(stringWithKilogramFormat)
                .map(String::trim)
                .map(s->{
                    Pattern p = Pattern.compile("\\d+(\\.\\d+)?\\s*kg");
                    Matcher m = p.matcher(s);
                    if (m.find()) {
                        return String.format(STRING_FORMAT_WITH_TWO_PLACEHOLDERS, m.group(0).trim().replaceAll("\\s*kg",""), "kg");
                    }else{
                        return "";
                    }
                })
                .orElse("");
    }

    public static String matchPound(String stringWithPoundFormat){
        return Optional.ofNullable(stringWithPoundFormat)
                .map(String::trim)
                .map(s->{
                    Pattern p = Pattern.compile("\\d+(\\.\\d+)?\\s*lb");
                    Matcher m = p.matcher(s);
                    if (m.find()) {
                        return String.format(STRING_FORMAT_WITH_TWO_PLACEHOLDERS, m.group(0).trim().replaceAll("\\s*lb",""), "lb");
                    }else{
                        return "";
                    }
                })
                .orElse("");
    }

    public static String matchFeet(String stringWithFeetMatch){
        return Optional.ofNullable(stringWithFeetMatch)
                .map(s->s.replace("feet", "ft"))
                .map(s->s.replace("inches", "in"))
                .map(s->s.replace("inch", "in"))
                .map(s->s.replace("(", ""))
                .map(s->s.replace(")", ""))
                .map(s->s.replace(",", ""))
                .map(String::trim)
                .map(s->{
                    Pattern p = Pattern.compile("(\\d+\\s*ft)\\s*(\\d\\s*(in)?)?");
                    Matcher m = p.matcher(s);
                    if (m.matches()) {
                        return String.format(
                                "%s %s %s %s",
                                m.group(1).trim()
                                        .replaceAll("\\s*ft",""),
                                "ft",
                                Optional.ofNullable(m.group(2))
                                        .map(ss->ss.trim().replaceAll("\\s*in",""))
                                        .orElse("0"),

                                "in"
                        );
                    }else{
                        return "";
                    }
                })
                .orElse("");
    }
}

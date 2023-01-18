package rest.re.app.scraper.converter.parsers;

import common.lib.models.serializable.Height;
import rest.re.app.scraper.converter.utils.MathUtils;
import rest.re.app.scraper.converter.utils.StringUtils;

import java.util.Optional;

public class HeightParser implements Parser<Height>{
    @Override
    public Height parse(String string) {
        return Optional.ofNullable(string)
                .map(String::trim)
                .map(s->{
                    final String matchedCm = StringUtils.matchCentimeter(s);
                    if(matchedCm.length() > 0){
                        return parseWhenCentimeterMatched(s);
                    }else if(StringUtils.matchFeet(s).length() > 0){
                        return parseWhenFeetMatched(s);
                    }else {
                        return new Height();
                    }
                })
                .orElse(new Height());
    }

    private Height parseWhenFeetMatched(String ft) {
        final String matchedFeet = StringUtils.matchFeet(ft);
        final String removedTagFeet = removeTagFeet(matchedFeet);
        final String[] splitFeetInfo = removedTagFeet.split("\\s+");

        final Double feetDouble = Double.valueOf(splitFeetInfo[0]);
        final Double inchDouble = MathUtils.convertInchToFeet(Double.valueOf(splitFeetInfo[1]));

        final Double resultFeetValue = feetDouble + inchDouble;

        return new Height()
                .setCentimeters(MathUtils.formatToInteger(MathUtils.convertFeetToCentimeter(resultFeetValue)))
                .setFeet(MathUtils.formatDoubleTo2DecimalPlace(resultFeetValue));
    }

    private Height parseWhenCentimeterMatched(String cm){
        final String matchedCentimeter = StringUtils.matchCentimeter(cm);
        final Integer centimeter = Integer
                .parseInt(matchedCentimeter.replace("cm", "").trim());
        final Double feet = MathUtils.convertCentimetersToFeet(centimeter);
        return new Height()
                .setCentimeters(centimeter.toString())
                .setFeet(MathUtils.formatDoubleTo2DecimalPlace(feet));
    }

    private String removeTagFeet(final String feetString){
        return feetString
                .replace("ft", "")
                .replace("in", "")
                .trim();
    }
}

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
                    final String matchedCentimeter = StringUtils.matchCentimeter(s);
                    final Integer centimeter = Integer
                            .parseInt(matchedCentimeter.replace("cm", "").trim());
                    final Double feet = MathUtils.convertCentimetersToFeet(centimeter);
                    return new Height()
                            .setCentimeters(centimeter.toString())
                            .setFeet(MathUtils.formatDoubleTo2DecimalPlace(feet));
                })
                .orElse(new Height());
    }
}

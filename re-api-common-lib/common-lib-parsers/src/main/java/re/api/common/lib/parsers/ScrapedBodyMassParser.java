package re.api.common.lib.parsers;


import re.api.common.lib.utils.MathUtils;
import re.api.common.lib.utils.StringUtils;
import rest.re.app.api.rest.api.model.BodyMass;

import java.util.Optional;

public class ScrapedBodyMassParser implements Parser<BodyMass> {

    @Override
    public BodyMass parse(String string) {
        return Optional.ofNullable(string)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(s -> s.replace("kilo", "kg"))
                .map(s -> s.replace("kilos", "kg"))
                .map(s -> s.replace("kilogram", "kg"))
                .map(s -> s.replace("kilograms", "kg"))
                .map(s -> s.replace("libra", "lb"))
                .map(s -> s.replace("libras", "lb"))
                .map(s -> s.replace("libra pondo", "lb"))
                .map(s -> s.replace("libras pondo", "lb"))
                .map(s -> {
                    final String matchedKilogram = StringUtils.matchKilogram(s);
                    if (matchedKilogram.length() > 0) {
                        return parseWhenKilogramMatched(s);
                    } else if (StringUtils.matchPound(s).length() > 0) {
                        return parseWhenPoundMatched(s);
                    } else {
                        return new BodyMass();
                    }
                })
                .orElse(new BodyMass());
    }

    private BodyMass parseWhenPoundMatched(String pounds) {
        final String matchedPound = StringUtils.matchPound(pounds);
        final Double p = Double.valueOf(matchedPound.replace("lb", "").trim());

        final BodyMass bodyMass = new BodyMass();
        bodyMass.setKilogram(MathUtils.formatDoubleTo2DecimalPlace(MathUtils.convertPoundToKilogram(p)));
        bodyMass.setPound(MathUtils.formatDoubleTo2DecimalPlace(p));

        return bodyMass;
    }

    private BodyMass parseWhenKilogramMatched(final String kilogram) {
        final String matchedKilogram = StringUtils.matchKilogram(kilogram);
        final Double kg = Double.valueOf(matchedKilogram.replace("kg", "").trim());
        final Double pounds = MathUtils.convertKilogramToPound(kg);

        final BodyMass bodyMass = new BodyMass();
        bodyMass.setKilogram(MathUtils.formatDoubleTo2DecimalPlace(kg));
        bodyMass.setPound(MathUtils.formatDoubleTo2DecimalPlace(pounds));

        return bodyMass;
    }

}

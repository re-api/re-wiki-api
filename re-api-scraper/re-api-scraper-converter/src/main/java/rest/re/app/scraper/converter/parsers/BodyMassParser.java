package rest.re.app.scraper.converter.parsers;

import common.lib.models.serializable.BodyMass;
import rest.re.app.scraper.converter.utils.MathUtils;
import rest.re.app.scraper.converter.utils.StringUtils;

import java.util.Optional;

public class BodyMassParser implements Parser<BodyMass>{

    @Override
    public BodyMass parse(String string) {
        return Optional.ofNullable(string)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(s->s.replace("kilo", "kg"))
                .map(s->s.replace("kilos", "kg"))
                .map(s->s.replace("kilogram", "kg"))
                .map(s->s.replace("kilograms", "kg"))
                .map(s->s.replace("libra", "lb"))
                .map(s->s.replace("libras", "lb"))
                .map(s->s.replace("libra pondo", "lb"))
                .map(s->s.replace("libras pondo", "lb"))
                .map(s->{
                    final String matchedKilogram = StringUtils.matchKilogram(s);
                    if(matchedKilogram.length() > 0){
                        return parseWhenKilogramMatched(s);
                    }else if(StringUtils.matchPound(s).length() > 0){
                        return parseWhenPoundMatched(s);
                    }else {
                        return new BodyMass();
                    }
                })
                .orElse(new BodyMass());
    }

    private BodyMass parseWhenPoundMatched(String pounds) {
        final String matchedPound = StringUtils.matchPound(pounds);
        final Double p = Double.valueOf(matchedPound.replace("lb", "").trim());
        return new BodyMass()
                .setKilogram(MathUtils.formatDoubleTo2DecimalPlace(MathUtils.convertPoundToKilogram(p)))
                .setPound(MathUtils.formatDoubleTo2DecimalPlace(p));
    }

    private BodyMass parseWhenKilogramMatched(final String kilogram){
        final String matchedKilogram = StringUtils.matchKilogram(kilogram);
        final Double kg = Double.valueOf(matchedKilogram.replace("kg", "").trim());
        final Double pounds = MathUtils.convertKilogramToPound(kg);
        return new BodyMass()
                .setKilogram(MathUtils.formatDoubleTo2DecimalPlace(kg))
                .setPound(MathUtils.formatDoubleTo2DecimalPlace(pounds));
    }

}

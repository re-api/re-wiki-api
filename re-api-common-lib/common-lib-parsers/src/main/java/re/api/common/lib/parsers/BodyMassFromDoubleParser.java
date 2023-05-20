package re.api.common.lib.parsers;

import re.api.common.lib.utils.MathUtils;
import rest.re.app.api.rest.api.model.BodyMass;

import java.text.DecimalFormat;
import java.util.Optional;

public class BodyMassFromDoubleParser implements Parser<BodyMass> {
    @Override
    public BodyMass parse(String string) {
        return Optional.ofNullable(string)
                .map(s->{
                    if(s.matches("^[0-9]+[.]?([0-9]+)?$")){
                        final BodyMass bodyMass = new BodyMass();
                        final DecimalFormat df = new DecimalFormat("#.##");
                        bodyMass.setKilogram(s);
                        bodyMass.setPound(df.format(MathUtils.convertKilogramToPound(Double.valueOf(s))));
                        return bodyMass;
                    }else{
                        return null;
                    }
                })
                .orElse(null);
    }
}

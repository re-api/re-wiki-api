package re.api.common.lib.parsers;

import re.api.common.lib.utils.MathUtils;
import rest.re.app.api.rest.api.model.Height;

import java.util.Optional;

public class HeightFromIntegerParser implements Parser<Height> {
    @Override
    public Height parse(String string) {
        return Optional.ofNullable(string)
                .map(s -> {
                    if (s.matches("^[0-9]{1,3}$")) {
                        final Height height = new Height();
                        height.setCentimeters(s);
                        height.setFeet(MathUtils.convertCentimetersToFeet(Integer.valueOf(s)).toString());
                        return height;
                    } else {
                        return null;
                    }
                })
                .orElse(null);
    }
}

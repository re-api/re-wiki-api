package rest.re.app.scraper.converter.utils;

import org.jsoup.nodes.Document;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Element;

public class CharacterConverterUtils {

    private CharacterConverterUtils(){

    }

    public static List<String> filterElementByContainingStrings(Document document, String... containingStrings) {
        return document.getElementsByClass("pi-data-label")
                            .stream()
                            .filter(el-> Arrays.stream(containingStrings)
                                    .map(s->el.text().toLowerCase().contains(s))
                                    .reduce(
                                            false,
                                            (acc, item)->  item|| acc
                                    )
                            )
                            .map(Element::firstElementSibling)
                            .map(Element::text)
                            .collect(Collectors.toList());
    }
}

package re.api.common.lib.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import java.util.Optional;
import java.util.stream.Collectors;
import org.jsoup.nodes.Element;


public class CharacterConverterUtils {

    private CharacterConverterUtils(){
        // Keep constructor private and empty to prevent class to be instantiated.
    }

    /**
     * Match the elements by the containingStrings and return the next sibling element.
     * @param document The Scraped HTML document.
     * @param containingStrings The portion of strings to match the HTML element.
     * @return Return a list of filtered element text values.
     */
    public static List<String> filterElementInPortableInfoBoxByContainingStrings(final Document document,
                                                                                 final String... containingStrings) {
        return document.getElementsByClass("pi-data-label")
                            .stream()
                            .filter(el-> Arrays.stream(containingStrings)
                                    .map(s->el.text().toLowerCase().contains(s))
                                    .reduce(false, (acc, item)->  item || acc))
                            .map(Element::nextElementSibling)
                            .map(element -> {
                                return Optional.ofNullable(element)
                                        .map(e->e.html().replaceAll("</?br>", ","))
                                        .map(Jsoup::parse)
                                        .map(Document::text)
                                        .orElse(null);
                                // if br> found in the element, split it!



                            })
                            .map(CharacterConverterUtils::removeSourceReferences)
                            .collect(Collectors.toList());
    }

    /**
     * Takes a string and removes the source references.
     * Example of source references: [1], [notes 158], c., etc.
     * @param string the input value
     * @return the value without source references.
     */
    public static String removeSourceReferences(String string){
        if(Objects.nonNull(string)){
            return string
                    .replaceAll("\\[.*?]", "") // Remove everything wrapped between quotes.
                    .replaceAll("^[a-z]\\.", "") // remove the one letter followed by a dot at the start of stringEg: c.
                    .replaceAll(" [a-z]\\.", " ") // remove the one letter followed by a dot Eg: c.
                    .trim();
        }else{
            return null;
        }
    }
}

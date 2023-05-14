package rest.re.app.api.rest.scraper.converter;

import org.jsoup.nodes.Document;

import java.util.Collections;
import java.util.List;

public class Document2ListOfGameNamesConverter implements Convertible<Document, List<String>> {
    @Override
    public List<String> convert(Document document) {
        // @TODO: implement it.
        return Collections.emptyList();
    }
}

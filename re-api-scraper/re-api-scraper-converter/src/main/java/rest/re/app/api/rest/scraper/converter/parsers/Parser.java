package rest.re.app.api.rest.scraper.converter.parsers;

public interface Parser<T> {

    T parse(String string);
}

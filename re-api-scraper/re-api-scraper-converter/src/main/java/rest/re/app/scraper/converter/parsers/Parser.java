package rest.re.app.scraper.converter.parsers;

public interface Parser<T> {

    T parse(String string);
}

package rest.re.app.scraper.converter;

public interface Converter<T, U>{

    U convert(T t);
}

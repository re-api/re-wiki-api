package rest.re.app.scraper.converter;

/**
 * Converts something into something else.
 * @param <T> The input thing to be converted.
 * @param <U> The converted thing.
 */
public interface Convertible<T, U>{

    /**
     * Converts something into something else.
     * @param t the thing to be converted.
     * @return the converted thing of type U.
     */
    U convert(T t);
}

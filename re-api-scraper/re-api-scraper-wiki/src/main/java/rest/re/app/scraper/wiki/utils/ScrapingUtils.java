package rest.re.app.scraper.wiki.utils;


import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ScrapingUtils {

    private ScrapingUtils() {}

    /**
     * Removes Slashes at the start and end of string
     * @param string The string input
     * @return string without the slash at the start and end
     */
    public static String trimSlashes(final String string){
        return Optional.ofNullable(string)
                .map(s->{
                    if(s.startsWith("/")){
                        return s.substring(1);
                    }
                    return s;
                })
                .map(s->{
                    if(s.endsWith("/")){
                        return s.substring(0,s.length()-1);
                    }
                    return s;
                }).orElse("");
    }

    /**
     * Remove append uri paths ensuring that the slashes won't duplicate
     * @param uriPaths The list of Uri Path strings.
     * @return the joined uri paths
     */
    public static String appendUriPath(String... uriPaths){
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(uriPaths).forEach(path-> sb.append(trimSlashes(path)).append(Objects.nonNull(path) ? "/" : ""));
        return trimSlashes(sb.toString());
    }
}

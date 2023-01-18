package rest.re.app.scraper.converter.processables;

import org.javatuples.Pair;
import org.jsoup.nodes.Document;
import rest.re.app.scraper.converter.utils.CharacterConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface PortableInfoBoxProcessable {

    /**
     * Loops through the elements inside InfoBox on the side on the page and executes an action based on
     * the consumer passed in the parameter. Likely a setter will be invoked in the client side of the consumer.
     * Notice: It only works for Setters that takes String as parameter! If needed other type, overload the method.
     *
     * @param tuple The tuple containing HTML document and the character instance.
     * @param consumer The function that will be executed when filter is finished.
     * @param containingStrings The list of strings that should match the elements label text.
     * @return The same tuple, but with the V element updated by the consumer.
     * @param <U> The type the document will be processed into.
     */
    static<U> Pair<Document, U> processInfoBox(
            Pair<Document, U> tuple, Consumer<String> consumer, String... containingStrings
    ) {
        return Optional.ofNullable(tuple)
                .map(t->{
                    final int firstIndex = 0;
                    final List<String> filteredInfo = CharacterConverterUtils
                            .filterElementInPortableInfoBoxByContainingStrings(t.getValue0(), containingStrings);

                    if(!filteredInfo.isEmpty()){
                        consumer.accept(filteredInfo.get(firstIndex));
                    }
                    return t;
                })
                .orElse(new Pair<>(null, null));
    }

}

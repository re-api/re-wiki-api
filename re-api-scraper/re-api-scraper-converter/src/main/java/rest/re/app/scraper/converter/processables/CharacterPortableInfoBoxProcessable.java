package rest.re.app.scraper.converter.processables;

import org.javatuples.Pair;
import org.jsoup.nodes.Document;
import rest.re.app.scraper.converter.models.ScrapedGameCharacter;

public interface CharacterPortableInfoBoxProcessable extends PortableInfoBoxProcessable {

    /**
     * Processes the name field of the character.
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if name isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processName(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the localisation field of the character.
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state localisation if name isn't null.
     */
    Pair<Document, ScrapedGameCharacter>  processLocalisation(Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the description field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if description isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processDescription(Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the dateOfBirth field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if dateOfBirth isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processDateOfBirth(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the dateOfDeath field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if dateOfDeath isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processDateOfDeath(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the placeOfBirth field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if placeOfBirth isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processPlaceOfBirth(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the placeOfDeath field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if placeOfBirth isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processPlaceOfDeath(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the race field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if race isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processRace(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the occupation field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if occupation isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processOccupation(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the status field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if status isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processStatus(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the sex field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if sex isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processSex(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the bloodType field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if bloodType isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processBloodType(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the height field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if height isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processHeight(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the bodyMass field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if bodyMass isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processBodyMass(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the firstAppearance field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if firstAppearance isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processFirstAppearance(final Pair<Document, ScrapedGameCharacter> tuple);

    /**
     * Processes the lastAppearance field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if lastAppearance isn't null.
     */
    Pair<Document, ScrapedGameCharacter> processLastAppearance(final Pair<Document, ScrapedGameCharacter> tuple);
}

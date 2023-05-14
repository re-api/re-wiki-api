package rest.re.app.api.rest.scraper.converter.processables;

import common.lib.models.serializable.GameCharacter;
import org.javatuples.Pair;
import org.jsoup.nodes.Document;

public interface CharacterPortableInfoBoxProcessable extends PortableInfoBoxProcessable {

    /**
     * Processes the name field of the character.
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if name isn't null.
     */
    Pair<Document, GameCharacter> processName(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the localisation field of the character.
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state localisation if name isn't null.
     */
    Pair<Document, GameCharacter>  processLocalisation(Pair<Document, GameCharacter> tuple);

    /**
     * Processes the description field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if description isn't null.
     */
    Pair<Document, GameCharacter> processDescription(Pair<Document, GameCharacter> tuple);

    /**
     * Processes the dateOfBirth field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if dateOfBirth isn't null.
     */
    Pair<Document, GameCharacter> processDateOfBirth(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the dateOfDeath field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if dateOfDeath isn't null.
     */
    Pair<Document, GameCharacter> processDateOfDeath(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the placeOfBirth field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if placeOfBirth isn't null.
     */
    Pair<Document, GameCharacter> processPlaceOfBirth(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the placeOfDeath field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if placeOfBirth isn't null.
     */
    Pair<Document, GameCharacter> processPlaceOfDeath(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the race field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if race isn't null.
     */
    Pair<Document, GameCharacter> processRace(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the occupation field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if occupation isn't null.
     */
    Pair<Document, GameCharacter> processOccupation(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the status field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if status isn't null.
     */
    Pair<Document, GameCharacter> processStatus(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the sex field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if sex isn't null.
     */
    Pair<Document, GameCharacter> processSex(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the bloodType field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if bloodType isn't null.
     */
    Pair<Document, GameCharacter> processBloodType(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the height field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if height isn't null.
     */
    Pair<Document, GameCharacter> processHeight(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the bodyMass field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if bodyMass isn't null.
     */
    Pair<Document, GameCharacter> processBodyMass(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the firstAppearance field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if firstAppearance isn't null.
     */
    Pair<Document, GameCharacter> processFirstAppearance(final Pair<Document, GameCharacter> tuple);

    /**
     * Processes the lastAppearance field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if lastAppearance isn't null.
     */
    Pair<Document, GameCharacter> processLastAppearance(final Pair<Document, GameCharacter> tuple);
}

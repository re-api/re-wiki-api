package rest.re.app.scraper.converter;

import org.javatuples.Pair;
import org.jsoup.nodes.Document;
import rest.re.app.scraper.converter.models.ScrapedGameCharacter;
import rest.re.app.scraper.converter.processables.CharacterPortableInfoBoxProcessable;
import rest.re.app.scraper.converter.processables.PortableInfoBoxProcessable;
import rest.re.app.scraper.converter.utils.CharacterConverterUtils;


import java.util.Objects;
import java.util.Optional;

/**
 * Converts a Document into a ScrapedGameCharacter object implementing the Convertable interface.
 */
public class Document2GameCharacterConverter implements Convertible<Document, ScrapedGameCharacter>, CharacterPortableInfoBoxProcessable {

    /**
     * Processes the name of the character.
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if name isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processName(Pair<Document, ScrapedGameCharacter> tuple) {
        return Optional.ofNullable(tuple)
                .map(t->{
                    try{
                        final String charName = Objects.requireNonNull(t.getValue0()
                                .getElementsByClass("pi-title").first()).text();
                        t.getValue1().setName(CharacterConverterUtils.removeSourceReferences(charName));
                        return t;
                    }catch (NullPointerException e){
                        return t;
                    }
                }).orElse(new Pair<>(null, null));
    }

    @Override
    public Pair<Document, ScrapedGameCharacter> processLocalisation(Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setLocalization,
                "localisation");
    }

    /**
     * Processes the description field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if description isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processDescription(Pair<Document, ScrapedGameCharacter> tuple) {
        return Optional.ofNullable(tuple)
                .map(t->{
                    final Integer indexWhereDescriptionIsLocated = 2;
                    try{
                        final String description = Objects.requireNonNull(t.getValue0()
                                .getElementsByClass("mw-parser-output").first()).select("p")
                                .get(indexWhereDescriptionIsLocated)
                                .text();
                        t.getValue1().setDescription(CharacterConverterUtils.removeSourceReferences(description));
                        return t;
                    }catch (NullPointerException e){
                        return t;
                    }
                }).orElse(new Pair<>(null, null));
    }

    /**
     * Processes the dateOfBirth field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if dateOfBirth isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processDateOfBirth(final Pair<Document, ScrapedGameCharacter> tuple){
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setDateOfBirth, "date of birth");
    }

    /**
     * Processes the dateOfDeath field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if dateOfDeath isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processDateOfDeath(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setDateOfDeath, "date of death");
    }

    /**
     * Processes the placeOfBirth field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if placeOfBirth isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processPlaceOfBirth(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setPlaceOfBirth, "place of birth");
    }

    /**
     * Processes the placeOfDeath field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if placeOfBirth isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processPlaceOfDeath(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setPlaceOfDeath, "place of death");
    }

    /**
     * Processes the race field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if race isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processRace(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setRace, "race", "nationality");
    }

    /**
     * Processes the occupation field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if occupation isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processOccupation(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setOccupation, "occupation");
    }

    /**
     * Processes the status field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if status isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processStatus(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setStatus, "status");
    }

    /**
     * Processes the sex field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if sex isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processSex(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setSex, "sex");
    }

    /**
     * Processes the bloodType field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if bloodType isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processBloodType(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setBloodType, "blood");
    }

    /**
     * Processes the height field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if height isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processHeight(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setHeight, "height");
    }

    /**
     * Processes the bodyMass field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if bodyMass isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processBodyMass(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setBodyMass, "mass");
    }

    /**
     * Processes the firstAppearance field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if firstAppearance isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processFirstAppearance(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setFirstAppearance, "first appearance");
    }

    /**
     * Processes the lastAppearance field of a scrapedGameCharacter instance
     * @param tuple the Pair that will contain the HTML Document and the ScrapedGameCharacter instance.
     * @return the same tuple, but state modified if lastAppearance isn't null.
     */
    @Override
    public Pair<Document, ScrapedGameCharacter> processLastAppearance(final Pair<Document, ScrapedGameCharacter> tuple) {
        return PortableInfoBoxProcessable.processInfoBox(tuple, tuple.getValue1()::setLastAppearance, "last appearance");
    }

    @Override
    public ScrapedGameCharacter convert(Document document) {
        return Optional.ofNullable(document)
                .map(doc -> new Pair<>(doc, new ScrapedGameCharacter()))
                .map(this::processName)
                .map(this::processLocalisation)
                .map(this::processDescription)
                .map(this::processDateOfBirth)
                .map(this::processDateOfDeath)
                .map(this::processPlaceOfBirth)
                .map(this::processPlaceOfDeath)
                .map(this::processDateOfDeath)
                .map(this::processRace)
                .map(this::processOccupation)
                .map(this::processStatus)
                .map(this::processSex)
                .map(this::processBloodType)
                .map(this::processHeight)
                .map(this::processBodyMass)
                .map(this::processFirstAppearance)
                .map(this::processLastAppearance)
                .map(Pair::getValue1)
                .orElse(new ScrapedGameCharacter());
    }
}

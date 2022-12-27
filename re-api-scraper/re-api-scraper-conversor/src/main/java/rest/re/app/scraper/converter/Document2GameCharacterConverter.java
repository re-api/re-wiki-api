package rest.re.app.scraper.converter;

import org.javatuples.Pair;
import org.jsoup.nodes.Document;
import rest.re.app.scraper.converter.models.GameCharacter;
import rest.re.app.scraper.converter.utils.CharacterConverterUtils;

import java.util.List;
import java.util.Optional;

public class Document2GameCharacterConverter implements Converter<Document, GameCharacter> {

    private Pair<Document, GameCharacter> processDateOfBirth(final Pair<Document, GameCharacter> tuple){
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredDateOfBirthValue = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "date of birth");

                    if(!filteredDateOfBirthValue.isEmpty()){
                        t.getValue1().setDateOfBirth(filteredDateOfBirthValue.get(0));
                    }
                    return t;
                })
                .get();
    }


    private Pair<Document, GameCharacter> processDateOfDeath(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "date of death");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setDateOfDeath(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processPlaceOfBirth(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "place of birth");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setPlaceOfBirth(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processPlaceOfDeath(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "place of death");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setPlaceOfDeath(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processRace(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "race", "nationality");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setRace(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processOccupation(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "occupation");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setOccupation(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processStatus(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "status");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setStatus(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processSex(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "sex");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setSex(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processBloodType(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "blood");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setBloodType(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processHeight(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "height");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setHeight(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processBodyMass(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "mass");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setBodyMass(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processFirstAppearance(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "first appearance");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setFirstAppearance(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    private Pair<Document, GameCharacter> processLastAppearance(final Pair<Document, GameCharacter> tuple) {
        return Optional.of(tuple)
                .map(t->{
                    final List<String> filteredElements = CharacterConverterUtils
                            .filterElementByContainingStrings(t.getValue0(),
                                    "last appearance");

                    if(!filteredElements.isEmpty()){
                        t.getValue1().setLastAppearance(filteredElements.get(0));
                    }
                    return t;
                })
                .get();
    }

    @Override
    public GameCharacter convert(Document document) {
        return Optional.ofNullable(document)
                .map(doc -> new Pair<>(doc, new GameCharacter()))
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
                .orElse(new GameCharacter());
    }
}

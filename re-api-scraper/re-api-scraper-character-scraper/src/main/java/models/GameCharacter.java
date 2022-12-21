package models;

import rest.re.app.scraper.crawler.models.ScrapedEntity;

public class GameCharacter implements ScrapedEntity {
    private final String name;

    public GameCharacter(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GameCharacter that = (GameCharacter) o;

        return new org.apache.commons.lang.builder.EqualsBuilder().append(name, that.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37).append(name).toHashCode();
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                '}';
    }
}

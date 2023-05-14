package rest.re.app.api.rest.scraper.conversor.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import rest.re.app.api.rest.scraper.wiki.utils.ScrapingUtils;


class ScrapingUtilsTest {


    @ParameterizedTest
    @ValueSource(strings = {"/foo/", "foo/", "/foo"})
    void trimSlashesShouldRemoveIndexFromStartAndEndOfString(String given){
        //When
        final String result = ScrapingUtils.trimSlashes(given);
        // Then
        Assertions.assertEquals("foo", result);
    }



    @ParameterizedTest
    @NullSource()
    void trimSlashesShouldReturnEmptyStringIfNul(String given){
        //When
        final String result = ScrapingUtils.trimSlashes(given);
        // Then
        Assertions.assertEquals("", result);
    }


    @Test
    void appendUriPathShouldNotDuplicateSlashes(){
        // Given
        final String url = "https://residentevil.fandom.com/wiki/";
        final String path = "/Resident_Evil_games#Major_releases";
        //When
        final String result = ScrapingUtils.appendUriPath(url, path);
        // Then
        Assertions.assertEquals("https://residentevil.fandom.com/wiki/Resident_Evil_games#Major_releases", result);
    }

    @Test
    void appendUriPathShouldNotRemoveSlashAtTheEndOfTheBuiltUrl(){
        // Given
        final String url = "https://residentevil.fandom.com/wiki/";
        final String path = "/Resident_Evil_games#Major_releases/";
        //When
        final String result = ScrapingUtils.appendUriPath(url, path);
        // Then
        Assertions.assertEquals("https://residentevil.fandom.com/wiki/Resident_Evil_games#Major_releases", result);
    }

    @Test
    void appendUriPathShouldReplaceNullParamWithEmptyString(){
        // Given
        final String url = "https://residentevil.fandom.com/wiki/";
        final String path = "/Resident_Evil_games#Major_releases/";
        //When
        final String result = ScrapingUtils.appendUriPath(url, null, path);
        // Then
        Assertions.assertEquals("https://residentevil.fandom.com/wiki/Resident_Evil_games#Major_releases", result);
    }
}
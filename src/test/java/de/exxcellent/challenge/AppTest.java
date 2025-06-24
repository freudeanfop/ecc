package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

    String dataPrefix = "/src/main/resources/de/exxcellent/challenge/";


    // Test for wrong entries
    @Test
    void runCheckFakeEntries() {
        App.main(dataPrefix + "footballFakeEntry.csv", "FOOTBALL");
    }

    // Test for file not existing
    @Test
    void runFileNotExisiting() {
        App.main(dataPrefix + "weather2.csv", "WEATHER");
    }
    
    // Test for wrong Recordtype
    @Test
    void runWrongEnum() {
        App.main(dataPrefix + "weather.csv", "FOOTBALL");
    }

    //Test for expected behavior for weather
    @Test
    void runWeather() {
        App.main(dataPrefix + "weather.csv", "WEATHER");
    }

    // Test for expected bahavior for football
    @Test
    void runFootball() {
        App.main(dataPrefix + "football.csv", "FOOTBALL");
    }
    
    

}
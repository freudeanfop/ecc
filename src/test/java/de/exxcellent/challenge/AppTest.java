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


    
    @Test
    void runCheckFakeEntries() {
        App.main(dataPrefix + "footballFakeEntry.csv", "FOOTBALL");
    }

    @Test
    void runFileNotExisiting() {
        App.main(dataPrefix + "weather2.csv", "WEATHER");
    }
    

    @Test
    void runWrongEnum() {
        App.main(dataPrefix + "weather.csv", "FOOTBALL");
    }

    @Test
    void runWeather() {
        App.main(dataPrefix + "weather.csv", "WEATHER");
    }


    @Test
    void runFootball() {
        App.main(dataPrefix + "football.csv", "FOOTBALL");
    }
    
    

}
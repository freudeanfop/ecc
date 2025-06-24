package de.exxcellent.challenge;

import java.util.Arrays;

/*
* WeatherRecord class represents the weather statistics of a day and implements the Record interface
* Fields to store day, maximum temperature, minimum temperature, average temperature, average dew point
* , precipitation in one hour, the pDirection (What is that?), average speed (of what?), wind direction, wind direction
* maximum speed (of what?), the sky cover percentage, the maximum amount of rain, the minimum amount of rain (per what?)
* and the average SLP (what is that?)
*/
public class WeatherRecord implements Record{
    int day;
    int maxTemp;
    int minTemp;
    float avgTemp;
    float avgDewPoint;
    int oneHrPrecipitation;
    int pDirection;
    float avgSpeed;
    int windDir;
    int maxSpeed;
    float skyCover;
    int maxRain;
    int minRain;
    float r_avgSLP;

    /*
    * Constructor takes a String array (CSV line split) and parses the values into respective fields
    * Throws IllegalArgumentException if data is missing or not in expected format or if Min and Max do not align
    */
    public WeatherRecord(String[] record) {
        try {
            this.day = Integer.valueOf(record[0]);
            this.maxTemp = Integer.valueOf(record[1]);
            this.minTemp = Integer.valueOf(record[2]);
            this.avgTemp = Float.valueOf(record[3]);
            this.avgDewPoint = Float.valueOf(record[4]);
            this.oneHrPrecipitation = Integer.valueOf(record[5]);
            this.pDirection = Integer.valueOf(record[6]);
            this.avgSpeed = Float.valueOf(record[7]);
            this.windDir = Integer.valueOf(record[8]);
            this.maxSpeed = Integer.valueOf(record[9]);
            this.skyCover = Float.valueOf(record[10]);
            this.maxRain = Integer.valueOf(record[11]);
            this.minRain = Integer.valueOf(record[12]);
            this.r_avgSLP = Float.valueOf(record[13]);

            if (maxTemp < minTemp) {
                throw new IllegalArgumentException("maxTemp < minTemp: " + maxTemp + " < " + minTemp);
            }

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid data in record: " + Arrays.toString(record), e);
        }
    }

    // Prints the day as the identifier for this record
    @Override
    public void printRecordIdentifier(){
        System.out.printf("Day: %s \n", this.day);
    }

    // Computes the ranking value as the absolute maximum and minimum temperatur
    @Override
    public int computeRankingValue(){
        return this.maxTemp - this.minTemp;
    }
}

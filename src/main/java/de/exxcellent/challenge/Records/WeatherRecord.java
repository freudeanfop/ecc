package de.exxcellent.challenge;

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
    float r;
    float avgSLP;

    public WeatherRecord(int day, int maxTemp, int minTemp, float avgTemp, float avgDewPoint,
                         int oneHrPrecipitation, int pDirection, float avgSpeed, int windDir,
                         int maxSpeed, float skyCover, int maxRain, int minRain,
                         float r, float avgSLP) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.avgTemp = avgTemp;
        this.avgDewPoint = avgDewPoint;
        this.oneHrPrecipitation = oneHrPrecipitation;
        this.pDirection = pDirection;
        this.avgSpeed = avgSpeed;
        this.windDir = windDir;
        this.maxSpeed = maxSpeed;
        this.skyCover = skyCover;
        this.maxRain = maxRain;
        this.minRain = minRain;
        this.r = r;
        this.avgSLP = avgSLP;
    }

    @Override
    public void printRecord(){

    }

    @Override
    public int computeRanking(){

    }
}

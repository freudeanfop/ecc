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

    public WeatherRecord(String[] record) {
        
        // ensure max Temp >= min Temp
        // int,int,int,float,float,int,int,float,int,int,float,int,int,float,float
        this.day = Integer.valueOf(record[0]);
        this.maxTemp = Integer.valueOf(record[0]);
        this.minTemp = Integer.valueOf(record[0]);
        this.avgTemp = Float.valueOf(record[0]);
        this.avgDewPoint = Float.valueOf(record[0]);
        this.oneHrPrecipitation = Integer.valueOf(record[0]);
        this.pDirection = Integer.valueOf(record[0]);
        this.avgSpeed = Float.valueOf(record[0]);
        this.windDir = Integer.valueOf(record[0]);
        this.maxSpeed = Integer.valueOf(record[0]);
        this.skyCover = Float.valueOf(record[0]);
        this.maxRain = Integer.valueOf(record[0]);
        this.minRain = Integer.valueOf(record[0]);
        this.r = Float.valueOf(record[0]);
        this.avgSLP = Float.valueOf(record[0]);
    }

    @Override
    public void printRecord(){
        System.out.printf("Day: %s", this.day);
    }

    @Override
    public int computeRanking(){
        return this.maxTemp - this.minTemp;
    }
}

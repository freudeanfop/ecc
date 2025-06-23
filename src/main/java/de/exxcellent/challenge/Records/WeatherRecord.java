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
    float r_avgSLP;

    public WeatherRecord(String[] record) {
        
        // ensure max Temp >= min Temp
        // int,int,int,float,float,int,int,float,int,int,float,int,int,float,float
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
    }

    @Override
    public void printRecord(){
        System.out.printf("Day: %s \n", this.day);
    }

    @Override
    public int computeRanking(){
        return this.maxTemp - this.minTemp;
    }
}

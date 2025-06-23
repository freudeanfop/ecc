package de.exxcellent.challenge;

import java.util.Arrays;

public class FootballRecord implements Record{

    int amountOfAttributes = 8;
    String team;
    int games;
    int wins;
    int losses;
    int draws;
    int goals;
    int goalsAllowed;
    int points;

    

    public FootballRecord(String[] record) {
        try {
            this.team = record[0];
            this.games = Integer.valueOf(record[1]);
            this.wins = Integer.valueOf(record[2]);
            this.losses = Integer.valueOf(record[3]);
            this.draws = Integer.valueOf(record[4]);
            this.goals = Integer.valueOf(record[5]);
            this.goalsAllowed = Integer.valueOf(record[6]);
            this.points = Integer.valueOf(record[7]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid data in record: " + Arrays.toString(record), e);
        }
    }

    @Override
    public void printRecordIdentifier(){
        System.out.printf("Team: %s \n", this.team);
    }

    @Override
    public int computeRanking(){
        return Math.abs(this.goals - this.goalsAllowed);
    }
}
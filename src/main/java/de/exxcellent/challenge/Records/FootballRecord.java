package de.exxcellent.challenge;

import java.util.Arrays;


/*
* FootballRecord class represents a football team's statistics and implements the Record interface
* Fields to store team name, number of games, wins, losses, draws, goals scored, goals allowed, and points
*/
public class FootballRecord implements Record{
    String team;
    int games;
    int wins;
    int losses;
    int draws;
    int goals;
    int goalsAllowed;
    int points;

    /*
    * Constructor takes a String array (CSV line split) and parses the values into respective fields
    * Throws IllegalArgumentException if data is missing or not in expected format
    */
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

    // Prints the team's name as the identifier for this record
    @Override
    public void printRecordIdentifier(){
        System.out.printf("Team: %s \n", this.team);
    }

    // Computes the ranking value as the absolute goal difference (goals scored - goals allowed)
    @Override
    public int computeRankingValue(){
        return Math.abs(this.goals - this.goalsAllowed);
    }
}
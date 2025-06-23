package de.exxcellent.challenge;

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
        this.team = record[0];
        this.games = Integer.valueOf(record[1]);
        this.wins = Integer.valueOf(record[2]);
        this.losses = Integer.valueOf(record[3]);
        this.draws = Integer.valueOf(record[4]);
        this.goals = Integer.valueOf(record[5]);
        this.goalsAllowed = Integer.valueOf(record[6]);
        this.points = Integer.valueOf(record[7]);
    }

    @Override
    public void printRecord(){
        System.out.printf("Team: %s \n", this.team);
    }

    @Override
    public int computeRanking(){
        return Math.abs(this.goals - this.goalsAllowed);
    }
}
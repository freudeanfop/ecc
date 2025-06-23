package de.exxcellent.challenge;

public class FootballRecord implements Record{
    String team;
    int games;
    int wins;
    int losses;
    int draws;
    int goals;
    int goalsAllowed;
    int points;

    public FootballRecord(String team, int games, int wins, int losses, int draws,
                          int goals, int goalsAllowed, int points) {
        this.team = team;
        this.games = games;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
        this.points = points;
    }

    @Override
    public void printRecord(){

    }

    @Override
    public int computeRanking(){

    }
}
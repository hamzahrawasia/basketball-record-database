/*
 Hamzah Rawasia
 Version 1.0
 This program creates the Object class for an Nba Record
 */
package edu.hdsb.gwss.hamzah.ics4u.u7;

/**
 *
 * @author Rawasia
 */
public class NbaRecord {

    // VARIABLES
    private String teamName;
    private String coachName;
    private int numPlayers;
    private int teamWins;
    private double pointsPerGame;
    private boolean madePlayoffs;
    private char conference;
    private int year;

    public static final int CLASS_SIZE = 93;
    public static final int TEAM_NAME_SIZE = 20;
    public static final int COACH_NAME_SIZE = 15;
    
    private long dbid;

    // CONSTRUCTORS
    public NbaRecord() {
    }
    public NbaRecord(long id){
        this.dbid = id;
    }
    public NbaRecord (String teamName, int year){
        this.setTeamName(teamName);
        this.year = year;
    }


    // SETTERS AND GETTERS
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        StringBuilder temp = new StringBuilder();

        if (teamName != null) {
            temp.append(teamName.trim());
        } else {
            temp.append("TBD");
        }

        // truncates or pads the string
        temp.setLength(TEAM_NAME_SIZE);
        this.teamName = temp.toString();
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        StringBuilder temp = new StringBuilder();

        if (coachName != null) {
            temp.append(coachName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(COACH_NAME_SIZE);
        this.coachName = temp.toString();
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public void setTeamWins(int teamWins) {
        this.teamWins = teamWins;
    }

    public double getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    public boolean isMadePlayoffs() {
        return madePlayoffs;
    }

    public void setMadePlayoffs(boolean madePlayoffs) {
        this.madePlayoffs = madePlayoffs;
    }

    public char getConference() {
        return conference;
    }

    public void setConference(char conference) {
        this.conference = conference;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getDbid() {
        return dbid;
    }

    protected void setDbid(long dbid) {
        this.dbid = dbid;
    }


    @Override
    public String toString() {
        return "NbaRecord{" + "teamName=" + teamName + ", coachName=" + coachName + ", numPlayers=" + numPlayers + ", teamWins=" + teamWins + ", pointsPerGame=" + pointsPerGame + ", madePlayoffs=" + madePlayoffs + ", conference=" + conference + ", year=" + year + ", dbid=" + dbid + '}';
    }
    

}

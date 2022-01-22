/*
 Hamzah Rawasia
 Version 1.0
 This program tests the Database created for the NbaRecord class
 */
package edu.hdsb.gwss.hamzah.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Rawasia
 */
public class DBTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        // CREATE NBA RECORDS
        NbaRecord n = new NbaRecord("Toronto Raptors", 2020);
        n.setCoachName("Nick Nurse");
        n.setNumPlayers(15);
        n.setTeamWins(50);
        n.setPointsPerGame(111.1);
        n.setMadePlayoffs(true);
        n.setConference('E');

        NbaRecord n2 = new NbaRecord("Toronto Raptors2", 2021);
        n2.setCoachName("Nick Nurse");
        n2.setNumPlayers(15);
        n2.setTeamWins(50);
        n2.setPointsPerGame(111.1);
        n2.setMadePlayoffs(true);
        n2.setConference('E');

        NbaRecord n3 = new NbaRecord("Boston Celtics", 2020);
        n3.setCoachName("Brad Stevens");
        n3.setYear(2020);
        n3.setNumPlayers(14);
        n3.setTeamWins(46);
        n3.setPointsPerGame(103.3);
        n3.setMadePlayoffs(true);
        n3.setConference('E');

        NbaRecord n4 = new NbaRecord("Los Angeles Lakers", 2020);
        n4.setCoachName("Frank Vogel");
        n4.setNumPlayers(14);
        n4.setTeamWins(48);
        n4.setPointsPerGame(113.7);
        n4.setMadePlayoffs(true);
        n4.setConference('W');

        NbaRecordDB.open(); // OPEN DATABASE

        // Try to get record when file is empty
        System.out.println(NbaRecordDB.get(1));
        assert (NbaRecordDB.get(1) == null);

        // SAVE RECORDS TO DATABASE, AND CHECK IF SAVED CORRECTLY USING PRIMARY KEY
        NbaRecordDB.save(n);
        System.out.println(NbaRecordDB.get("Toronto Raptors", 2020));
        assert (NbaRecordDB.get(1).toString().equals(n.toString()));

        NbaRecordDB.save(n2);
        System.out.println(NbaRecordDB.get(2));
        assert (NbaRecordDB.get(2).toString().equals(n2.toString()));

        NbaRecordDB.save(n3);
        System.out.println(NbaRecordDB.get("Boston Celtics", 2020));
        assert (NbaRecordDB.get(3).toString().equals(n3.toString()));

        // update value of record that already exists
        n2.setCoachName("Nick");
        NbaRecordDB.save(n2);
        System.out.println(NbaRecordDB.get(2));
        assert (NbaRecordDB.get(2).toString().equals(n2.toString()));
        assert (NbaRecordDB.get(2).getCoachName().equals(n2.getCoachName()));

        // Try saving value after closing database
        NbaRecordDB.close();
        assert (NbaRecordDB.save(n) == null);

        // OPEN DATABASE AGAIN, AND SAVE RECORD
        NbaRecordDB.open();
        NbaRecordDB.save(n4);
        System.out.println(NbaRecordDB.get("Los Angeles Lakers", 2020));
        assert (NbaRecordDB.get(4).toString().equals(n4.toString()));

        // CHECK IF ID'S WERE SAVED CORRECTLY NOW USING SECONDARY KEY
        assert (NbaRecordDB.get("Toronto Raptors", 2020).toString().equals(n.toString()));
        assert (NbaRecordDB.get("Toronto Raptors2", 2021).toString().equals(n2.toString()));
        assert (NbaRecordDB.get("Boston Celtics", 2020).toString().equals(n3.toString()));
        assert (NbaRecordDB.get("Los Angeles Lakers", 2020).toString().equals(n4.toString()));

    }

}

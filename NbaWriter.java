/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.hamzah.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Rawasia
 */
public class NbaWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        System.out.println("Creating 4 NBA Records");
//        NbaRecord n1 = new NbaRecord("Toronto Raptors", "Nick Nurse", 15, 50, 105.2, true, 'E');
//        NbaRecord n2 = new NbaRecord("Los Angeles Lakers", "Frank Vogel", 14, 49, 107.7, true, 'W');
//        NbaRecord n3 = new NbaRecord("Boston Celtics", "Brad Stevens", 15, 46, 102.4, true, 'E');
//        NbaRecord n4 = new NbaRecord("San Antonio Spurs", "Gregg Popovich", 14, 38, 101.4, false, 'W');

        NbaRecord n1 = new NbaRecord("Toronto Raptors",2020);
        NbaRecord n2 = new NbaRecord("Los Angeles Lakers",2020);
        NbaRecord n3 = new NbaRecord("Boston Celtics",2020);
        NbaRecord n4 = new NbaRecord("San Antonio Spurs", 2020);

        RandomAccessFile raf = new RandomAccessFile("nba_info.dat", "rw");
        raf.setLength(0);

        // WRITE TEAM 1
        raf.writeChars(n1.getTeamName());
        n1.setCoachName("Nick Nurse");
        raf.writeChars(n1.getCoachName());
        n1.setNumPlayers(15);
        raf.writeInt(n1.getNumPlayers());
        System.out.println("num: "+n1.getNumPlayers());
        raf.writeInt(n1.getTeamWins());
        raf.writeDouble(n1.getPointsPerGame());
        raf.writeBoolean(n1.isMadePlayoffs());
        raf.writeChar(n1.getConference());

        System.out.println("LENGTH: " + raf.length());

        // WRITE TEAM 2
        raf.writeChars(n2.getTeamName());
        n2.setCoachName("Frank Vogel");
        raf.writeChars(n2.getCoachName());
        

        raf.writeInt(n2.getNumPlayers());
        raf.writeInt(n2.getTeamWins());
        raf.writeDouble(n2.getPointsPerGame());
        raf.writeBoolean(n2.isMadePlayoffs());
        raf.writeChar(n2.getConference());

        System.out.println("LENGTH: " + raf.length());

        // WRITE TEAM 3
        raf.writeChars(n3.getTeamName());
        n3.setCoachName("Brad Stevens");
        raf.writeChars(n3.getCoachName());
        raf.writeInt(n3.getNumPlayers());
        raf.writeInt(n3.getTeamWins());
        raf.writeDouble(n3.getPointsPerGame());
        raf.writeBoolean(n3.isMadePlayoffs());
        raf.writeChar(n3.getConference());

        System.out.println("LENGTH: " + raf.length());

        // WRITE TEAM 4
        raf.writeChars(n4.getTeamName());
        n4.setCoachName("Gregg Popovich");
        raf.writeChars(n4.getCoachName());
        raf.writeInt(n4.getNumPlayers());
        raf.writeInt(n4.getTeamWins());
        raf.writeDouble(n4.getPointsPerGame());
        raf.writeBoolean(n4.isMadePlayoffs());
        raf.writeChar(n4.getConference());

        System.out.println("LENGTH: " + raf.length());

    }

}

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
public class NbaReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // RANDOM ACCESS FILE
        RandomAccessFile raf = new RandomAccessFile("nba_info.dat", "rw");

        // EMPTY CONTAINER
        NbaRecord c = new NbaRecord();
        
        // READ - TEAM NAME
        char str[] = new char[NbaRecord.TEAM_NAME_SIZE];
        for( int i = 0; i < NbaRecord.TEAM_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setTeamName( new String( str ) );
        
        // READ - COACH NAME
        str = new char[NbaRecord.COACH_NAME_SIZE];
        for( int i = 0; i < NbaRecord.COACH_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setCoachName( new String( str ) );
        
        // READ NUMPLAYERS
        c.setNumPlayers(raf.readInt());
       // System.out.println(raf.readInt());
        
        // READ TEAM WINS
        c.setTeamWins(raf.readInt());
        
        // READ POINTS PER GAME
        c.setPointsPerGame(raf.readDouble());
        
        // READ MADE PLAYOFFS
        c.setMadePlayoffs(raf.readBoolean());
        
        // READ CONFERENCE
        c.setConference(raf.readChar());
       
        System.out.println(c.toString());
        
        c = new NbaRecord();
        
        // READ - TEAM NAME
         str = new char[NbaRecord.TEAM_NAME_SIZE];
        for( int i = 0; i < NbaRecord.TEAM_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setTeamName( new String( str ) );
        
        // READ - COACH NAME
        str = new char[NbaRecord.COACH_NAME_SIZE];
        for( int i = 0; i < NbaRecord.COACH_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setCoachName( new String( str ) );
        
        // READ NUMPLAYERS
        c.setNumPlayers(raf.readInt());
       // System.out.println(raf.readInt());
        
        // READ TEAM WINS
        c.setTeamWins(raf.readInt());
        
        // READ POINTS PER GAME
        c.setPointsPerGame(raf.readDouble());
        
        // READ MADE PLAYOFFS
        c.setMadePlayoffs(raf.readBoolean());
        
        // READ CONFERENCE
        c.setConference(raf.readChar());
       
        System.out.println(c.toString());
        
        c = new NbaRecord();
        
        // READ - TEAM NAME
        str = new char[NbaRecord.TEAM_NAME_SIZE];
        for( int i = 0; i < NbaRecord.TEAM_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setTeamName( new String( str ) );
        
        // READ - COACH NAME
        str = new char[NbaRecord.COACH_NAME_SIZE];
        for( int i = 0; i < NbaRecord.COACH_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setCoachName( new String( str ) );
        
        // READ NUMPLAYERS
        c.setNumPlayers(raf.readInt());
       // System.out.println(raf.readInt());
        
        // READ TEAM WINS
        c.setTeamWins(raf.readInt());
        
        // READ POINTS PER GAME
        c.setPointsPerGame(raf.readDouble());
        
        // READ MADE PLAYOFFS
        c.setMadePlayoffs(raf.readBoolean());
        
        // READ CONFERENCE
        c.setConference(raf.readChar());
       
        System.out.println(c.toString());
        
        c = new NbaRecord();
        
        // READ - TEAM NAME
        str = new char[NbaRecord.TEAM_NAME_SIZE];
        for( int i = 0; i < NbaRecord.TEAM_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setTeamName( new String( str ) );
        
        // READ - COACH NAME
        str = new char[NbaRecord.COACH_NAME_SIZE];
        for( int i = 0; i < NbaRecord.COACH_NAME_SIZE; i++ ) {
            str[i] = raf.readChar();
        }
        c.setCoachName( new String( str ) );
        
        // READ NUMPLAYERS
        c.setNumPlayers(raf.readInt());
       // System.out.println(raf.readInt());
        
        // READ TEAM WINS
        c.setTeamWins(raf.readInt());
        
        // READ POINTS PER GAME
        c.setPointsPerGame(raf.readDouble());
        
        // READ MADE PLAYOFFS
        c.setMadePlayoffs(raf.readBoolean());
        
        // READ CONFERENCE
        c.setConference(raf.readChar());
       
        System.out.println(c.toString());
 
    }

}

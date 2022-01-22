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
public class NbaClassUpdater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        RandomAccessFile raf = new RandomAccessFile( "nba_info.dat", "rw" );

        // READ Record #2
        int recordID = 2;
        raf.seek( ( recordID - 1 ) * NbaRecord.CLASS_SIZE );

        // EMPTY CONTAINER
        NbaRecord c = new NbaRecord(recordID);
        
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
        
        System.out.println("BEFORE:");
        System.out.println(c.toString());
        
        //UPDATE
        c.setPointsPerGame(110.3);
        c.setNumPlayers(13);
        
        // WRITE RECORD
        raf.seek( ( recordID - 1 ) * NbaRecord.CLASS_SIZE );
        
        // RE-WRITE CLASS
        System.out.println("AFTER:");
        raf.writeChars(c.getTeamName());
        raf.writeChars(c.getCoachName());
        raf.writeInt(c.getNumPlayers());
        raf.writeInt(c.getTeamWins());
        raf.writeDouble(c.getPointsPerGame());
        raf.writeBoolean(c.isMadePlayoffs());
        raf.writeChar(c.getConference());
        System.out.println(c.toString());

    }
    
}

/*
 Hamzah Rawasia
 Version 1.0
 This program creates the Database for the NbaRecord class, and can read, write, update, and save records
 */
package edu.hdsb.gwss.hamzah.ics4u.u7;


import java.io.RandomAccessFile;

/**
 *
 * @author Rawasia
 */
public class NbaRecordDB {

    private static RandomAccessFile raf;
    private static boolean open;

    public static void open() {
        try {
            // open file
            raf = new RandomAccessFile("nba_info.dat", "rw");
            open = true;
            System.out.println("Database opened");
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error- exception found: " + e);
        }
    }

    public static void close() {
        try {
            // close file
            raf.close();
            open = false;
            System.out.println("Database closed");
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error- exception found: " + e);
        }
    }

    public static NbaRecord save(NbaRecord n) {

        if (open) {
            try {
                // invalid ID - set ID to write
                if (n.getDbid() < 1) {
                    n.setDbid((raf.length() / NbaRecord.CLASS_SIZE) + 1);
                    raf.seek(raf.length());
                } else { // seek depending on existing ID to update
                    raf.seek((n.getDbid() - 1) * NbaRecord.CLASS_SIZE);
                }
                //write to file
                raf.writeChars(n.getTeamName());
                raf.writeChars(n.getCoachName());
                raf.writeInt(n.getNumPlayers());
                raf.writeInt(n.getTeamWins());
                raf.writeInt(n.getYear());
                raf.writeDouble(n.getPointsPerGame());
                raf.writeBoolean(n.isMadePlayoffs());
                raf.writeChar(n.getConference());

                return n;
            } catch (Exception e) {
                System.out.println("Error- exception found: " + e);
            }
        }
        return null;
    }

    public static NbaRecord get(long dbid) {
        try {
            long numRecords = raf.length() / NbaRecord.CLASS_SIZE;

            if (dbid <= numRecords && dbid > 0) { // check if valid ID

                raf.seek((dbid - 1) * NbaRecord.CLASS_SIZE);

                // EMPTY CONTAINER
                NbaRecord c = new NbaRecord(dbid);

                // READ - TEAM NAME
                char str[] = new char[NbaRecord.TEAM_NAME_SIZE];
                for (int i = 0; i < NbaRecord.TEAM_NAME_SIZE; i++) {
                    str[i] = raf.readChar();
                }
                c.setTeamName(new String(str));

                // READ - COACH NAME
                str = new char[NbaRecord.COACH_NAME_SIZE];
                for (int i = 0; i < NbaRecord.COACH_NAME_SIZE; i++) {
                    str[i] = raf.readChar();
                }
                c.setCoachName(new String(str));

                // READ NUMPLAYERS
                c.setNumPlayers(raf.readInt());

                // READ TEAM WINS
                c.setTeamWins(raf.readInt());

                // READ TEAM YEAR
                c.setYear(raf.readInt());

                // READ POINTS PER GAME
                c.setPointsPerGame(raf.readDouble());

                // READ MADE PLAYOFFS
                c.setMadePlayoffs(raf.readBoolean());

                // READ CONFERENCE
                c.setConference(raf.readChar());

                return c;
            }

        } catch (Exception e) {
            System.out.println("Error- exception found: " + e);
        }
        return null;
    }

    public static NbaRecord get(String teamName, int year) {
        NbaRecord n;
        try {
            // Loop through each record until it matches what they are searching for
            for (long i = 1; i < (raf.length() / NbaRecord.CLASS_SIZE) + 1; i++) {
                n = get(i); // call previous get() method by passing ID
                if (n.getTeamName().trim().equals(teamName) && n.getYear() == year) { // check if equal
                    return n;
                }
            }
        } catch (Exception e) {
            System.out.println("Error- exception found: " + e);
        }
        return null;
    }
}

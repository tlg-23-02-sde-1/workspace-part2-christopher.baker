package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIDMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    /*Updates the board(racerMap) by making a DuckRacer win.
     *This could mean fetching an existing DuckRacer from racerMap,
     * and then make it win.
     */
    public void processWin(int id, Reward reward){
        if(racerMap.containsKey(id)){
            DuckRacer racer = racerMap.get(id);
            racer.win(reward);
        }else{
            DuckRacer racer = new DuckRacer(id, studentIdMap.get(id));  //create new
            racerMap.put(id, racer);                                    // put in map
            racer.win(reward);
        }
    }

    //TODO: render the data "pretty," i.e., like we see in class

    public void renderRacerMap(){
        Collection<DuckRacer> allRacers = racerMap.values(); //return Collection<V>
        for (DuckRacer racer : allRacers){
            System.out.println(racer);      //toString() automatically called
        }
    }

    //for testing only- will probably be removed
    void dumpStudentIdMap(){
        System.out.println(studentIdMap);
    }

    /*
     *Populates studentIdMap from file conf/student-ids.cvs
     */

    private Map<Integer,String> loadStudentIDMap(){
        Map<Integer,String> idMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            //for each line in lines, we want to split the string into "tokens"
            //then convert to Integer,String, so we can put this in the map
            for(String line : lines){
                String[] tokens = line.split(",");//returns "1" and a "Caleb" ["1", "Caleb"]
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                idMap.put(id, name);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }

}
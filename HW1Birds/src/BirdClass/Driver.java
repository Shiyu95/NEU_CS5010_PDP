package BirdClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import BirdClass.Conservatory;

/*
 * This drive class create a conservatory that have max limit 20 aviaries for birds to live
 *
 */
public class Driver {
    public Map<Integer, Aviary> conservatory;
    private String printSFA ="";
    private String printIndex = "";
    public String printSignForAviary(Map<Integer, Aviary> conservatory) {
        for (Map.Entry<Integer, Aviary> each : conservatory.entrySet()) {
            printSFA = "Aviary Location: " + each.getKey() + " -> " + each.getValue().getDescription();

            for(Map.Entry<Integer, Bird> bird : each.getValue().getAviaryMap().entrySet()) {
                this.printSFA = this.printSFA + bird.getValue().getBirdType();
            }
        }
        return this.printSFA;
    }

    /**
     * use two for-loop to get the all bird in the conservatory.
     */
    public String printIndex(Map<Integer, Aviary> conservatory) {
        Map<String, List<Integer>> totalBird = new HashMap<>();
        for(Map.Entry<Integer, Aviary> each : conservatory.entrySet()) {
            for(Map.Entry<Integer, Bird> bird : each.getValue().getAviaryMap().entrySet()) {
                if(!totalBird.containsKey(bird.getValue().getBirdType())) {
                    totalBird.put(bird.getValue().getBirdType().toString(), new ArrayList<Integer>(Arrays.asList(each.getValue().getAviaryLocation())));
                }else if(totalBird.containsKey(bird.getValue().getBirdType()) &&
                        !totalBird.get(bird.getValue().getBirdType()).contains(each.getValue().getAviaryLocation())) {
                    totalBird.get(bird.getValue().getBirdType()).add(each.getValue().getAviaryLocation());
                }
            }
        }

        //create a tree map for rearrange the conservatory
        TreeMap<String, List<Integer>> reOrderConservatoryIndex = new TreeMap<>(totalBird);

        printIndex += "Conservatory Index:";
        for(Map.Entry<String, List<Integer>> each : reOrderConservatoryIndex.entrySet()) {
            printIndex += "There's a " + each.getKey() + " in aviary " + each.getValue();
        }

        return printIndex;
    }



}


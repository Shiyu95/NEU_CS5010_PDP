package BirdClass;

import java.util.Map;
import java.util.HashMap;


//Conservatory class for bird in different aviary
public class Conservatory {

    //variable
    public Map<Integer, Aviary> conservatory;
    private Driver guest;
    private int aviaryLocation;
    private boolean isSaved;
    private int birdlocation;


    /**
     * Conservatory constructor.
     * Setting a new guest to look up for bird.
     * Setting aviary location to 1, and increases gradually until 20.
     * Setting whether bird is rescued or not.
     */
    public Conservatory() {
        this.conservatory = new HashMap<Integer, Aviary>();
        this.guest = new Driver();
        this.aviaryLocation = 1;
        this.isSaved = false;
        this.birdlocation =1;
    }


    /**
     * Getting the conservatory.
     * @return conservatory map.
     */
    public Map<Integer, Aviary> getConservatory() {
        return this.conservatory;
    }



    /**
     * Put new birds into conservatory class.
     *
     * @param bird target bird.
     */
    public void putBird(Bird bird ){
        //Check the bird is extinct or not
        isSaved = false;
        if (bird.getIsExtinct()) {
            throw new IllegalStateException("Extinct bird can't be put in conservatory.");
        }
        //There is a maximum of 20 aviaries in the conservatory. Limit conservatory size
       if (this.conservatory.size() <= 20) {
            //put the bird to a aviary
            for (Map.Entry<Integer, Aviary> each : this.conservatory.entrySet()) {
                //Compare the bird's classification with the aviary's description
                //for flightlessBird
                if (each.getValue().getDescription() == "flightlessBird"
                        && bird.getClassification() == "flightlessBird"
                        && each.getValue().getAviaryMap().size() < 5) {
                    each.getValue().getAviaryMap().put(each.getValue().getBirdLocation(),bird);
                    each.getValue().setFoodList(bird.getFoodItem(),1);
                    isSaved = true;
                    break;
                //for preBird
                } else if (each.getValue().getDescription() == "preyBird"
                        && bird.getClassification() == "preyBird"
                        && each.getValue().getAviaryMap().size() < 5) {
                    each.getValue().getAviaryMap().put(each.getValue().getBirdLocation(), bird);
                    each.getValue().setFoodList(bird.getFoodItem(),1);
                    isSaved =true;
                    break;
                //for waterfowl
                } else if (each.getValue().getDescription() == "waterFowl"
                        && bird.getClassification() == "waterFowl"
                        && each.getValue().getAviaryMap().size() < 5) {
                    each.getValue().getAviaryMap().put(each.getValue().getBirdLocation(), bird);
                    each.getValue().setFoodList(bird.getFoodItem(),1);
                    isSaved =true;
                    break;
                //others
                } else if (each.getValue().getDescription() == "Mixed"
                        && bird.getClassification() != "flightlessBird"
                        && bird.getClassification() != "preyBird"
                        && bird.getClassification() != "waterFowl"
                        && each.getValue().getAviaryMap().size() < 5) {
                    each.getValue().getAviaryMap().put(each.getValue().getBirdLocation(), bird);
                    each.getValue().setFoodList(bird.getFoodItem(),1);
                    isSaved =true;
                    break;
                }
            }

        }
        addNew(bird);
        if (!isSaved())
            throw new IllegalArgumentException("The conservatory has already full");

    }

    private boolean isSaved() {
        return isSaved;
    }


    // if the bird hasn't been rescued and conservatory is not full
    // add to a new aviary.
    public void addNew(Bird bird){
        while (!isSaved() && this.conservatory.size() <20) {
            isSaved = true;
            if (bird.getClassification() == "FlightlessBirds") {
                Aviary nAviary = new Aviary(this.aviaryLocation,
                        "FlightlessBirds", false);
                nAviary.setFoodList(bird.getFoodItem(), 1);
                nAviary.setAviary(nAviary.getBirdLocation(), bird);
                conservatory.put(this.aviaryLocation++, nAviary);

            } else if (bird.getClassification() == "PreyBirds") {
                Aviary newAviary = new Aviary(this.aviaryLocation,
                        "PreyBirds", false);
                newAviary.setFoodList(bird.getFoodItem(), 1);
                newAviary.setAviary(newAviary.getBirdLocation(), bird);
                conservatory.put(this.aviaryLocation++, newAviary);

            } else if (bird.getClassification() == "Waterfowl") {

              Aviary newAviary = new Aviary(this.aviaryLocation,
                        "Waterfowl", false);
                newAviary.setFoodList(bird.getFoodItem(), 1);
                newAviary.setAviary(newAviary.getBirdLocation(), bird);
                conservatory.put(this.aviaryLocation++, newAviary);

            } else {

                Aviary newAviary = new Aviary(this.aviaryLocation,
                        "Mixed", true);
                newAviary.setFoodList(bird.getFoodItem(), 1);
                newAviary.setAviary(newAviary.getBirdLocation(), bird);
                conservatory.put(this.aviaryLocation++, newAviary);

            }
        }
    }


   /**
    * To check the bird in which aviary
    * and print a map and sign for aviaries and bird location.
    */
    public String birdMap() {
        return guest.printSignForAviary(this.conservatory);
    }

    /**
     * Print an index that lists all birds in the conservatory in alphabetical order and their location
     */
    public String printConservatoryMap() {
        return guest.printIndex(this.conservatory);
    }


}


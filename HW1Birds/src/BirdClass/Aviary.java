package BirdClass;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Aviary class for store different type bird and their own Location.
 */
public class Aviary {
    //variable
    private Map<Integer, Bird> birds;
    private Map<List<FoodType>, Integer> food;
    private int aviaryLocation;
    private int birdLocation;
    private String description;
    private Bird bird;
    private boolean isMixed;

    /**
     * Aviary constructor.
     *
     * @param aviaryLocation  location.
     * @param description the aviary's description. (Mixed, waterFowl, flightlessBird, preyBird)
     * @param isMixed whether the aviary is mixed.
     */
    public Aviary(int aviaryLocation, String description, boolean isMixed) {
        this.birds = new HashMap<Integer, Bird>();
        this.food = new HashMap<List<FoodType>, Integer>();
        this.aviaryLocation = aviaryLocation;
        this.birdLocation = 1;
        this.description = description;
        this.isMixed = isMixed;

    }

    /**
     * Set up a aviary.
     * @param birdLocation location for bird in each aviary.
     * @param target target bird.
     */
    public void setAviary(int birdLocation, Bird target) {
        this.birds.put(birdLocation, target);
    }

    /**
     * Set up food type and quantity.
     * @param foodList Birds' food.
     * @param foodQuantity Quantity for each bird.
     */
    public void setFoodList(List<FoodType> foodList, int foodQuantity) {
        if(!this.food.containsKey(foodList)) {
            this.food.put(foodList, foodQuantity);
        }else {
            this.food.put(foodList, this.food.get(foodList) + foodQuantity);
        }
    }


    /**
     * Get the description of the aviary.
     * @return the description of this bird.
     */
    public String getDescription() {

        return this.description;
    }





    /**
     * Get bird location in each aviary.
     */
    public int getBirdLocation() {
        return this.birdLocation++;
    }

    /**
     * Get aviary location in conservatory.
     */
    public int getAviaryLocation() {
        return this.aviaryLocation;
    }


    public boolean getIsMix() {

        return this.isMixed;
    }


    /**
     * Get aviary's food collection.
     */
    public Map<List<FoodType>, Integer> getFood() {
        return this.food;
    }

    /**
     * Get bird map.
     */
    public Map<Integer, Bird> getAviaryMap() {
        return this.birds;
    }





}

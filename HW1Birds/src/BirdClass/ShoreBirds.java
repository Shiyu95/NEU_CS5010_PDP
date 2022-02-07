package BirdClass;

import java.util.EnumSet;
import java.util.List;

/**
 *The class shoreBirds for shoreBird, which extends the abstract "Bird" class.
 */
public class ShoreBirds extends WaterBird {
    private EnumSet<WaterType> waterTypes = EnumSet.of(WaterType.WETLANDS, WaterType.FRESHWATER, WaterType.SALTWATER, WaterType.SHORELANDS,WaterType.OCEAN);


    /**
     * Constructs a bird object and initializes it to the given isExtinct, numOfWing, food, type, and
     * classification
     *
     * @param isExtinct      this bird extinct or not.
     * @param numOfWings     the number of wings of this bird has.
     * @param foodList       the food of this bird like to eat. Eg: berries, seeds, fruit, insects...etc
     *                       // * @param type    the type of this bird. Eg: duck, horned puffin...etc
     *                       // * @param birdType
     * @param classification the classification of this bird.   Eg: prey bird, flightless bird...etc
     */
    public ShoreBirds(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType, String classification, List<WaterType> bodyOfWater) {
        super(isExtinct, numOfWings, foodList, birdType, classification, bodyOfWater);
    }

}

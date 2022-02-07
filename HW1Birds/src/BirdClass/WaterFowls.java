package BirdClass;

import java.util.EnumSet;
import java.util.List;

/**
 *The class waterFowls for waterFowls, which extends the abstract "Bird" class.
 */
public class WaterFowls extends WaterBird {
    private EnumSet<BirdType> WaterFowlTypes = EnumSet.of(BirdType.GOOSE,
            BirdType.DUCK, BirdType.SWAN );

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
    public WaterFowls(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType, String classification,  List<WaterType>  bodyOfWater) {
        super(isExtinct, numOfWings, foodList, birdType, classification, bodyOfWater);
    }

//    @Override
//    public String toString(){
//
//        return "Type: " + this.getBirdType() + ", Characteristics: " + this.getClassification() +
//                ", Is Extinct: " + this.getIsExtinct() + ", Wing numbers: " + this.getNumOfWings() +
//                ", Food preference: " + this.getFoodItem() + ", water source: " +this.getBodyOfWater();
//    }




}

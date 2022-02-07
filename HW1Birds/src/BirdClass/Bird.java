package BirdClass;
import java.util.EnumSet;
import java.util.List;

//Abstract class bird
public abstract class Bird {
    private boolean isExtinct;
    private int numOfWings;
    private String classification;
    private List<FoodType> foodList;
    EnumSet<FoodType> foodListEnumSet = EnumSet.allOf(FoodType.class);
    private BirdType birdType;
    EnumSet<BirdType> birdTypeEnumSet = EnumSet.allOf(BirdType.class);


    /**
     * Constructs a bird object and initializes it to the given isExtinct, numOfWing, food, type, and
     * classification
     *  @param isExtinct      this bird extinct or not.
     * @param numOfWings     the number of wings of this bird has.
     * @param foodList       the food of this bird like to eat. Eg: berries, seeds, fruit, insects...etc
     * @param birdType
     * @param classification the classification of this bird.   Eg: prey bird, flightless bird...etc
     */
    public Bird(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType , String classification) {
        this.isExtinct = isExtinct;
        this.numOfWings = numOfWings;
        this.classification = classification;
        this.foodList = foodList;
        this.birdType = birdType;

        //some illegalArgumentException for special case
        if (numOfWings < 0) {
            throw new IllegalArgumentException("The number of wing can't less than 0");
        }
        if (foodList.size() < 2 || foodList.size() > 4) {
            throw new IllegalArgumentException("2-4 items birds prefer to eat from the food list");
        }
    }


    /**
     * Get the information about whether the bird extinct or not
     *
     * @return the bird extinct or not
     */
    public boolean getIsExtinct() {
        return this.isExtinct;
    }


    /**
     * Get the number of wings the bird has.
     *
     * @return the number of wings the bird has
     */

    public int getNumOfWings() {
        return this.numOfWings;
    }

    /**
     * Get the food of this bird like to eat.
     *
     * @return the food of this bird like to eat.
     */
    public List<FoodType> getFoodItem() {
        return foodList;
    }


    /**
     * Get the type of this bird.
     *
     * @return the type of this bird.
     */
    public BirdType getBirdType(){
        return birdType;
    }


    /**
     * Get the classification of this bird.
     *
     * @return the classification of this bird.
     */
    public String getClassification() {
        return this.classification;
    }



    public String toString(){

        return "Type: " + this.getBirdType() + ", Characteristics: " + this.getClassification() +
                ", Is Extinct: " + this.getIsExtinct() + ", Wing numbers: " + this.getNumOfWings() +
                ", Food preference: " + this.getFoodItem() ;
    }

}

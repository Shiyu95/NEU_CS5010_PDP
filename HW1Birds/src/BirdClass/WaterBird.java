package BirdClass;

import java.util.EnumSet;
import java.util.List;

public class WaterBird extends Bird {

    private List<WaterType> bodyOfWater;
    //private
    public WaterBird(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType,
                     String classification, List<WaterType> bodyOfWater){
        super(isExtinct,numOfWings,foodList,birdType,classification);
        this.bodyOfWater = bodyOfWater;

    }

    public List<WaterType>  getBodyOfWater() {
        return bodyOfWater ;
    }

    @Override
    public String toString(){
        return "Type: " + this.getBirdType() + ", Characteristics: " + this.getClassification() +
                ", Is Extinct: " + this.getIsExtinct() + ", Wing numbers: " + this.getNumOfWings() +
                ", Food preference: " + this.getFoodItem() + ", water source: " +this.getBodyOfWater();
    }
}

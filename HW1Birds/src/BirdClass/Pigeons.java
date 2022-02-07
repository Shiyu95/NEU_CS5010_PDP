package BirdClass;

import java.util.EnumSet;
import java.util.List;

/**
 *The class pigeons for pigeons birds, which extends the abstract "Bird" class.
 */
public class Pigeons extends Bird{

    public Pigeons(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType, String classification){
        super(isExtinct,numOfWings,foodList,birdType,classification);


    }

}

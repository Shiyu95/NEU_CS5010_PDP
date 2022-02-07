package BirdClass;

import java.util.EnumSet;
import java.util.List;

/**
 *The class owls for owls, which extends the abstract "Bird" class.
 */
public class Owls extends Bird{

    public Owls(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType, String classification){
        super(isExtinct,numOfWings,foodList, birdType,classification);


    }

}

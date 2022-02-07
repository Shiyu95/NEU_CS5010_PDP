package BirdClass;

import java.util.EnumSet;
import java.util.List;

/**
 *The class preyBirds for Prey birds, which extends the abstract "Bird" class.
 */
public class PreyBirds extends Bird {
    private EnumSet<BirdType> PreyBirdType = EnumSet.of(BirdType.HAWK,BirdType.EAGLE, BirdType.OSPREY);

    public PreyBirds(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType, String classification)
    {
        super(isExtinct,numOfWings,foodList,birdType,classification);


    }






}



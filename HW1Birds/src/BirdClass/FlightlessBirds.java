package BirdClass;

import java.util.EnumSet;
import java.util.List;

/**
 *The class flightlessBirds for flightless birds, which extends the abstract "Bird" class.
 */
public class FlightlessBirds extends Bird {

    private EnumSet<BirdType> flightlessBirdType = EnumSet.of(BirdType.EMUS,BirdType.KIWIS, BirdType.MOAS);

    public FlightlessBirds(boolean isExtinct, int numOfWings, List<FoodType> foodList, BirdType birdType, String classification){
        super(isExtinct,numOfWings,foodList,birdType,classification);



    }


}

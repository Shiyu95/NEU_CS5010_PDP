package Test;



import BirdClass.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;


import static org.junit.Assert.assertEquals;
public class ShoreBirdTest {

    private  ShoreBirds shoreBird;
    private FoodType[] foodList;
    private WaterType[] waterList;


    @Before
    public void setShoreBird() {
        foodList = new FoodType[]{FoodType.OTHER_BIRDS, FoodType.FISH};
        waterList = new WaterType[]{WaterType.WETLANDS, WaterType.FRESHWATER, WaterType.SALTWATER, WaterType.SHORELANDS,WaterType.OCEAN};
        shoreBird = new ShoreBirds(false,2,Arrays.asList(foodList) , null, "waterFowl",Arrays.asList(waterList));

    }


    @Test
    public void testConstructor() {
        shoreBird = new ShoreBirds(false,2,Arrays.asList(foodList),  BirdType.GOOSE,"waterFowl",Arrays.asList(waterList));
        assertEquals("Type: "+ this.shoreBird.getBirdType() +  ", Characteristics: " +this.shoreBird.getClassification()
                + ", Is Extinct: " + this.shoreBird.getIsExtinct() +", Wing numbers: " + this.shoreBird.getNumOfWings()
                + ", Food preference: " + this.shoreBird.getFoodItem()+", water source: " +this.shoreBird.getBodyOfWater(), shoreBird.toString());
    }


    @Test
    public void testGetBirdType() {
        assertEquals(null, shoreBird.getBirdType());
    }


    @Test
    public void testGetFoodItemList() {
        assertEquals("[OTHER_BIRDS, FISH]",
                shoreBird.getFoodItem().toString());
    }

    @Test
    public void testGetClassification() {
        assertEquals("waterFowl",
                shoreBird.getClassification());
    }


    @Test
    public void testGetNumOfWings() {
        assertEquals(2,
                shoreBird.getNumOfWings());
    }

    @Test
    public void testGetIsExtinct() {
        assertEquals(false,
               shoreBird.getIsExtinct());
    }


    @Test
    public void testGetBodyOfWater() {
        assertEquals("[WETLANDS, FRESHWATER, SALTWATER, SHORELANDS, OCEAN]",
                shoreBird.getBodyOfWater().toString());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWings() {
        shoreBird = new ShoreBirds(false,-2,Arrays.asList(foodList), BirdType.DUCK, "waterFowl", Arrays.asList(waterList));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongBirdType() {
        shoreBird = new ShoreBirds(false,-2,Arrays.asList(foodList), BirdType.EMUS,"waterFowl", Arrays.asList(waterList));
    }

}

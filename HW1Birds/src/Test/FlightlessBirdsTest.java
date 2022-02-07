package Test;

import BirdClass.BirdType;
import BirdClass.FoodType;
import BirdClass.FlightlessBirds;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FlightlessBirdsTest {

    private FlightlessBirds flightlessBirds;
    private FoodType[] foodList;

    @Before
    public void setFlightlessBirds() {
        foodList = new FoodType[]{FoodType.BERRIES, FoodType.SEEDS};

        flightlessBirds = new FlightlessBirds(false,0, Arrays.asList(foodList) , BirdType.EMUS, "flightlessBird");

    }


    @Test
    public void testConstructor() {
        flightlessBirds = new FlightlessBirds(false,0,Arrays.asList(foodList),  BirdType.KIWIS,"flightlessBird");
        assertEquals("Type: "+ this.flightlessBirds.getBirdType() +  ", Characteristics: " +this.flightlessBirds.getClassification()
                + ", Is Extinct: " + this.flightlessBirds.getIsExtinct() +", Wing numbers: " + this.flightlessBirds.getNumOfWings()
                + ", Food preference: " + this.flightlessBirds.getFoodItem(), flightlessBirds.toString());
    }


    @Test
    public void testGetBirdType() {
        assertEquals(BirdType.EMUS, flightlessBirds.getBirdType());
    }


    @Test
    public void testGetFoodItemList() {
        assertEquals("[BERRIES, SEEDS]",
                flightlessBirds.getFoodItem().toString());
    }

    @Test
    public void testGetClassification() {
        assertEquals("flightlessBird",
                flightlessBirds.getClassification());
    }


    @Test
    public void testGetNumOfWings() {
        assertEquals(0,
                flightlessBirds.getNumOfWings());
    }

    @Test
    public void testGetIsExtinct() {
        assertEquals(false,
                flightlessBirds.getIsExtinct());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWings() {
        flightlessBirds = new FlightlessBirds(false,-2,Arrays.asList(foodList), BirdType.EMUS, "flightlessBird");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongBirdType() {
        flightlessBirds = new FlightlessBirds(false,-2,Arrays.asList(foodList), BirdType.KIWIS,"flightlessBird");
    }




}

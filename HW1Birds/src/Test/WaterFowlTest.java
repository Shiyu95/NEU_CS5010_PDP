package Test;

import BirdClass.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class WaterFowlTest {
    private WaterFowls waterFowl;
    private FoodType[] foodList;
    private WaterType[] waterList;

    @Before
    public void setWaterFowl() {
       foodList = new FoodType[]{FoodType.OTHER_BIRDS, FoodType.INSECTS};
       waterList = new WaterType[]{WaterType.FRESHWATER, WaterType.SALTWATER};

       waterFowl = new WaterFowls(false,2,Arrays.asList(foodList) , BirdType.DUCK, "waterFowl", Arrays.asList(waterList));

    }


    @Test
    public void testConstructor() {
        waterFowl = new WaterFowls(false,2,Arrays.asList(foodList),  BirdType.GOOSE,"waterFowl",Arrays.asList(waterList));
        assertEquals("Type: "+ this.waterFowl.getBirdType() +  ", Characteristics: " +this.waterFowl.getClassification()
                + ", Is Extinct: " + this.waterFowl.getIsExtinct() +", Wing numbers: " + this.waterFowl.getNumOfWings()
                + ", Food preference: " + this.waterFowl.getFoodItem()+", water source: " +this.waterFowl.getBodyOfWater(),waterFowl.toString());
    }


    @Test
    public void testGetBirdType() {
        assertEquals(BirdType.DUCK, waterFowl.getBirdType());
    }


    @Test
    public void testGetFoodItemList() {
        assertEquals("[OTHER_BIRDS, INSECTS]",
                waterFowl.getFoodItem().toString());
    }

    @Test
    public void testGetClassification() {
        assertEquals("waterFowl",
                waterFowl.getClassification());
    }


    @Test
    public void testGetNumOfWings() {
        assertEquals(2,
                waterFowl.getNumOfWings());
    }

    @Test
    public void testGetIsExtinct() {
        assertEquals(false,
                waterFowl.getIsExtinct());
    }


    @Test
    public void testGetBodyOfWater() {
        assertEquals("[FRESHWATER, SALTWATER]",
                waterFowl.getBodyOfWater().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWings() {
        waterFowl = new WaterFowls(false,-2,Arrays.asList(foodList), BirdType.DUCK, "waterFowl", Arrays.asList(waterList));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongBirdType() {
        waterFowl = new WaterFowls(false,-2,Arrays.asList(foodList), BirdType.EMUS,"waterFowl", Arrays.asList(waterList));
    }





}

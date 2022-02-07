package Test;

import BirdClass.BirdType;
import BirdClass.FoodType;
import BirdClass.Pigeons;
import BirdClass.WaterType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;




public class PigeonsTest {

    private Pigeons pigeon;
    private FoodType[] foodList;

    @Before
    public void setPigeon() {
        foodList = new FoodType[]{FoodType.BERRIES, FoodType.SEEDS};

        pigeon = new Pigeons(false,2, Arrays.asList(foodList) , null, "pigeons");

    }


    @Test
    public void testConstructor() {
        pigeon = new Pigeons(false,2,Arrays.asList(foodList),  null,"pigeons");
        assertEquals("Type: "+ this.pigeon.getBirdType() +  ", Characteristics: " +this.pigeon.getClassification()
                + ", Is Extinct: " + this.pigeon.getIsExtinct() +", Wing numbers: " + this.pigeon.getNumOfWings()
                + ", Food preference: " + this.pigeon.getFoodItem(),pigeon.toString());
    }


    @Test
    public void testGetBirdType() {
        assertEquals(null, pigeon.getBirdType());
    }


    @Test
    public void testGetFoodItemList() {
        assertEquals("[BERRIES, SEEDS]",
                pigeon.getFoodItem().toString());
    }

    @Test
    public void testGetClassification() {
        assertEquals("pigeons",
                pigeon.getClassification());
    }


    @Test
    public void testGetNumOfWings() {
        assertEquals(2,
                pigeon.getNumOfWings());
    }

    @Test
    public void testGetIsExtinct() {
        assertEquals(false,
                pigeon.getIsExtinct());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWings() {
        pigeon = new Pigeons(false,-2,Arrays.asList(foodList), null, "pigeons");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongBirdType() {
        pigeon = new Pigeons(false,-2,Arrays.asList(foodList), null,"pigeons");
    }





}

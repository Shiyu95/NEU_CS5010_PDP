package Test;

import BirdClass.BirdType;
import BirdClass.FoodType;
import BirdClass.Owls;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class OwlsTest {
    private Owls owls;
    private FoodType[] foodList;

    @Before
    public void setOwls() {
        foodList = new FoodType[]{FoodType.BERRIES, FoodType.INSECTS};

        owls = new Owls(false,2, Arrays.asList(foodList) , null, "owl");

    }


    @Test
    public void testConstructor() {
        owls = new Owls(false,2,Arrays.asList(foodList),  null,"owl");
        assertEquals("Type: "+ this.owls.getBirdType() +  ", Characteristics: " +this.owls.getClassification()
                + ", Is Extinct: " + this.owls.getIsExtinct() +", Wing numbers: " + this.owls.getNumOfWings()
                + ", Food preference: " + this.owls.getFoodItem(), owls.toString());
    }


    @Test
    public void testGetBirdType() {
        assertEquals(null, owls.getBirdType());
    }


    @Test
    public void testGetFoodItemList() {
        assertEquals("[BERRIES, INSECTS]",
                owls.getFoodItem().toString());
    }

    @Test
    public void testGetClassification() {
        assertEquals("owl",
                owls.getClassification());
    }


    @Test
    public void testGetNumOfWings() {
        assertEquals(2,
                owls.getNumOfWings());
    }

    @Test
    public void testGetIsExtinct() {
        assertEquals(false,
                owls.getIsExtinct());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWings() {
        owls = new Owls(false,-2,Arrays.asList(foodList), null, "owl");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongBirdType() {
        owls = new Owls(false,-2,Arrays.asList(foodList), null,"owl");
    }




}

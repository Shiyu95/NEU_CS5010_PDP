package Test;

import BirdClass.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;


import static org.junit.Assert.assertEquals;

public class ParrotsTest {
    private Parrots parrot;
    private FoodType[] foodList;

    @Before
    public void setParrots() {
        foodList = new FoodType[]{FoodType.BERRIES, FoodType.INSECTS, FoodType.FRUIT, FoodType.LARVAE};

        parrot = new Parrots(false,2,Arrays.asList(foodList) , BirdType.GRAY_PARROT, "parrot",30,"eat");

    }


    @Test
    public void testConstructor() {
        parrot = new Parrots(false,2,Arrays.asList(foodList),  BirdType.GRAY_PARROT,"parrot",30,"eat");
        assertEquals("Type: "+ this.parrot.getBirdType() +  ", Characteristics: " +this.parrot.getClassification()
                + ", Is Extinct: " + this.parrot.getIsExtinct() +", Wing numbers: " + this.parrot.getNumOfWings()+ ", Food preference: "
                +this.parrot.getFoodItem()  + ", number of vocabulary it can use: "
                +this.parrot.getNumOfVocabulary() +", It have s favorite saying: " + this.parrot.getFavWords(), parrot.toString());
    }


    @Test
    public void testGetBirdType() {
        assertEquals(BirdType.GRAY_PARROT, parrot.getBirdType());
    }


    @Test
    public void testGetFoodItemList() {
        assertEquals("[BERRIES, INSECTS, FRUIT, LARVAE]",
                parrot.getFoodItem().toString());
    }

    @Test
    public void testGetClassification() {
        assertEquals("parrot",
                parrot.getClassification());

    }

    @Test
    public void testGetNumOfWings() {
        assertEquals(2,
                parrot.getNumOfWings());
    }

    @Test
    public void testGetIsExtinct() {
        assertEquals(false,
                parrot.getIsExtinct());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWings() {
        parrot = new Parrots(false,-2,Arrays.asList(foodList), BirdType.GRAY_PARROT, "Parrots",30,"eat");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongBirdType() {
        parrot = new Parrots(false,-2,Arrays.asList(foodList), BirdType.EMUS,"Parrots",30,"eat");
    }






}

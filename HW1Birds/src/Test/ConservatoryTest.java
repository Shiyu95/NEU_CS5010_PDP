package Test;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import java.util.Arrays;
import java.util.List;

import BirdClass.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



public class ConservatoryTest {
    private Conservatory guest;
    private FoodType[] foodList;
    private FoodType[] foodList1;
    private FoodType[] foodList2;
    private FoodType[] foodList3;
    private WaterType[] waterList;

    private Bird parrot;
    private Bird pigeon;
    private Bird shoreBird;
    private Bird waterFowl;


    private Map<Integer, Bird> birds;


    @Before
    public void setup() {
        guest = new Conservatory();
        foodList = new FoodType[]{FoodType.BERRIES, FoodType.INSECTS, FoodType.FRUIT, FoodType.LARVAE};
        pigeon = new Pigeons(false,2, List.of(foodList),null,"pigeon");

        foodList1 = new FoodType[]{FoodType.BERRIES, FoodType.FRUIT, FoodType.LARVAE};
        parrot = new Parrots(false,2,Arrays.asList(foodList1) , BirdType.GRAY_PARROT, "parrot",30,"eat");

        foodList2 = new FoodType[]{FoodType.OTHER_BIRDS, FoodType.INSECTS};
        waterList = new WaterType[]{WaterType.WETLANDS, WaterType.FRESHWATER, WaterType.SALTWATER, WaterType.SHORELANDS,WaterType.OCEAN};
        shoreBird = new ShoreBirds(false,2,Arrays.asList(foodList2),  BirdType.GOOSE,"shoreBird",Arrays.asList(waterList));

        foodList3 = new FoodType[]{FoodType.INSECTS, FoodType.FISH};
        waterList = new WaterType[]{WaterType.FRESHWATER, WaterType.SALTWATER};
        waterFowl = new WaterFowls(false,2,Arrays.asList(foodList3) , BirdType.DUCK, "waterFowl", Arrays.asList(waterList));

    }

    /**
     * Testing if Pigeon is successfully rescued by checking the given information.
     * All other birds will be tested as the same way.
     */
    @Test
    public void testPigeons() {
        guest.putBird(pigeon);
        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(1).getClassification(),
                "pigeon");
        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(1).getBirdType(),
                null);
        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(1).getFoodItem().toString(),
                "[BERRIES, INSECTS, FRUIT, LARVAE]");
        assertFalse(guest.getConservatory().get(1).getAviaryMap().get(1).getIsExtinct());
        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(1).getNumOfWings(),
                2);
    }


    /**
     * Testing when different kind of birds are rescued and whether we put it in in appropriate position.
     */
    @Test
    public void testRescueBird() {
        guest.putBird(pigeon);
        guest.putBird(parrot);
        guest.putBird(waterFowl);
        guest.putBird(shoreBird);


        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(1), pigeon);
        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(2), parrot);
        assertEquals(guest.getConservatory().get(2).getAviaryMap().get(1), waterFowl);
        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(3), shoreBird);

    }


    /**
     * Testing when exclusive aviary is full.
     */
    @Test
    public void testMaxNumBirdForExclusiveAviary() {
        guest.putBird(parrot);
        guest.putBird(parrot);
        guest.putBird(parrot);
        guest.putBird(parrot);
        guest.putBird(parrot);
        guest.putBird(parrot);

   //System.out.println(guest.getConservatory().get(1).getAviaryMap().get(4));

        assertEquals(guest.getConservatory().get(1).getAviaryMap().get(5), parrot);
        assertEquals(guest.getConservatory().get(2).getAviaryMap().get(1), parrot);
    }
//    @Test
//    public void testSetAviary(){
//        birds.put(2,b)
//    }




    /**
     * Testing whether food is added .
     */
    @Test
    public void testFood() {
        guest.putBird(waterFowl);

        Map<List<FoodType>, Integer> food = new HashMap<>();
        food.put(Arrays.asList(foodList3), 1);
        assertEquals(guest.getConservatory().get(1).getFood(), food);

        guest.putBird(parrot);
        food.put(Arrays.asList(foodList1), 1);
        assertEquals(guest.getConservatory().get(1).getFood(), food);
    }


    /**
     * Testing if there's not enough aviary for new birds.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughAviary() throws Exception {
        for(int i = 0; i < 100; i++) {
            guest.putBird(pigeon);
        }

        guest.putBird(pigeon);
    }

    /**
     * Testing whether birds are located in right position with sign at every aviary.
     */
    @Test
    public void testPrintMapAndSign() {
        String expected = "Aviary Location: 1 -> MixedGRAY_PARROT";


        guest.putBird(parrot);



        assertEquals(guest.birdMap(), expected);
    }


    /**
     * Testing whether birds are listed in alphabetical order in index.
     */
    @Test
    public void testPrintIndex() {
        String expected = "Conservatory Index:There's a DUCK in aviary [6]There's a GRAY_PARROT in aviary [1]";


        for(int i = 0; i < 6; i++)
            guest.putBird(waterFowl);
            guest.putBird(parrot);


        assertEquals(guest.printConservatoryMap(), expected);
    }


}



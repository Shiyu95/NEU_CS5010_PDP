package test;

import gear.FootWear;
import gear.Gear;
import gear.HandGear;
import gear.HeadGear;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Test plan for all gear types
 */
public class GearTest {
    private Gear headGear;
    private Gear handGear;
    private Gear footWear;

    @Before
    public void setGear() {
        headGear = new HeadGear("Sleepy", "Hat", 10);
        handGear = new HandGear("Happy", "Gloves", 5);
        footWear = new FootWear("Scurrying", "Sandals", 10, 3);
    }


    //Test all gear constructor build success
    @Test
    public void testConstructorHeadGear() {
        assertEquals("Gear name: Sleepy Hat, Attack power = 0, Defense Strength = 10, Total Strength =  10", headGear.toString());

    }

    @Test
    public void testConstructorHandGear() {
        assertEquals("Gear name: Happy Gloves, Attack power = 5, Defense Strength = 0, Total Strength =  5", handGear.toString());

    }

    @Test
    public void testConstructorFootGear() {
        assertEquals("Gear name: Scurrying Sandals, Attack power = 10, Defense Strength = 3, Total Strength =  13", footWear.toString());

    }



    //Check if the item has negative attack or defense power
    @Test(expected = IllegalArgumentException.class)
    public void testGearInNegativePower() {
        headGear = new HeadGear("Sleepy", "Hat", -10);
        handGear = new HandGear("Happy", "Gloves", -5);
        footWear = new FootWear("Scurrying", "Sandals", -10, 2);
    }

    //Check if the item has null value name
    @Test(expected = IllegalArgumentException.class)
    public void testGearInNullValueName() {
        headGear = new HeadGear(" ", "Hat", 10);
        handGear = new HandGear("Happy", null, 5);
        footWear = new FootWear(" ", "Sandals", 10, 2);
    }



    //Test all get method for the gear.
    @Test
    public void testGetHeadGear() {
        assertEquals("Sleepy", headGear.getAdj());
        assertEquals("Hat", headGear.getNoun());
        assertEquals(10, headGear.getDefense());
        assertEquals(10, headGear.getTotalStrength());
    }

    @Test
    public void testGetHandGear() {
        assertEquals("Happy", handGear.getAdj());
        assertEquals("Gloves", handGear.getNoun());
        assertEquals(5, handGear.getAttack());
        assertEquals(5, handGear.getTotalStrength());
    }

    @Test
    public void testGetFootWear() {
        assertEquals("Scurrying", footWear.getAdj());
        assertEquals("Sandals", footWear.getNoun());
        assertEquals(10, footWear.getAttack());
        assertEquals(3, footWear.getDefense());
        assertEquals(13, footWear.getTotalStrength());
    }


    //Test combine two items
    @Test
    public void testCombineHeadGear() {
        Gear headGear2 = new HeadGear("Quickly", "Helmet", 15);
        Gear newHeadGear = headGear2.combine(headGear);
        assertEquals("Gear name: Sleepy,Quickly Helmet, Attack power = 0, Defense Strength = 25, Total Strength =  25",newHeadGear.toString());
    }


    @Test
    public void testCombineHandGear() {
        Gear handGear2 = new HandGear("Shining", "Sword", 6);
        Gear newHandGear = handGear2.combine(handGear);
        assertEquals("Gear name: Happy,Shining Sword, Attack power = 11, Defense Strength = 0, Total Strength =  11",newHandGear.toString());
    }

    @Test
    public void testCombineFootWear() {
        Gear footWear2 = new FootWear("Happy", "HoverBoard", 1,3);
        Gear newFootWear = footWear2.combine(footWear);
        assertEquals("Gear name: Scurrying,Happy HoverBoard, Attack power = 11, Defense Strength = 6, Total Strength =  17",newFootWear.toString());
    }


    //Test combine item which should be the same type.
    @Test(expected = IllegalArgumentException.class)
    public void testGearCombineHeadHasSameType() {
       headGear.combine(footWear);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGearCombineHandHasSameType() {
        handGear.combine(footWear);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGearCombineFootHasSameType() {
        footWear.combine(headGear);
    }

}
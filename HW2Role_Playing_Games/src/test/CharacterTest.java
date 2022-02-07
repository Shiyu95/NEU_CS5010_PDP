package test;

import gear.FootWear;
import gear.Gear;
import gear.HandGear;
import gear.HeadGear;
import battle.Character;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    private Gear headGear;
    private Gear headGear2;

    private Gear handGear;
    private Gear handGear2;
    private Gear handGear3;

    private Gear footWear;
    private Gear footWear2;
    private Gear footWear3;
    private Gear footWear4;
    private Character character1;


    //set up test item.
    @Before
    public void setGear() {
        headGear = new HeadGear("Sleepy", "Hat", 10);
        headGear2 = new HeadGear("Quickly", "Helmet", 15);

        handGear = new HandGear("Happy", "Gloves", 5);
        handGear2 = new HandGear("Golden", "Shield", 7);
//        handGear3 = new HandGear("Magical", "Sword", 12);

        footWear = new FootWear("Scurrying", "Sandals", 10, 3);
        footWear2 = new FootWear("Well-worn", "Sneakers", 3, 7);
        footWear3 = new FootWear("Thick", "HoverBoard", 5,2);
        footWear4 = new FootWear("Scurrying", "Sandals", 7, 9);

        character1 = new Character("Jack", 0, 0);
    }


    //Test for get the character name
    @Test
    public void testGetName() {
        assertEquals("Jack", character1.getName());

    }

    //Test only pick one item situation
    @Test
    public void testOnlyPicFootDefense() {
        character1.pickup(footWear2);
        character1.pickup(handGear);
        character1.pickup(headGear);
        assertEquals("[Gear name: Well-worn Sneakers, Attack power = 3, Defense Strength = 7, Total Strength =  10]",character1.getFootWearList().toString());
        assertEquals("Gear name: Sleepy Hat, Attack power = 0, Defense Strength = 10, Total Strength =  10",character1.getHeadGear().toString());
        assertEquals("[Gear name: Happy Gloves, Attack power = 5, Defense Strength = 0, Total Strength =  5]",character1.getHandGearList().toString());
    }

    //Test for the character pick up more than limit number gear and in a combine situation
    @Test
    public void testPickUp() {
        character1.pickup(headGear);
        character1.pickup(headGear2);

        character1.pickup(footWear);
        character1.pickup(footWear2);
        character1.pickup(footWear3);

        character1.pickup(handGear);
        character1.pickup(handGear2);
        assertEquals("Gear name: Sleepy,Quickly Helmet, Attack power = 0, Defense Strength = 25, Total Strength =  25",character1.getHeadGear().toString());
        assertEquals("[Gear name: Happy Gloves, Attack power = 5, Defense Strength = 0, Total Strength =  5, Gear name: Golden Shield, Attack power = 7, Defense Strength = 0, Total Strength =  7]",
                character1.getHandGearList().toString());
        assertEquals("[Gear name: Scurrying Sandals, Attack power = 10, Defense Strength = 3, Total Strength =  13, Gear name: Thick,Well-worn Sneakers, Attack power = 8, Defense Strength = 9, Total Strength =  17]",
                character1.getFootWearList().toString());

    }

    //Test for the character's total attack power after pick up same gear
    @Test
    public void testTotalAttack() {
        character1.pickup(headGear);
        character1.pickup(footWear);
        character1.pickup(handGear);
        character1.pickup(headGear2);
        character1.pickup(footWear2);
        character1.pickup(footWear3);
        character1.pickup(handGear2);
        assertEquals(30,character1.getTotalAttack());
    }


    //Test for the character's total defense power after pick up same gear
    @Test
    public void testTotalDefense() {
        character1.pickup(headGear);
        character1.pickup(footWear);
        character1.pickup(handGear);
        character1.pickup(headGear2);
        character1.pickup(footWear2);
        character1.pickup(footWear3);
        character1.pickup(handGear2);
        assertEquals(37,character1.getTotalDefense());
    }

}
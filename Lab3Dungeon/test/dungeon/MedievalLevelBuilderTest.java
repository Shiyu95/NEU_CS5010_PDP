package dungeon;
import dungeon.Level;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedievalLevelBuilderTest {
    private Level level;


    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRoomNumber() {
        level = new MedievalLevelBuilder(-1, 2, 8, 4).addRoom("Room1").addOgre(0).addPotion(0).build();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMonstersNum() {
        level = new MedievalLevelBuilder(1, -2, 8, 4).addRoom("Room1").addOgre(0).addPotion(0).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeLevel() {
        level = new MedievalLevelBuilder(1, 2, 8, -4).addRoom("Room1").addOgre(0).addPotion(0).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeTreasuresNum() {
        level = new MedievalLevelBuilder(1, -2, -8, 4).addRoom("Room1").addOgre(0).addPotion(0).build();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRoomNumForGoblin() {
        level = new MedievalLevelBuilder(1, 2, 8, 4)
                .addRoom("Room1").addGoblins(-1,2).addPotion(0).build();
    }


}
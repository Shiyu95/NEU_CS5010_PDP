import battle.BattleInterface;
import battle.CharacterInterface;
import gear.FootWear;
import gear.Gear;
import gear.HandGear;
import gear.HeadGear;
import battle.Battle;
import battle.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {
  public static void main(String[] args) {


    //Give two character for the battle
    Character character1 = new Character("John", 0, 0);
    Character character2 = new Character("Lisa", 0, 0);

    //Give ten possible ger for pickUp
    ArrayList<Gear> gearList = new ArrayList<>();
    gearList.add(new HeadGear("Sleepy", "Hat", 10));
   // gearList.add(new HeadGear("Sl", "Hat", 9));
    gearList.add(new HandGear("Happy", "Gloves", 5));
    gearList.add(new HandGear("Shining", "Sword", 6));
    //gearList.add(new HeadGear("Quickly", "Helmet", 15));
    gearList.add(new HandGear("Golden", "Shield", 7));
    gearList.add(new HandGear("Magical", "Sword", 12));
    gearList.add(new FootWear("Scurrying", "Sandals", 10, 3));
    gearList.add(new FootWear("Happy", "HoverBoard", 5,1));
    gearList.add(new FootWear("Well-worn", "Sneakers", 3, 2));
    gearList.add(new FootWear("Happy", "HoverBoard", 5,1));
    gearList.add(new FootWear("Well-worn", "Sneakers", 3, 2));



    //start a new battle
    BattleInterface battle = new Battle(character1,character2, gearList);

    //The two character take turn to pick up gear
    while(battle.oneTurn()) {
        System.out.println(battle.status());
    }
    //Get the final winner for the battle
    System.out.println(battle.winner());
  }
}

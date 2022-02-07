package battle;
import gear.Gear;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/*
 * This class define a battle for two character.
 */
public class Battle implements BattleInterface{
    private final Character character1;
    private final Character character2;
    private final List<Gear> gearList;

    //Constructor for battle class
    public Battle(Character character1, Character character2, ArrayList<Gear> gearList){
        this.character1 = character1;
        this.character2 = character2;
        this.gearList = gearList;
    }

    //Get character 1 for the battle
    @Override
    public Character getCharacter1() {
        return character1;
    }

    //Get character 2 for the battle
    @Override
    public Character getCharacter2() {
        return character2;
    }


    @Override
    //The check class for us to make sure character will pick up gear to fill up empty space first
    public boolean check(Character c) {
        int len = gearList.size();
        for (int i = 0; i <len; i++) {
            switch (gearList.get(i).getType()) {
                case HEAD:
                    if (c.getHeadGear() == null) {
                        c.pickup(gearList.get(i));
                        gearList.remove(i);
                        len--;
                        i--;
                        return false;
                    }
                    break;
                case HAND:
                    if (c.getHandGearList().size()<2) {
                        c.pickup(gearList.get(i));
                        gearList.remove(i);
                        len--;
                        i--;
                        return false;
                    }
                    break;
                case FOOT:
                    if (c.getFootWearList().size()<2) {
                        c.pickup(gearList.get(i));
                        gearList.remove(i);
                        len--;
                        i--;
                        return false;
                    }
                    break;
            }
        }
        //after make sure they are quantity rule1. Then it will start combine
        addAfterCheck(c);
        return true;
    }




    //after make sure they are quantity rule1. Then it will start combine
    @Override
    public boolean addAfterCheck(Character c){
        int len = gearList.size();
        for (int i = 0; i < len; i++) {

            switch (gearList.get(i).getType()) {
                case HEAD:
                    if (c.getHeadGear() != null) {
                        c.pickup(gearList.get(i));
                        gearList.remove(i);
                        len--;
                        i--;
                        return false;
                    }
                    break;
                case HAND:
                    if (c.getHandGearList().size()==2) {
                        c.pickup(gearList.get(i));
                        gearList.remove(i);
                        len--;
                        i--;
                        return false;
                    }
                    break;
                case FOOT:
                    if (c.getFootWearList().size()==2) {
                        c.pickup(gearList.get(i));
                        gearList.remove(i);
                        len--;
                        i--;
                        return false;
                    }
                    break;
            }

        }
        return true;
    }


    @Override
    // invoke one turn of the battle.
    // Each turn a character pick an item based on the rules.
    // returns false if the battle ends
    public boolean oneTurn() {
        //When all gearsList is empty. Stop the turn
        if(gearList.size() == 0){
            return false;
        }

        //Rule2: used to compare all items in gearList. First consider total highest strength, then higher attack, defense strength
        gearList.sort(Comparator.comparingInt(Gear::getTotalStrength).reversed()
                .thenComparing(Comparator.comparingInt(Gear::getAttack).reversed()));
        //gearList.forEach(System.out::println);

        //Rule1: Then need to make sure empty space get gear first, then combine.
        int counter = gearList.size();
        if(counter%2==0){
            check(character1);
        }
        if(counter%2==1){
            check(character2);
        }

        return true;
    }


    @Override
    // Print out each character with what they are wearing
    // and their attack and defense strength
    public String status() {
        return String.format("Each Turn: \nCharacter1: %sCharacter2 : %s\n", character1.toString(), character2.toString());
    }

    @Override
    // return the winner's name or "tie"
    public String winner() {
        int character1Damage = character2.getTotalAttack() - character1.getTotalDefense();
        int character2Damage = character1.getTotalAttack() - character2.getTotalDefense();
        if(character1Damage==character2Damage){
            return "tie";
        }else if(character1Damage<character2Damage){
            return character1.getName();
        }else{
            return character2.getName();
        }
    }

}

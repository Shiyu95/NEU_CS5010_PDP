package battle;

import gear.Gear;

import java.util.List;

/*
 * This interface represents a character.
 * It can get different data for the character
 */
public interface CharacterInterface {
    //Get the name of the character
    String getName();

    //Get the headGear of the character
    Gear getHeadGear();

    //Get the handGearList of the character
    List<Gear> getHandGearList();

    //Get the footGearList of the character
    List<Gear> getFootWearList();

    //The pickup class for character pick up gear in the different situation
    void pickup(Gear g);

    //Get the all gear total attack for the character
    int getTotalAttack();

    //Get the all gear total defence for the character
    int getTotalDefense();

}

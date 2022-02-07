package battle;
import gear.Gear;

/*
 * This interface represents a battle
 * It will have two characters, they will take turn to get item form the list.
 * And we can know each turn what is they status
 * Finally, it will decide who is the winner.
 */
public interface BattleInterface{

  //Get character 1 for the battle
  Character getCharacter1();

  //Get character 2 for the battle
  Character getCharacter2();

  //this check class for us to make sure character
  //will pick up gear to fill up empty space first
  boolean check(Character c);

  boolean addAfterCheck(Character c);

  // invoke one turn of the battle.
  // Each turn a character pick an item based on the rules.
  // returns false if the battle ends
  boolean oneTurn();

  // Print out each character with what they are wearing
  // and their attack and defense strength
  String status();

  // return the winner's name or "tie"
  String winner();
}

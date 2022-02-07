package battle;
import gear.Gear;
import java.util.ArrayList;
import java.util.List;

/*
 * define a character of the game.
 */
public class Character  implements CharacterInterface {
  public static final int FOOT_WEAR_NUM = 2;
  public static final int HAND_GEAR_NUM = 2;
  public static final int HEAD_GEAR_NUM = 1;

  private final String name;
  private final int attackBase;
  private final int defenseBase;


  private List<Gear> handGear;
  private List<Gear> footWear;
  private Gear headGear;


  // Constructor for the character.
  public Character(String name, int attackBase, int defenseBase){
    if(attackBase<0 || defenseBase<0 || name.isEmpty() || name.isBlank()){
      throw new IllegalArgumentException("AttackBase, DefenseBase can't be 0. The Character name can't be null or empty");
    }
    this.name = name;
    this.attackBase = attackBase;
    this.defenseBase = defenseBase;
    this.handGear = new ArrayList<Gear>();
    this.footWear = new ArrayList<Gear>();

  }

  //Get the name of the character
  @Override
  public String getName() {
    return name;
  }

  //Get the headGear of the character
  @Override
  public Gear getHeadGear(){
    return headGear;
  }

  //Get the handGearList of the character
  @Override
  public List<Gear> getHandGearList(){
    return handGear;
  }

  //Get the footGearList of the character
  @Override
  public List<Gear> getFootWearList(){
    return footWear;
  }


  //The pickup class for character pick up gear,
  //if the type is same and didn't more than the limit number,
  //put it in the same type list. OtherWise, combine it within the same type list.
  @Override
  public void pickup(Gear g) {
    // simply put `g` on if there is avail slot
    // otherwise, combine `g` with an existing one
    // with the same type, by calling g.Combine(...);
    switch (g.getType()){
      case HEAD:
        if(headGear==null){
          headGear = g;
        }else{
          headGear = g.combine(headGear);
        }
        //System.out.println(headGear);
        break;

      case HAND:
        if(handGear.isEmpty()||handGear.size()<HAND_GEAR_NUM){
          handGear.add(g);
        }else{
          Gear newHandGear = handGear.get(1).combine(g);
          handGear.remove(1);
          handGear.add(newHandGear);

        }
      break;

      case FOOT:
        if(footWear.isEmpty()||footWear.size() < FOOT_WEAR_NUM){
          footWear.add(g);
        }else{
          Gear newFootWear = footWear.get(1).combine(g);
          footWear.remove(1);
          footWear.add(newFootWear);
        }
        break;

    }
  }

  //Get the all gear total attack for the character
  @Override
  public int getTotalAttack() {
    int total= attackBase;
    for(Gear g: handGear){
      total += g.getAttack();

    }
    for(Gear g: footWear){
      total += g.getAttack();

    }
    return total;
  }

  //Get the all gear total defence for the character
  @Override
  public int getTotalDefense() {
    int total= defenseBase;
    for(Gear g: footWear){
      total += g.getDefense();
    }
    if(headGear!=null){
      total += headGear.getDefense();
    }
    return total;
  }


  @Override
  public String toString() {
    return String.format("Name: %s, "
                    + "Total defense Strength = %d" +" \nHead: %s"+" \nHand: %s"+" \nFoot: %s\n\n",
            this.getName(), this.getTotalDefense(),
            this.getHeadGear(), this.getHandGearList(),this.getFootWearList());
  }
}

package gear;
/*
 * This abstract class for implementations of Gear.
 */
public abstract class AbstractGear implements Gear {
  private final GearType type;
  private final String adj;
  private final String noun;
  private final int attack;
  private final int defense;

  // Constructor for gears
  public AbstractGear(String adj, String noun, int attack, int defense, GearType type){
    // when the power is negative, throw IllegalArgumentException.
    if(attack<0 || defense<0){
      throw new IllegalArgumentException("The power can't be negative");
    }
    //when the adj or noun are null value, throw IllegalArgumentException
    if(adj.isBlank()||adj.isEmpty()||noun.isBlank()||noun.isEmpty()){
      throw new IllegalArgumentException("The name can't be null or empty");
    }
    this.adj = adj;
    this.noun = noun;
    this.attack = attack;
    this.defense = defense;
    this.type = type;
  }

  //Get each gear's type
  @Override
  public GearType getType() {
    return type;
  }

  //Get each gear's adjective
  @Override
  public String getAdj() {
    return adj;
  }

  //Get each gear's noun
  @Override
  public String getNoun() {
    return noun;
  }

  //Get each gear's attack power value
  @Override
  public int getAttack() {
    return attack;
  }

  //Get each gear's defense power value
  @Override
  public int getDefense() {
    return defense;
  }

  //Get each gear's total power value
  public int getTotalStrength(){
    return attack + defense;
  }




  @Override
  public String toString() {
    return String.format("Gear name: %s %s, Attack power = %d, "
                    + "Defense Strength = %d, " + "Total Strength = % d",
            this.getAdj(), this.getNoun(), this.getAttack(), this.getDefense(), this.getTotalStrength());
  }


}

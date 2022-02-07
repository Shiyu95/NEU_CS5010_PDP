package gear;
/*
 * This interface defines a gear with its methods.
 */
public interface Gear {
  // combine `other` with `this` to get a new Gear
  // throw exception if types are different
  Gear combine(Gear other);

  //getters
  //Get type of the gear
  GearType getType();

  //Get adjective of the gear
  String getAdj();

  //Get noun of the gear
  String getNoun();

  //Get attack power of the gear
  int getAttack();

  //get defense power of gear
  int getDefense();

  //get total power of gear
  int getTotalStrength();
}

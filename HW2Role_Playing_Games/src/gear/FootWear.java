package gear;
import gear.AbstractGear;

/*
 * Define a footwear.
 * These items go on the character’s feet (boots/sneakers/hoverboard) and can be for attack or defense.
 */
public class FootWear extends AbstractGear {


  //Constructor for footWear
  public FootWear(String adj, String noun, int attack, int defense) {
    super(adj, noun, attack, defense, GearType.FOOT);
  }

  //When the gear is the same type:FOOT. the two footwear can combine into a new one.
  //OtherWise,the function throw a illegalArgumentException.
  @Override
  public Gear combine(Gear g) {
      FootWear newFoot;
    // return a new footwear
    if (g.getType() == GearType.FOOT) {
      newFoot = new FootWear(g.getAdj()+ "," + this.getAdj() , this.getNoun(),
              this.getAttack() + g.getAttack(),this.getDefense()+ g.getDefense());

    }else{
      throw new IllegalArgumentException("Combine gears should be same type.");
    }
    return newFoot;
  }


}



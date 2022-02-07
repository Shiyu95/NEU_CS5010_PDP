package gear;
/*
 * Define a handGear.
 * These items go on the character’s hands (gloves/swords/shield) and are only used for attack
 */
public class HandGear extends AbstractGear {


    //Constructor for handGear
    public HandGear(String adj, String noun, int attack) {
        super(adj, noun, attack, 0, GearType.HAND);
    }

    //When the gear is the same type:HAND. the two handGears can combine into a new one.
    //OtherWise,the function throw a illegalArgumentException.
    @Override
    public Gear combine(Gear g) {
        HandGear newHand;
        // return a new hand gear
        if (g.getType() == GearType.HAND) {
            newHand = new HandGear(g.getAdj()+ "," + this.getAdj() , this.getNoun(),
                    this.getAttack() + g.getAttack());
        }else{
            throw new IllegalArgumentException("Combine gears should be same type.");
        }
        return newHand;
    }

}

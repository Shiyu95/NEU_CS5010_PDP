package gear;
/*
 * Define a HeadGear.
 * These items go on the character’s head (hats/helmets/visors) and are only useful for defense.
 */
public class HeadGear extends AbstractGear {

    //Constructor for headGear
    public HeadGear(String adj, String noun, int defense) {
        super(adj, noun, 0, defense, GearType.HEAD);
    }

    //When the gear is the same type:HEAD. the two headGears can combine into a new one.
    //OtherWise,the function throw a illegalArgumentException.
    @Override
    public Gear combine(Gear g) {
        HeadGear newHead;
        // return a new head gear
        if (g.getType() == GearType.HEAD) {
           newHead = new HeadGear(g.getAdj()+ "," + this.getAdj() , this.getNoun(),
                    this.getDefense() + g.getDefense());

        }else{
            throw new IllegalArgumentException("Combine gears should be same type.");
        }
        return newHead;
    }

}

package BirdClass;

import java.util.EnumSet;
import java.util.List;

/**
 *The class parrots for parrot, which extends the abstract "Bird" class.
 */
public class Parrots extends Bird {
    private int numOfVocabulary;
    private String favWords;
    private BirdType birdType;
    private EnumSet<BirdType> parrotsType = EnumSet.of(BirdType.ROSE_RING_PARAKEET,BirdType.GRAY_PARROT, BirdType.SULFUR_CRESTED_COCKATOO);



    public Parrots(boolean isExtinct, int numOfWings,  List<FoodType> foodList, BirdType birdType, String classification, int numOfVocabulary, String favWords){
        super(isExtinct,numOfWings,foodList,birdType,classification);
        this.favWords = favWords;
        this.numOfVocabulary = numOfVocabulary;
        this.birdType = birdType;

    }



    @Override
    public BirdType getBirdType(){
        return birdType;
    }

    //the number of words in the parrot's vocabulary
    public int getNumOfVocabulary(){
        return numOfVocabulary;
    }


    //parrot like "favorite" saying.
    public String getFavWords(){
       return favWords;
    }



    /**
     *  String method: returns string representation of object
     *
     */
    @Override
    public String toString(){
        return "Type: " + this.getBirdType() + ", Characteristics: " + this.getClassification() +
                ", Is Extinct: " + this.getIsExtinct() + ", Wing numbers: " + this.getNumOfWings() +
                ", Food preference: " + this.getFoodItem() + ", number of vocabulary it can use: "+ this.getNumOfVocabulary() +", It have s favorite saying: " +this.getFavWords();
    }
}

package lookandsay;

import java.math.BigInteger;

public class LookAndSayIterator implements RIterator<BigInteger> {
    private final BigInteger start;
    private final BigInteger end;
    private BigInteger currentNum;

    //Constructor that takes two arguments
    public LookAndSayIterator(BigInteger seed, BigInteger end) {
        if(seed.compareTo(new BigInteger("0"))<0){
            throw new IllegalArgumentException("The seed can't be negative");
        }
        if(seed.compareTo(end)>=0){
            throw new IllegalArgumentException("The seed can't be large than end ");
        }

        String numList = seed.toString();
        for(int i = 0; i< numList.length(); i++){
            if(numList.contains("0")){
                throw new IllegalArgumentException("The seed has o in it ");
            }
        }

        this.start = seed;
        this.end = end;
        this.currentNum = this.start;


    }

    //Constructor that takes a starting seed as its only argument
    public LookAndSayIterator(BigInteger seed) {

        this.start = seed;
        this.end =  new BigInteger("9".repeat(100));
        this.currentNum = this.start;

        if(seed.compareTo(new BigInteger("0"))<0){
            throw new IllegalArgumentException("The seed can't be negative");
        }
        if(seed.compareTo(end)>=0){
            throw new IllegalArgumentException("The seed can't be large than end");
        }

        String numList = seed.toString();
        for(int i = 0; i< numList.length(); i++){
            if(numList.contains("0")){
                throw new IllegalArgumentException("The seed has o in it");
            }
        }

    }

    //Constructor that takes no arguments
    public LookAndSayIterator() {
        this.start = new BigInteger("1");
        this.end =  new BigInteger("9".repeat(100));
        this.currentNum = this.start;

    }

    //get next value based on current value
    private BigInteger getNext(){
        StringBuilder sb = new StringBuilder();
        String current = this.currentNum.toString();
        char c = current.charAt(0);
        int count = 0;

        for(int i = 0; i< current.length();i++){
            if(current.charAt(i) == c){
                count++;
            }else{
                sb.append(count).append(c);
                count = 1;
                c = this.currentNum.toString().charAt(i);
            }
        }
        sb.append(count).append(c);
        return new BigInteger(sb.toString());

    }


    @Override
    public BigInteger next() {
        BigInteger num = this.currentNum;
        currentNum = getNext();
        return num;
    }


    // True: next number to be returned is still lesser than end
    @Override
    public boolean hasNext() {
        return currentNum.compareTo(end) <= 0;
    }


    //the current number in the sequence and retreat to the previous number
    @Override
    public BigInteger prev() {
        if(!hasPrevious()){
            return this.currentNum;
        }
        BigInteger prevNum = this.currentNum;
        StringBuilder sb = new StringBuilder();
        String current = this.currentNum.toString();
        for(int i = 0; i< current.length();i=i+2){
            int count = current.charAt(i) - '0';
            for (int j = 0; j < count; j++){
                sb.append(current.charAt(i+1));
            }
        }
        this.currentNum = new BigInteger(sb.toString());
        return prevNum;
    }



    @Override
    public boolean hasPrevious() {
        return this.currentNum.toString().length() % 2 == 0;
    }


}
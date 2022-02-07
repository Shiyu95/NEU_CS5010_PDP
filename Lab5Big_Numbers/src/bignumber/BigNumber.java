package bignumber;

public interface BigNumber {
   int length();
   void shiftLeft(int shift);
   void shiftRight(int shift);
   void addDigit(int digit);
   int getDigitAt(int position);
   BigNumber copy();
   BigNumber add(BigNumber number);
   int compareTo(BigNumber num1);


}

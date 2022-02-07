import java.math.BigInteger;

public class test {
    public static String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        System.out.println(x);
        BigInteger y = new BigInteger(b, 2);
        System.out.println(y);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }


    public static void main(String[] args){
        String a = "111";
        String b = "010";
        System.out.println(addBinary(a,b));
    }
}

package lookandsay;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class LookAndSayIteratorTest {
    @Test
    public void testBasic() {
        BigInteger seed = new BigInteger("123");
        RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
        BigInteger num1 = iterator.next();
        assertEquals(new BigInteger("123"), num1);
    }

    @Test
    public void testPrev() {
        RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("111213"));
        assertTrue(it.hasPrevious());
        assertEquals(new BigInteger("111213"), it.prev());
    }

}
import static org.junit.Assert.assertEquals;
import bignumber.BigNumberImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing big number implementation.
 */
public class BigNumberImplTest {
    BigNumberImpl number1;
    BigNumberImpl number2;

    @Before
    public void setUp() {
        number1 = new BigNumberImpl("32411");
        number2 = new BigNumberImpl("42411");

    }

    @Test
    public void testNumberLength() {
        assertEquals(5, number1.length());
    }

    @Test
    public void testLeftShift() {
        number1.shiftLeft(1);
        assertEquals("324110", number1.toString());
        number1.shiftLeft(2);
        assertEquals("32411000", number1.toString());
        number1.shiftLeft(-7);
        assertEquals("3", number1.toString());
        number1.shiftLeft(0);
        assertEquals("3", number1.toString());
        number1.shiftLeft(-1);
        assertEquals("0", number1.toString());
        number1.shiftLeft(-7);
        assertEquals("0", number1.toString());
        number1.shiftLeft(3);
        assertEquals("0", number1.toString());
    }

    @Test
    public void testRightShift() {
        number1.shiftRight(1);
        assertEquals("3241", number1.toString());
        number1.shiftRight(-2);
        assertEquals("324100", number1.toString());
        number1.shiftRight(6);
        assertEquals("0", number1.toString());
        number1.shiftRight(1);
        assertEquals("0", number1.toString());
        number1.shiftRight(-5);
        assertEquals("0", number1.toString());
    }

    @Test
    public void testAddDigit() {
        number1.addDigit(5);
        assertEquals("32416", number1.toString());
        number1.addDigit(9);
        assertEquals("32425", number1.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTwoDigits() {
        number1.addDigit(12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNegDigit() {
        number1.addDigit(-9);
    }

    @Test
    public void testGetDigitAt() {
        assertEquals(1, number1.getDigitAt(0));
        assertEquals(3, number1.getDigitAt(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetInvalidDigit() {
        number1.getDigitAt(6);
    }

    @Test
    public void testCopy() {
        assertEquals("32411"
                , number1.copy().toString());
    }

    @Test
    public void testAdd() {
        assertEquals("64822"
                , number1.add(number1).toString());
    }

    @Test
    public void testCompare() {
        assertEquals(-1, number1.compareTo(number2));
        assertEquals(0, number1.compareTo(number1));
        assertEquals(1, number2.compareTo(number1));
    }
}
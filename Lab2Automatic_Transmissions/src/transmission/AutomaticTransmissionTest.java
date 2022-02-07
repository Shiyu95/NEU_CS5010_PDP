package transmission;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AutomaticTransmissionTest {
    private Transmission car1;

    @Before
    public void setUp() {
        car1 = new AutomaticTransmission(2, 4, 6, 8, 10);
    }

    @Test
    public void testInitialization() {
        car1 = new AutomaticTransmission(2, 4, 6, 8, 10);
        assertEquals("Transmission (speed = 0, gear = 0)", car1.toString());
    }

    @Test
    public void testIncreaseSpeed() {
        car1.increaseSpeed();
        car1.increaseSpeed();
        assertEquals(4, car1.getSpeed());

    }

    @Test
    public void testCurrentGear() {
        car1.increaseSpeed();
        assertEquals(2, car1.getGear());
    }


    @Test
    public void testDecreaseSpeed() {
        car1.increaseSpeed();
        car1.increaseSpeed();
        car1.decreaseSpeed();
        assertEquals(2, car1.getSpeed());
    }

    @Test
    public void testDecreaseGear() {
        car1.increaseSpeed();
        car1.increaseSpeed();
        car1.decreaseSpeed();
        car1.decreaseSpeed();
        assertEquals(0, car1.getGear());
    }

    @Test
    public void testSpeedNeg() {
        try {
            car1.decreaseSpeed();
        } catch (IllegalArgumentException e) {
           System.out.println("the speed can't be negative");
        }
    }

}
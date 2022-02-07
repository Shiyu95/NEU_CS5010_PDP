package weather;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherReadingTest {
    private WeatherReading w;

    @Before
    public void setUp(){
        w = new WeatherReading(85,84,6,34);
    }

    @Test
    public void testRelativeHumidity() {
         assertEquals(95, w.getRelativeHumidity() );
    }

    @Test
    public void testHeatIndex(){
        assertEquals(774.32, w.getHeatIndex(),0.0);
    }

    @Test
    public void testWindChill(){
        assertEquals(208.44, w.getWindChill(),0.0);
    }

    @Test
    public void setDewTempBiggerThanAirTemp() {
        try {
            w = new WeatherReading(23, 30, 3, 12);
        } catch (IllegalArgumentException e) {
            System.out.println("dew point temperature in Celsius which cannot be greater than the air temperature");
        }
    }

    @Test
    public void setWindSpeedNeg() {
        try {
            w = new WeatherReading(23, 12, -3, 12);
        } catch (IllegalArgumentException e) {
            System.out.println("wind speed can't be negative");
        }
    }

    @Test
    public void setRainReceivedNeg() {
        try {
            w = new WeatherReading(23, 12, 3, -12);
        } catch (IllegalArgumentException e) {
            System.out.println("rain received can't be negative");
        }
    }


}
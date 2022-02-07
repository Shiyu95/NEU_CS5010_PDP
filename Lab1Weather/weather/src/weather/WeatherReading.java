package weather;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class WeatherReading {
    //Define 4 parameters
    private int airTemperature;
    private int dewPointTemperature;
    private int windSpeed;
    private int rainReceived;


    //Create a constructor with exception
    public WeatherReading(int airTemperature, int dewPointTemperature, int windSpeed, int rainReceived) {
        this.airTemperature = airTemperature;
        this.dewPointTemperature = dewPointTemperature;
        this.windSpeed = windSpeed;
        this.rainReceived = rainReceived;

        if (dewPointTemperature > airTemperature) {
            throw new IllegalArgumentException("dew point temperature in Celsius which cannot be greater than the air temperature");
        }
        if (windSpeed < 0 || rainReceived < 0) {
            throw new IllegalArgumentException("wind speed and rain received can't be negative");
        }
    }


    //Methods
    public int getTemperature() {
        return this.airTemperature;
    }

    public int getDewPoint() {
        return this.dewPointTemperature;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

    public int getTotalRain() {
        return this.rainReceived;
    }

    public int getRelativeHumidity() {
        return 100 - 5 * (this.getTemperature() - this.getDewPoint());
    }

    public double getHeatIndex() {
        double c1 = -8.78469475556;
        double c2 = 1.61139411;
        double c3 = 2.33854883889;
        double c4 = -0.14611605;
        double c5 = -0.012308094;
        double c6 = -0.0164248277778;
        double c7 = 0.002211732;
        double c8 = 0.00072546;
        double c9 = -0.000003582;

        int T = this.getTemperature();
        int R = this.getRelativeHumidity();

        double HeatIndex = c1 + c2 * T + c3 * R + c4 * T * R + c5 * Math.pow(T, 2) + c6 * Math.pow(R, 2) + c7 * Math.pow(T, 2) * R + c8 * T * Math.pow(R, 2) + c9 * Math.pow(T, 2) * Math.pow(R, 2);
        BigDecimal hi = new BigDecimal(HeatIndex).setScale(2, RoundingMode.DOWN);
        return hi.doubleValue();
    }

    public double getWindChill() {
        double v = this.getWindSpeed();
        double T = this.getTemperature();
        double tempF = (T * 9.0 / 5.0) + 32.0;
        double windChill = 35.74 + 0.6215 * tempF - 35.75 * Math.pow(v, 0.16) + 0.4275 * tempF * Math.pow(v, 0.16);

        BigDecimal wc = new BigDecimal(windChill).setScale(2, RoundingMode.DOWN);
        return wc.doubleValue();
    }


    public String toString() {
        return "Reading: T = " + this.getTemperature() + ", D = " + this.getDewPoint() + ", v = " + this.getWindSpeed() + ", rain = " + this.getTotalRain();
    }

}

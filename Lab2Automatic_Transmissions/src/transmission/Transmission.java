package transmission;
/**
 * The interface Transmission that represents a single car transmission.
 * */
public interface Transmission {
    /*
     * Speed increased by 2 and the appropriate gear.
     * @return {@code Transmission object} with increased speed.
     */
    Transmission increaseSpeed();


    /*
     * Speed decreased by 2 and the appropriate gear.
     * @return {@code Transmission object} with decreased speed.
     */
     Transmission decreaseSpeed();

    /*
     * Get the speed of thr car transmission
     * @return current speed
     */
     int getSpeed();

    /*
     * Get the current gear of thr car transmission
     * @return current gear
     */
     int getGear();


}

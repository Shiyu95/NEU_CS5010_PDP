package transmission;

public class AutomaticTransmission implements Transmission {
    private int speed;
    private int gear;
    private int speedThreshold1;
    private int speedThreshold2;
    private int speedThreshold3;
    private int speedThreshold4;
    private int speedThreshold5;

    public AutomaticTransmission(int speedThreshold1, int speedThreshold2, int speedThreshold3, int speedThreshold4, int speedThreshold5) {
        this.speedThreshold1 = speedThreshold1;
        this.speedThreshold2 = speedThreshold2;
        this.speedThreshold3 = speedThreshold3;
        this.speedThreshold4 = speedThreshold4;
        this.speedThreshold5 = speedThreshold5;
        if (speedThreshold1 <= 0 ||speedThreshold2 <= 0 || speedThreshold3 <= 0 || speedThreshold4 <= 0 || speedThreshold5 <= 0) {
            throw new IllegalArgumentException("SpeedThreshold should be bigger than zero.");
        } else if (speedThreshold1 > speedThreshold2) {
            throw new IllegalArgumentException("Speed threshold1 should be smaller than Speed threshold2.");
        } else if (speedThreshold2 > speedThreshold3) {
            throw new IllegalArgumentException("Speed threshold2 should be smaller than Speed threshold3.");
        } else if (speedThreshold3 > speedThreshold4) {
            throw new IllegalArgumentException("Speed threshold3 should be smaller than Speed threshold4.");
        } else if (speedThreshold4 > speedThreshold5) {
            throw new IllegalArgumentException("Speed threshold4 should be smaller than Speed threshold5.");
        }
    }


    /*
     * gearChecking in different proper status
     */

    public int gearCheck(){
        if(this.speed==0){
            this.gear = 0;
        }else if(this.speed>0 && this.speed < this.speedThreshold1){
            this.gear = 1;
        }else if(this.speedThreshold1<=this.speed && this.speed < this.speedThreshold2){
            this.gear = 2;
        }else if(this.speedThreshold2<=this.speed && this.speed <this.speedThreshold3){
            this.gear = 3;
        }else if(this.speedThreshold3<=this.speed && this.speed <this.speedThreshold4){
            this.gear = 4;
        }else if(this.speedThreshold4<=this.speed && this.speed <this.speedThreshold5){
            this.gear = 5;
        }else if(this.speedThreshold5<=this.speed && this.speed >= this.speedThreshold5){
            this.gear = 6;
        }return this.gear;
    }

    @Override
    public Transmission increaseSpeed() {
        this.speed = this.speed + 2;
        this.gear = this.gearCheck();
        return this;
    }

    @Override
    public Transmission decreaseSpeed() throws IllegalArgumentException{
        this.speed = this.speed - 2;
        this.gear = this.gearCheck();
        if(this.speed < 0){
            throw new IllegalStateException("the speed can't be negative");
        }
        return this;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getGear() {
        return this.gear;
    }


    public String toString(){
        return "Transmission (speed = " + this.getSpeed() + ", gear = " + this.getGear() + ")";
    }
}

package game;

public interface PlayerInterface {
    int getCoins();
    void pickUpCoins(Coin coins);
    void loseCoins(Thief thief);
}

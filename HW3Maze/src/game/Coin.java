package game;

//Player get coins
public class Coin {
  private final int coinValue;
  public Coin(int coins) {
    this.coinValue = coins;
  }
  public int valueChange(int currentCoins) {
    return currentCoins + this.coinValue;
  }
}

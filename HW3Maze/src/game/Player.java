package game;

//create player class
public class Player implements PlayerInterface {
  private int currentCoins;

  //player initial status
  public Player() {
    this.currentCoins = 0;
  }


  //get player current coins
  public int getCoins() {
    return this.currentCoins;
  }


  //when player pick up coins, update the current coins
  public void pickUpCoins(Coin coins) {
    System.out.println("You've pick up coins!");
    this.currentCoins = coins.valueChange(this.currentCoins);
  }

  //when player meet thief, lose coins, and update current coins
  public void loseCoins(Thief thief) {
    System.out.println("You've lose coins!");
    this.currentCoins = thief.valueChange(this.currentCoins);
  }
}

package game;

/**
 * Player gets robbed.
 * Gold amount will decrease 10%.
 */
public class Thief {
  private final double loss;
  static final double COIN_LOSS_RATIO = 0.1f;
  public Thief() {
    this.loss = COIN_LOSS_RATIO;
  }

  public int valueChange(int currentCoins) {
    return (int) (currentCoins * (1 - this.loss));
  }
}

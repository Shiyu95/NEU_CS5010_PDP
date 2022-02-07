package test;

import static org.junit.Assert.assertEquals;

import game.Coin;
import game.Thief;
import game.Player;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
  Player player;

  @Before
  public void setUp() {
    player = new Player();
  }

  @Test
  public void testGetCurrentGold() {
    assertEquals(0, player.getCoins());
  }

  @Test
  public void testAddCoin() {
    Coin coin = new Coin(8);
    player.pickUpCoins(coin);
    assertEquals(8, player.getCoins());
  }

  @Test
  public void testLossCoin() {
    Coin coin = new Coin(2);
    player.pickUpCoins(coin);
    Thief thief = new Thief();
    player.loseCoins(thief);
    assertEquals(1, player.getCoins());
  }

}
package test;

import static model.game.PlayerStatus.ALIVE;
import static org.junit.Assert.assertEquals;

import model.game.Player;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
  Player player;

  @Before
  public void setUp() {
    player = new Player(5);
  }

  @Test
  public void testGetArrowsCount() {
    assertEquals(5, player.getArrowsCount());
  }

  @Test
  public void testPlayerStatus() {
    assertEquals(ALIVE, player.getStatus());
  }

}
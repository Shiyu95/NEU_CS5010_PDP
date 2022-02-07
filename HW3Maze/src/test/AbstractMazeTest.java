package test;

import static org.junit.Assert.assertEquals;

import maze.Maze;
import maze.PerfectMaze;
import maze.RoomMaze;
import org.junit.Before;
import org.junit.Test;

public class AbstractMazeTest {
  Maze maze1;
  Maze maze2;

  @Before
  public void setUp() {
    maze1 = new PerfectMaze(4, 3);
    maze2 = new RoomMaze(2, 3, 1); //0~2
  }

  @Test
  public void testMazeInfo() {
    assertEquals(3, maze1.getTotalRow());
    assertEquals(4, maze1.getTotalCol());

    assertEquals(3, maze2.getTotalRow());
    assertEquals(2, maze2.getTotalCol());
    assertEquals(1, maze2.getWallNum());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInfo() {
    Maze maze3 = new PerfectMaze(-1, 3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemainWalls() {
    Maze maze4 = new RoomMaze(2, 3, 3);  // 0~2
  }

  @Test
  public void testCoinsLocation() {
    assertEquals(1, maze1.getCoinsLocation().get(0)[0]);
    assertEquals(1, maze1.getCoinsLocation().get(0)[1]);
    assertEquals(2, maze1.getCoinsLocation().get(1)[0]);
    assertEquals(0, maze1.getCoinsLocation().get(1)[1]);
  }

  @Test
  public void testThiefLocation() {
    assertEquals(1, maze1.getCoinsLocation().get(0)[0]);
    assertEquals(1, maze1.getCoinsLocation().get(0)[1]);
    assertEquals(2, maze1.getCoinsLocation().get(1)[0]);
    assertEquals(0, maze1.getCoinsLocation().get(1)[1]);
  }
}
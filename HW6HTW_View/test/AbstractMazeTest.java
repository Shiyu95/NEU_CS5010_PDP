package test;

import static org.junit.Assert.assertEquals;

import model.maze.Maze;

import model. maze.RoomMaze;
import model.maze.WrappingRoomMaze;
import org.junit.Before;
import org.junit.Test;

public class AbstractMazeTest {
  Maze maze1;
  Maze maze2;

  @Before
  public void setUp() {
    maze1 = new WrappingRoomMaze(4, 4, 2,2, 2); //0~2
    maze2 = new RoomMaze(3, 3, 2,1, 1); //0~2
  }

  @Test
  public void testMazeInfo() {
    assertEquals(4, maze1.getTotalRow());
    assertEquals(4, maze1.getTotalCol());

    assertEquals(3, maze2.getTotalRow());
    assertEquals(3, maze2.getTotalCol());
    assertEquals(2, maze2.getWallNum());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInfo() {
    Maze maze3 = new RoomMaze(-1, 3, 1, 1,1);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRemainWalls() {
    Maze maze4 = new RoomMaze(2, 3, 3,1,1);  // 0~2
  }

  @Test
  public void testPitsLocation() {
    assertEquals(2, maze1.getPitsLocation().get(0)[0]);
    assertEquals(1, maze1.getPitsLocation().get(0)[1]);
    assertEquals(1, maze2.getPitsLocation().get(0)[0]);
    assertEquals(0, maze2.getPitsLocation().get(0)[1]);
  }

  @Test
  public void testBatsLocation() {
    assertEquals(2, maze1.getBatsLoc().get(0)[0]);
    assertEquals(0, maze1.getBatsLoc().get(0)[1]);
    assertEquals(0, maze2.getBatsLoc().get(0)[0]);
    assertEquals(1, maze2.getBatsLoc().get(0)[1]);
  }
}
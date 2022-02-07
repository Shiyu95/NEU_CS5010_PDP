package model.maze;
/*
 * The room maze is a non-perfect maze. It can be multiple path from one point
 * to another point.
 */
public class RoomMaze extends AbstractMaze {
  public RoomMaze(int col, int row, int remainWalls, int bat, int pit) {
    super(col, row, remainWalls, bat, pit);

    super.buildMaze(this.getAllEdges(), false, remainWalls);
  }

}

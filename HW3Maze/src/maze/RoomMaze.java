package maze;
/*
 * The room maze is a non-perfect maze. It can be multiple path from one point
 * to another point.
 */
public class RoomMaze extends AbstractMaze {
  public RoomMaze(int col, int row, int remainWalls) {
    super(col, row, remainWalls);

    int edgesSize = (row - 1) * col + (col - 1) * row;
    int limitNum = edgesSize-row*col+1;
    if (remainWalls < 0 || remainWalls > limitNum) {
      throw new IllegalArgumentException("The room maze has invalid remain walls.");
    }
    super.buildMaze(this.getAllEdges(), false, remainWalls);
  }

}

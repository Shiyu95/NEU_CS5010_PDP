package maze;
import java.util.Arrays;
import java.util.List;

//Wrapping room maze class
public class WrappingRoomMaze extends AbstractMaze {
  public WrappingRoomMaze(int col, int row, int remainWalls) {
    super(col, row, remainWalls);
    int edgesSize = (row - 1) * col + (col - 1) * row;
    int limitNum = edgesSize-row*col+1;
    if (remainWalls < 0 || remainWalls > limitNum) {
      throw new IllegalArgumentException("You have an Invalid remaining walls for a room maze.");
    }

    //Wrapping Room maze need add all border wall into the allEdges list
    List<int[]> allEdges = super.getAllEdges();
    for (int i = 0; i < row; i++) {
      allEdges.add(new int[]{i, col - 1, i, 0});
    }
    for (int j = 0; j < col; j++) {
      allEdges.add(new int[]{row - 1, j, 0, j});
    }
    super.buildMaze(allEdges, false, remainWalls);
  }
}

package model.maze;
import java.util.Arrays;
import java.util.List;

//Wrapping room maze class
public class WrappingRoomMaze extends AbstractMaze {
  public WrappingRoomMaze(int col, int row, int remainWalls, int bat, int pit ) {
    super(col, row, remainWalls, bat, pit);

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

package maze;

/*
 * The perfect maze always only have one path from start point to the end point.
 * It won't have circular path and open areas.
 */
public class PerfectMaze extends AbstractMaze {
  public PerfectMaze(int col, int row) {
  super(col, row, 0);
  super.buildMaze(super.getAllEdges(), true, 0);
}
}

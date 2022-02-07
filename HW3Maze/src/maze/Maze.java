package maze;

import java.util.List;
import game.Cell;

// Maze interface class
public interface Maze {

  //get row num
  int getTotalRow();

  //get col num
  int getTotalCol();

  //get remain wall num
  int getWallNum();

  //add coin
  void addCoins();

  //get coin location
  List<int[]> getCoinsLocation();

  //add thief
  void addThief();

  //get thief location
  List<int[]> getThiefLoc();

  //get all edges list
  List<int[]> getAllEdges();

 // build maze
  void buildMaze(List<int[]> allEdges, boolean isPerfect, int numOfRemainWalls);

  //get maze map
  Cell[][] getCell();
}

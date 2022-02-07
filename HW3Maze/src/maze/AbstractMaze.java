package maze;
import java.util.*;

import game.Cell;

abstract class AbstractMaze implements Maze {
  //Variable for the AbstractMaze class
  public static final double COIN_PROBABILITY = 0.2f;
  public static final double THIEF_PROBABILITY = 0.1f;

  private final int totalRow;
  private final int totalCol;
  private final int wallNum;
  private final List<int[]> allEdges = new ArrayList<>();
  private final Cell[][] cell;
  private List<int[]> coinsLocationList = new ArrayList<>();
  private List<int[]> thiefLocationList = new ArrayList<>();
  int totalCells;

  //AbstractMaze constructor
  public AbstractMaze(int col, int row, int remainWalls) {
    //The num of row and col shouldn't be negative number
    if (row <= 0 || col <= 0) {
      throw new IllegalArgumentException("The maze should have positive row and columns.");
    }
    this.totalRow = row;
    this.totalCol = col;
    this.wallNum = remainWalls;
    this.cell = new Cell[row][col];
    this.totalCells = col * row;
  }

  @Override
  public int getTotalRow() {
    return this.totalRow;
  }

  @Override
  public int getTotalCol() {
    return this.totalCol;
  }

  @Override
  public int getWallNum() {
    return this.wallNum;
  }

  @Override
  public List<int[]> getAllEdges() {
    return this.allEdges;
  }

  @Override
  public Cell[][] getCell() {
    return this.cell;
  }


  @Override
  public void buildMaze(List<int[]> allEdges, boolean isPerfect, int remainWalls) {
    int LocationID  = 0;
    //create a two-dimensional array for the cell object
    //set up each cell id and
    for (int i = 0; i < totalRow; i++) {
      for (int j = 0; j < totalCol; j++) {
        Cell eachCell = new Cell(new int[]{i, j});
        eachCell.setID(LocationID );
        this.cell[i][j] = eachCell;
        LocationID++;
      }
    }

   //set up all inside edges in a maze and put all into the edges list
    for (int i = 0; i < totalRow; i++) {
      for (int j = 0; j <totalCol - 1; j++) {
        this.allEdges.add(new int[]{i, j, i, j + 1});
      }
    }
    for (int j = 0; j < totalCol; j++) {
      for (int i = 0; i < totalRow - 1; i++) {
        this.allEdges.add(new int[]{i, j, i + 1, j});
      }
    }

    Random random = new Random();
    random.setSeed(4);


    List<Set<Integer>> wallSet = new ArrayList<>();
    for (int i =0; i<totalCells;i++){
      HashSet<Integer> newSet = new HashSet<>();
      newSet.add(i);
      wallSet.add(newSet);
    }

    //remove wall and put into set
    int count = 0;
    while (totalCells - 1>count) {
   //random get two cell. check they are in a same set or not
      int[] randomEdges = this.allEdges.get(random.nextInt(this.allEdges.size()));
      Cell cell1 = this.cell[randomEdges[0]][randomEdges[1]];
      Cell cell2 = this.cell[randomEdges[2]][randomEdges[3]];
      HashSet<Integer> setOne = (HashSet<Integer>) wallSet.get(cell1.getID());
      HashSet<Integer> setTwo = (HashSet<Integer>) wallSet.get(cell2.getID());

      // When find distinct sets, remove the edge from edgeList and update the current set.
      if (!(setOne.equals(setTwo))) {
        // add setTwo into setOne
        setOne.addAll(setTwo);
        for (Integer index : setOne) {
          wallSet.set(index, setOne);
        }
        this.allEdges.remove(randomEdges);
        count ++;

        //updating each cell
        if (randomEdges[0] < randomEdges[2] || randomEdges[0] > randomEdges[2]) {
          cell1.setSouth(cell2);
          cell2.setNorth(cell1);
        } else {
          cell1.setEast(cell2);
          cell2.setWest(cell1);
        }
      }

    }


    //for roomMaze
    if (!isPerfect) {
      while (this.allEdges.size() > remainWalls) {
        //remove edges from savedEdge
        int[] randomEdges = this.allEdges.get(random.nextInt(this.allEdges.size()));
        this.allEdges.remove(randomEdges);
      }
    }
    this.addCoins();
    this.addThief();
  }


  @Override
  public void addThief() {
    Random random = new Random();
    random.setSeed(1);
    int numOfThiefCell = (int)(THIEF_PROBABILITY * this.totalCells);
    HashSet<int[]> thiefCell = new HashSet<>();
    while (thiefCell.size() < numOfThiefCell) {
      int[] thiefItem = new int[]{random.nextInt(this.totalRow),random.nextInt(this.totalCol)};
      thiefCell.add(thiefItem);
      thiefLocationList.add(thiefItem);
    }

    for (int[] position : thiefCell) {
      this.cell[position[0]][position[1]].setThief();
    }
  }

  @Override
  public List<int[]> getThiefLoc() {
    return this.thiefLocationList;
  }

  @Override
  public void addCoins() {
    Random random = new Random();
    random.setSeed(2);
    int numOfCoinsCell = (int)(COIN_PROBABILITY * this.totalCells);
    HashSet<int[]> coinsRoom = new HashSet<>();
    while (coinsRoom.size() < numOfCoinsCell) {
      int[] coinCell = new int[]{random.nextInt(this.totalRow),random.nextInt(this.totalCol)};
      System.out.println("coin location room:" + Arrays.toString(coinCell));
      coinsRoom.add(coinCell);
      coinsLocationList.add(coinCell);
    }

    Random random1 = new Random();
    random1.setSeed(3);
    for (int[] position : coinsRoom) {
      int coins = random1.nextInt(10);
      this.cell[position[0]][position[1]].setCoins(coins);
    }
  }

  @Override
  public List<int[]> getCoinsLocation() {
    return this.coinsLocationList;
  }

}

package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Cell class. Each maze is made up of cells.
public class Cell {
  private final int[] location;
  private int cellID;
  private Thief thief;
  private Coin coinValue;
  private Cell northCell;
  private Cell southCell;
  private Cell westCell;
  private Cell eastCell;
  private boolean isVisited;
  private List<String> directions;


  // The constructor for the cell class
  public Cell(int[] location) {
    if (location[0] < 0 || location[1] < 0) {
      throw new IllegalArgumentException("No cell here.");
    }
    this.location = location;
    this.northCell = null;
    this.southCell = null;
    this.westCell = null;
    this.eastCell = null;
    this.isVisited = false;
  }


  //get the cell location
  public int[] getLocation() {
    return this.location;
  }

  //set the cell id
  public void setID(int ID) {
    this.cellID = ID;
  }

  //get the cell id
  public int getID() {
    return this.cellID;
  }


  //set the north cell
  public void setNorth(Cell northCell) {
    this.northCell = northCell;
  }

  //set the south cell
  public void setSouth(Cell southCell) {
    this.southCell = southCell;
  }

  //set the west cell
  public void setWest(Cell westCell) {
    this.westCell = westCell;
  }

  //set the east cell
  public void setEast(Cell eastCell) {
    this.eastCell = eastCell;
  }

  //get the up cell
  public Cell getNorthCell() {
    return this.northCell;
  }

  //get the down cell
  public Cell getSouthCell() {
    return this.southCell;
  }

  //get the left cell
  public Cell getWestCell() {
    return this.westCell;
  }

  //get the right cell
  public Cell getEastCell() {
    return this.eastCell;
  }

  //the cell direction
  public List<String> getDirections() {
    directions = new ArrayList<>();
    if (this.northCell != null) {
      this.directions.add("north");
    }

    if (this.southCell != null) {
      this.directions.add("south");
    }

    if (this.westCell != null) {
      this.directions.add("west");
    }

    if (this.eastCell != null) {
      this.directions.add("east");
    }

    return this.directions;
  }


  //set the thief
  public void setThief() {
    this.thief = new Thief();
  }

  //get the thief
  public Thief getThief() {
    return this.thief;
  }

  //set the coin value for the cell
  public void setCoins(int coin) {
    this.coinValue = new Coin(coin);
  }

  //get coin value for the cell
  public Coin getCoins() {
    return this.coinValue;
  }

  //remove the coins from the cell
  public void removeCoins() {
    this.coinValue = null;
  }

  @Override
  public String toString() {
    return "Cell{" +
            "cellLocation=" + Arrays.toString(location) +
            '}';
  }
}

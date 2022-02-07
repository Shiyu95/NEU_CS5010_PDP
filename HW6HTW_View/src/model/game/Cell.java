package model.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Cell class. Each maze is made up of cells.
public class Cell {
  private final int[] location;
  private int cellID;
  private Cell northCell;
  private Cell southCell;
  private Cell westCell;
  private Cell eastCell;
  private List<String> directions;
  private MonsterType monsterType;
  private List<int[]> directionLocList;
  
  public String nearby;


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
    this.directionLocList = new ArrayList<>();
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
      this.directions.add("N");
      int[] northLoc = new int[]{location[0]-1,location[1]};
      directionLocList.add(northLoc);
    }

    if (this.southCell != null) {
      this.directions.add("S");
      int[] southLoc = new int[]{location[0]+1,location[1]};
      directionLocList.add(southLoc);
    }

    if (this.westCell != null) {
      this.directions.add("W");
      int[] westLoc = new int[]{location[0],location[1]-1};
      directionLocList.add(westLoc);
    }

    if (this.eastCell != null) {
      this.directions.add("E");
      int[] eastLoc = new int[]{location[0],location[1]+1};
      directionLocList.add(eastLoc);
    }

    return this.directions;
  }

    //get the cell monster type
  public MonsterType getMonsterType() {
    return this.monsterType;
  }

  //set the bat
  public void setBat() {
    this.monsterType = MonsterType.BAT;
  }


  //set pit for the cell
  public void setPit() {
    this.monsterType = MonsterType.PIT;
  }

  public String getDirectionString()
  {
	  if(directions==null)return null;
		  String str="";
		 if(this.eastCell!=null) str+="east";
		 if(this.northCell!=null)str+="north";
		 if(this.southCell!=null)str+="south";
		 if(this.westCell!=null)str+="west";
		 return str;
  }


  @Override
  public String toString() {
    return "Cell{" +
            "cellLocation=" + Arrays.toString(location) +
            '}';
  }
}

package game;

import java.util.List;

// maze game class. when player play the game. it updates player status.
public class Game {
  private Player player;
  private final int[] endPoint;
  private int[] playerLocation;
  private final Cell[][] map;
  private boolean done = false;

 // Constrictor for the maze game
  public Game(int[] startPoint, int[] endPoint, Cell[][] map) {
    // Edge case: when start point or end point out of bound
    if (startPoint[0] < 0 || startPoint[0] >= map.length
        || startPoint[1] < 0 || startPoint[1] >= map[0].length) {
      throw new IllegalArgumentException("This start point isn't exist on the map.");
    }

    if (endPoint[0] < 0 || endPoint[0] >= map.length
        || endPoint[1] < 0 || endPoint[1] >= map[0].length) {
      throw new IllegalArgumentException("This end point isn't exist on the map.");
    }

    this.player = new Player();
    this.playerLocation = startPoint;
    this.endPoint = endPoint;
    this.map = map;
  }

 //get the play location
  public int[] getPlayerLocation() {
    return this.playerLocation;
  }

  //get player current coins
  public int getCurrentCoins() {
    return this.player.getCoins();
  }

  //get player direction options
  public List<String> getOptions() {
    return this.map[this.playerLocation[0]][this.playerLocation[1]].getDirections();
  }


  //move method for the player. it can update coins number.
  public void move(String direction) {
    if (!this.getOptions().contains(direction)) {
      throw new IllegalArgumentException("Invalid input for next direction.");
    }

    Cell currCell = this.map[getPlayerLocation()[0]][getPlayerLocation()[1]];
    Cell updateCell;
    switch (direction) {
      case "north":
        updateCell = currCell.getNorthCell();
        break;
      case "south":
        updateCell = currCell.getSouthCell();
        break;
      case "west":
        updateCell = currCell.getWestCell();
        break;
      case "east":
        updateCell = currCell.getEastCell();
        break;
      default:
        updateCell = currCell;
        System.out.println("Something's wrong, please check input");
    }
    update(updateCell);
  }

  //update all information for the player
  public void update(Cell updateCell) {
    this.playerLocation = updateCell.getLocation();

    // Check coins or not.
    if (updateCell.getCoins() != null) {
      this.player.pickUpCoins(updateCell.getCoins());
      updateCell.removeCoins();
    }

    // Check thief or not.
    if (updateCell.getThief() != null) {
      this.player.loseCoins(updateCell.getThief());
    }

    System.out.println("You have " + this.getCurrentCoins() + " coins now.");
    // Check finish or not.
    if (this.playerLocation[0] == this.endPoint[0] && this.playerLocation[1] == this.endPoint[1]) {
      this.done = true;
    }

  }

  //check player at end point or not
  public boolean done() {
    return this.done;
  }
}

package model.game;

//create player class
public class Player implements PlayerInterface {
  private int numberOfArrows;
  private PlayerStatus status;
  private int[] currentLocation;


  //Constructor for player of the maze
  //player initial status
  public Player(int numberOfArrows){
    if (numberOfArrows < 0) {
      throw new IllegalArgumentException("The num of input arrow can't be negative");
    }

    this.numberOfArrows = numberOfArrows;
    this.status = PlayerStatus.ALIVE;

  }


  //Set the current location of the player.
  @Override
  public void setCurrentLocation(int[] location) {
    currentLocation = location;

  }

  //Get player current arrows
  @Override
  public int getArrowsCount() {
    return this.numberOfArrows;
  }



  //Decrease arrow count of player by 1.
  @Override
  public void arrowCountDecrease(){
    if (numberOfArrows == 0) {
      throw new IllegalStateException("the number of Arrows is zero.");
    }
    this.numberOfArrows-- ;
  }


  //Get status of the player - Alive, dead or winner.
  @Override
  public PlayerStatus getStatus() {
    return status;
  }


  //Set status of the player - Alive, dead or winner.
  @Override
  public void setStatus(PlayerStatus status) {
    this.status = status;
  }


}

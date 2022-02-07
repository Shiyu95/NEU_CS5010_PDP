package model.game;

import model.maze.Maze;
import view.GameFrame;

import java.util.*;

// maze game class. when player play the game. it updates player status.
public class Game {
    private Player player;
    private final int[] endPoint;
    private int[] playerLocation;
    private final Cell[][] map;
    private int arrows;
    private MonsterType monsterType;
    private final Random random = new Random(32);
    private final int totalRow;
    private final int totalCol;
    
    private GameFrame view;
    private String name="player1";

    
    // Constrictor for the maze game
    public Game(int[] startPoint, int[] endPoint, Cell[][] map, int arrows, int col, int row) {
        // Edge case: when start point or end point out of bound
        if (startPoint[0] < 0 || startPoint[0] >= map.length || startPoint[1] < 0 || startPoint[1] >= map[0].length) {
            view.showMessage("This wumpus point isn't exist on the map.");
        }

        if (endPoint[0] < 0 || endPoint[0] >= map.length || endPoint[1] < 0 || endPoint[1] >= map[0].length) {
        	 view.showMessage("This wumpus point isn't exist on the map.");
        }
        this.playerLocation = new int[] {startPoint[0],startPoint[1]};//
       
        this.endPoint = endPoint;
        this.map = map;
        this.arrows = arrows;
        this.totalCol = col;
        this.totalRow = row;
        this.player = new Player(arrows);
        
        this.checkNear(map[startPoint[0]][startPoint[1]]);

    }
   
    
    public void setPlayerName(String name) {
    	this.name=name;
    }
    public void  setGameView(GameFrame view) {
    	this.view=view;
    }
    public Player getPlayer() {
        return player;
    }

    // get the play location
    public int[] getPlayerLocation() {
        return this.playerLocation;
    }

   
    public void shootArrow(String direction, int distance) {
        if (distance < 0 || player.getArrowsCount() == 0) {
           view.showMessage("Invalid arguments.");
        }
        if (!getOptions().contains(direction)) {
            player.arrowCountDecrease();
            if (player.getArrowsCount() == 0) {
                player.setStatus(PlayerStatus.LOSE);
            }

        }
        shootArrowHelper(direction, distance, playerLocation);

    }

    private void shootArrowHelper(String direction, int distance, int[] playerLocation) {
        if (distance == 0 && endPoint.equals(playerLocation)) {
        	 view.showMessage("Hee hee hee, you got the wumpus!\n");
        	 view.showMessage("Next time you won't be so lucky");
            player.setStatus(PlayerStatus.WINNER);
            player.arrowCountDecrease();
        }
        if (distance == 0 || !getOptions().contains(direction)) {
            player.arrowCountDecrease();
            if (player.getArrowsCount() == 0) {
                player.setStatus(PlayerStatus.LOSE);
                view.showMessage("Run out of arrows. "+name+" lose game");
            }
        }
        if (distance > 0 && getOptions().contains(direction)) {
            Cell tempCell = map[playerLocation[0]][playerLocation[1]];
            switch (direction) {
                case "N":

                    for (int i = 0; i < distance; i++) {
                        if (tempCell.getNorthCell() != null) {
                            tempCell = tempCell.getNorthCell();
                        } else {
                            break;
                        }
                    }
                    if (tempCell.getLocation()[0] == endPoint[0] && tempCell.getLocation()[1] == endPoint[1]) {
                        win();
                    } else {
                        player.arrowCountDecrease();
                        checkNoArrows();
                    }
                    break;

                case "S":
                    for (int i = 0; i < distance; i++) {
                        if (tempCell.getSouthCell() != null) {
                            tempCell = tempCell.getSouthCell();
                        } else {
                            break;
                        }
                    }
                    if (tempCell.getLocation()[0] == endPoint[0] && tempCell.getLocation()[1] == endPoint[1]) {
                        win();
                    } else {
                        player.arrowCountDecrease();
                        checkNoArrows();
                    }
                    break;
                case "W":
                    for (int i = 0; i < distance; i++) {
                        if (tempCell.getWestCell() != null) {
                            tempCell = tempCell.getWestCell();
                        } else {
                            break;
                        }
                    }
                    if (tempCell.getLocation()[0] == endPoint[0] && tempCell.getLocation()[1] == endPoint[1]) {
                        win();
                    } else {
                        player.arrowCountDecrease();
                        checkNoArrows();
                    }
                    break;
                case "E":
                    for (int i = 0; i < distance; i++) {
                        if (tempCell.getEastCell() != null) {
                            tempCell = tempCell.getEastCell();
                        } else {
                            break;
                        }
                    }
                    if (tempCell.getLocation()[0] == endPoint[0] && tempCell.getLocation()[1] == endPoint[1]) {
                        win();
                    } else {
                        player.arrowCountDecrease();
                        checkNoArrows();
                    }
                    break;
                default:
                	 view.showMessage("Something's wrong, please check input");
            }
        }
    }

    public void arrowMove(String direction, int numOfCaves) {
        if (!this.getOptions().contains(direction)) {
        	 view.showMessage("Invalid shooting direction, please check input");
        }
        switch (direction) {
            case "N":
                shootArrow("N", numOfCaves);
                break;
            case "S":
                shootArrow("S", numOfCaves);
                break;
            case "W":
                shootArrow("W", numOfCaves);
                break;
            case "E":
                shootArrow("E", numOfCaves);
                break;
            default:
            	 view.showMessage("Something's wrong, please check input");
        }

    }

    // get player direction options
    public List<String> getOptions() {
        return this.map[this.playerLocation[0]][this.playerLocation[1]].getDirections();
    }

  

    List<Cell> nearBy = new ArrayList<>();

    // move method for the player. it can update player status after move.
    public void move(String direction) {
        if (!this.getOptions().contains(direction)) {
        	 view.showMessage("Invalid input for next direction.");
        }

        Cell currCell = this.map[getPlayerLocation()[0]][getPlayerLocation()[1]];
        currCell.getDirections();
        Cell updateCell;
        switch (direction) {
            case "N":
                updateCell = currCell.getNorthCell();
                nearBy.add(updateCell);
                break;
            case "S":
                updateCell = currCell.getSouthCell();
                nearBy.add(updateCell);
                break;
            case "W":
                updateCell = currCell.getWestCell();
                nearBy.add(updateCell);
                break;
            case "E":
                updateCell = currCell.getEastCell();
                nearBy.add(updateCell);
                break;
            default:
                updateCell = currCell;
                view.showMessage("Something's wrong, please check input");
        }
        update(updateCell);
    }
    

    public String checkClick(int r,int c) {
    	
    	if(playerLocation[0]==r && playerLocation[1]+1==c) {
    		//E
    		if(getOptions().contains("E")) return "E";
    		
    	}
    	else if(playerLocation[0]==r && playerLocation[1]-1==c) {
    		
    		if(getOptions().contains("W")) return "W";
    	}else if(playerLocation[0]+1==r && playerLocation[1]==c) {
    		
    		if(getOptions().contains("S")) return "S";
    	}
    	else if(playerLocation[0]-1==r && playerLocation[1]==c) {
    		
    		if(getOptions().contains("N")) return "N";
    	}
    	return null;
    }
   
    // update all information for the player
    public void update(Cell updateCell) {
        this.playerLocation = updateCell.getLocation();
        updateCell.getDirections();
        // Check pits or not.
        if (updateCell.getMonsterType() == MonsterType.PIT) {
            monsterType = MonsterType.PIT;
            meetMonster(playerLocation);
        }

        // Check bat or not.
        if (updateCell.getMonsterType() == MonsterType.BAT) {
            monsterType = MonsterType.BAT;
            meetMonster(playerLocation);
        }

        // Check finish or not.
        if (this.playerLocation[0] == this.endPoint[0] && this.playerLocation[1] == this.endPoint[1]) {
            monsterType = MonsterType.WUMPUS;
            meetMonster(playerLocation);
        }
        if (arrows == 0) {
        	 view.showMessage(name+" already use all your arrows");
        }
        checkNear(updateCell);
    }

    // Meet different type of monster, what will happen
    public void meetMonster(int[] playerLocation) {
        switch (monsterType) {
            case PIT:// when meet pit, player will fall into the bottomless pit
            	 view.showMessage(name+" just fall into a bottomless pit. Hope you will get a good luck next time");
                player.setStatus(PlayerStatus.LOSE);
               // System.exit(0);
                break;

            case BAT:
                // transport by bat 50% of the time
                if (Math.random() < 0.5) {
                	 view.showMessage("Snatch -- "+name+" are grabbed by superbats and ...");
                    int[] newLocation = new int[] { random.nextInt(this.totalRow), random.nextInt(this.totalCol) };
                    System.out.println(Arrays.toString(newLocation));
                    this.playerLocation = newLocation;
                    update(map[newLocation[0]][newLocation[1]]);
                } else {
                	 view.showMessage("Whoa -- "+name+" successfully duck superbats that try to grab you ");
                    player.setCurrentLocation(playerLocation);
                }
                break;

            case WUMPUS:// meet wumpus
               // player.setStatus(PlayerStatus.LOSE);
                view.showMessage("Chomp, chomp, chomp, thanks for feeding the Wumpus!");
                view.showMessage("Better luck next time");
                player.setStatus(PlayerStatus.LOSE);
                //System.exit(0);

                //player.setCurrentLocation(playerLocation);
                break;
        }

    }

    private void checkNoArrows() {
        if (player.getArrowsCount() == 0) {
            player.setStatus(PlayerStatus.LOSE);
            view.showMessage("Run out of arrows. "+name+" lose game");
            //System.exit(0);
        }
    }

    private void win() {
    	 view.showMessage("Hee hee hee, "+name+" got the wumpus!\n");
    	 view.showMessage("Next time you won't be so lucky");
         player.setStatus(PlayerStatus.WINNER);
       // System.exit(0);
    }

    private void checkNear(Cell updateCell) {
        if (player.getStatus() == PlayerStatus.ALIVE) {
            List<Cell> nears = new ArrayList<>();
            int x = updateCell.getLocation()[0];
            int y = updateCell.getLocation()[1];
            if (x-1>=0) {
                nears.add(map[x-1][y]);
            }
            if (x+1<map.length) {
                nears.add(map[x+1][y]);
            }
            if (y-1>=0) {
                nears.add(map[x][y-1]);
            }
            if (y+1<map[0].length) {
                nears.add(map[x][y+1]);
            }
            for (Cell c : nears) {
                if (c.getMonsterType() != null) {
                    switch (c.getMonsterType()) {
                        case PIT:// when meet pit, player will fall into the bottomless pit
                            view.showMessage(name +" feel a draft");
                            updateCell.nearby="slime-pit-nearby";
                            break;

                        case BAT:
                            break;

                        default:
                        
                            break;
                    }
                }
                if (c.getLocation()[0] == endPoint[0] && c.getLocation()[1] == endPoint[1]) {
                	//view.nearby("wumpus-nearby");
                	 updateCell.nearby="wumpus-nearby";
                	 view.showMessage(name+" smell something terrible nearby");
                }
            }
        }
    }

    public Cell[][] getMap(){
    	return this.map;
    }
    
    public String getInfo() {
    	return name+ " "+player.getArrowsCount()+" arrows left";
    }
    
   
}

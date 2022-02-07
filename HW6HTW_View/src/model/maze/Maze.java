package model.maze;

import model.game.Cell;
import model.game.Player;

import java.util.List;


// Maze interface class
public interface Maze {
    //get row num
    int getTotalRow();

    //get col num
    int getTotalCol();

    //get remain wall num
    int getWallNum();

    //get all edges list
    List<int[]> getAllEdges();

    //add pit
    void addPit();

    //get pit location
    List<int[]> getPitsLocation();

    //add bat
    void addBat();

    //get bat location
    List<int[]> getBatsLoc();


    // build maze
    void buildMaze(List<int[]> allEdges, boolean isPerfect, int numOfRemainWalls);

    //get maze map
    Cell[][] getCell();
}

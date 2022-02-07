package controller;

import java.util.List;
import java.util.Scanner;

import controller.GameController;
import model.game.Player;
import model.maze.Maze;
import model.maze.RoomMaze;
import model.maze.WrappingRoomMaze;
import model.game.Game;

public class Driver {
  private static int row;
  private static int column;
  private static int remainWalls;
  private static int pitNum;
  private static int batNum;
  private static int[] startPoint;
  private static int[] endPoint;
  private static Maze maze;
  private static Game game;

  public static void main(String[] args) {
    //get user input for maze info
    Scanner scanner = new Scanner(System.in);
    System.out.println("----------  Game Start ----------");
    System.out.println("Please input the Hunt the Wumpus Maze's information.");

    System.out.print("What kind of maze do you want to create for the game? " +
            "\n1.Room Maze. 2.Wrapped Room Maze.");
    int type = scanner.nextInt();

    System.out.print("Input the row of the maze: ");
    row = scanner.nextInt();
    System.out.print("Input the column of the maze: ");
    column = scanner.nextInt();


    int remainWall = (row - 1) * column + (column - 1) * row - row * column + 1;
    switch (type){
      case 1:
        System.out.print("Remaining walls(0 - " + remainWall + "): ");
        remainWalls = scanner.nextInt();
        System.out.println("Got it! Create the room maze for you!\n ");

        System.out.print("Enter the num of pits in the maze: ");
        pitNum = scanner.nextInt();
        System.out.print("Enter the num of bats in the maze: ");
        batNum = scanner.nextInt();
        maze = new RoomMaze(row, column, remainWall, batNum, pitNum);
        break;
      case 2:
        System.out.print("Remaining walls(0 - " + remainWall + "): ");
        remainWalls = scanner.nextInt();
        System.out.println("Got it! Create the Wrapped Room Maze for you!\n ");


        System.out.print("Enter the num of pits in the maze: ");
        pitNum = scanner.nextInt();
        System.out.print("Enter the num of bats in the maze: ");
        batNum = scanner.nextInt();
        maze = new WrappingRoomMaze(row, column, remainWalls, batNum, pitNum);
        break;
    }


    int startRow;
    int startCol;
    int endRow;
    int endCol;
    System.out.print("Input a row number for a start point: ");
    startRow = scanner.nextInt();
    System.out.print("Input a column number for a start point: ");
    startCol = scanner.nextInt();
    System.out.print("Input a row number for wumpus: ");
    endRow = scanner.nextInt();
    System.out.print("Input a column number for wumpus: ");
    endCol = scanner.nextInt();
    System.out.print("Enter number of arrows for player: ");
    int arrows = scanner.nextInt();

    System.out.println("");
    System.out.println("---------- Let's play the Hunt the Wumpus maze game! ----------");
    System.out.println("---------- Game Start ----------");
    System.out.println("");
    //use user input to create start point and end point
    startPoint = new int[]{startRow, startCol};
    endPoint = new int[]{endRow, endCol};
    game = new Game(startPoint, endPoint, maze.getCell(), arrows, row, column);


    new GameController(game).playGame();
  }
}

import java.util.List;
import java.util.Scanner;
import maze.Maze;
import maze.PerfectMaze;
import maze.RoomMaze;
import maze.WrappingRoomMaze;
import game.Game;

public class Driver {
  private static int row;
  private static int column;
  private static int remainWalls;
  private static int[] startPoint;
  private static int[] endPoint;
  private static Maze maze;
  private static Game game;

  public static void main(String[] args) {
    //get user input for maze info
    Scanner scanner = new Scanner(System.in);
    System.out.println("----------  Game Start ----------");
    System.out.println("Please input the Maze's information.");

    System.out.print("What kind of maze do you want to create? " +
            "\n1.Perfect Maze. 2.Room Maze. 3.Wrapped Room Maze.");
    int type = scanner.nextInt();

    System.out.print("Input the row of the maze: ");
    row = scanner.nextInt();
    System.out.print("Input the column of the maze: ");
    column = scanner.nextInt();


    int remainWall = (row - 1) * column + (column - 1) * row - row * column + 1;
    switch (type){
      case 1:
        System.out.println("Got it! Create the perfect maze for you!");
        maze = new PerfectMaze(row, column);
        break;
      case 2:
        System.out.print("Remaining walls(0 - " + remainWall + "): ");
        remainWalls = scanner.nextInt();
        System.out.println("Got it! Create the room maze for you!");
        maze = new RoomMaze(row, column, remainWall);
        break;
      case 3:
        System.out.print("Remaining walls(0 - " + remainWall + "): ");
        remainWalls = scanner.nextInt();
        System.out.println("Got it! Create the wrapped Room Maze for you!");
        maze = new WrappingRoomMaze(row, column, remainWalls);
        break;
    }


    System.out.println("---------- Let's play the maze game! ----------");

    int startRow;
    int startCol;
    int endRow;
    int endCol;
    System.out.print("Input a row number for a start point: ");
    startRow = scanner.nextInt();
    System.out.print("Input a column number for a start point: ");
    startCol = scanner.nextInt();
    System.out.print("Input a row number for a finish point: ");
    endRow = scanner.nextInt();
    System.out.print("Input a column number for a finish point: ");
    endCol = scanner.nextInt();
    //use user input to create start point and end point
    startPoint = new int[]{startRow, startCol};
    endPoint = new int[]{endRow, endCol};
    game = new Game(startPoint, endPoint, maze.getCell());


    playGame();
  }



  //play game
  private static void playGame() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("---------- Game Start ----------");
    while (true) {
      System.out.println("You're at: [" + game.getPlayerLocation()[0] + ", "
                          + game.getPlayerLocation()[1] + "]");
      String moveOptions = "which direction do you want to go?    ";
      List<String> directions = game.getOptions();
      for (String direction : directions) {
        moveOptions += direction;
        moveOptions += "  ";
      }

      System.out.println(moveOptions);
      System.out.print("Move to: ");
      String nextMove = scanner.nextLine();

      game.move(nextMove);
      if (game.done()) {
        System.out.println("------------------------------------");
        System.out.println("WoW! You've find an exit!");
        System.out.println("------------------------------------");
        System.out.println("You've collected " + game.getCurrentCoins() + " Coins in total from the maze game.");
        System.exit(0);
      }
    }
  }
}

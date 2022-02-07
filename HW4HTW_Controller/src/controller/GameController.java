package controller;

import model.game.Game;
import model.game.Player;
import model.game.PlayerStatus;
import model.maze.Maze;

import java.util.List;
import java.util.Scanner;

public class GameController {
    private static Game game;



    public GameController( Game game) {
        this.game = game;

    }

    //play game
   public static void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (game.getPlayer().getStatus().equals(PlayerStatus.ALIVE)) {
            System.out.println("You are in cave: [" + game.getPlayerLocation()[0] + ", "
                    + game.getPlayerLocation()[1] + "]");
            String moveOptions = "Tunnels lead to the  ";
            List<String> directions = game.getOptions();
            for (String direction : directions) {
                moveOptions += direction;
                moveOptions += "  ";
            }

            System.out.println(moveOptions);
            System.out.println(" ");


            System.out.print("Shoot or Move (S-M)? ");
            String choice = scanner.nextLine();

            switch (choice){
                case "M":
                    System.out.print("Where to? ");
                    String nextMove = scanner.nextLine();

                    game.move(nextMove);

                    System.out.println(" ");
                    break;


                case "S":
                    System.out.print("No. of caves ? ");
                    int numOfCaves = Integer.valueOf(scanner.nextLine());



                    System.out.print("Toward cave? ");
                    String arrowMove = scanner.nextLine();


                    game.arrowMove(arrowMove, numOfCaves);
                    System.out.println(" ");

                    break;


            }



        }
    }
}

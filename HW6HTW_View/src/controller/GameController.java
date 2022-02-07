package controller;

import model.Setting;
import model.game.Game;
import model.game.PlayerStatus;
import model.maze.Maze;
import model.maze.RoomMaze;
import model.maze.WrappingRoomMaze;
import view.GameFrame;
import view.GameViewEvent;

import java.util.List;
import java.util.Scanner;

public class GameController implements GameViewEvent {
    private  Game game;
    private Game game2;
    private GameFrame view;
    

	private int playerNum = 1;
    private int currentPlayer = 1;
    
    public GameController( Game game) {
        this.game = game;
        
        view =new GameFrame();
        view.setGameController(this);
        game.setGameView(view);
    }

    public GameController(int playerNum) {
    	this.playerNum =playerNum;

    	Maze maze;
    	Setting s=Setting.getInstance();
    	if(s.mazeType.equals("Room")) {
    		maze=new RoomMaze(s.rows, s.columns, s.remainwall, s.bats, s.pits);//room
    	}
    	else {
    		maze=new WrappingRoomMaze(s.rows, s.columns, s.remainwall, s.bats, s.pits);//wrappedroom
    	}
    	int[] startPoint = new int[]{s.starty, s.startx};
    	int[] endPoint = new int[]{s.wpy, s.wpx};
    	this.game=new Game(startPoint, endPoint, maze.getCell(), s.arrow, s.columns, s.rows) ;//model
    	view =new GameFrame();//view
    	game.setGameView(view);
        
    	if(playerNum==2) {
    		game2=new Game(startPoint, endPoint, maze.getCell(), s.arrow, s.columns, s.rows) ;//model2
    		game2.setPlayerName("player2");
    		game2.setGameView(view);
    	}
    	
    	
    	view .setGameController(this);
    	
    	view.showInfo(game.getInfo());
    }
    
    
    
    

    //play game
   public  void playGame() {
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

   public void reFreshGameView() {
	   
	   view.updateView(game,game2);
   }


	@Override
	public void move(String target) {
		if(playerNum ==2) {
			if(currentPlayer ==1) {
				game.move(target);
				currentPlayer =2;
				view.showInfo(game.getInfo()+","+game2.getInfo()+" player2 turn");
			}
			else {
				game2.move(target);
				currentPlayer =1;
				view.showInfo(game.getInfo()+","+game2.getInfo()+"player1 turn");
			}
			
		}
		else {
			game.move(target);
			view.showInfo(game.getInfo());
		
		}
		this.reFreshGameView();
		
	}



	@Override
	public void shoot(String arrowMove, int numOfCaves) {
		if(playerNum ==2) {
			if(currentPlayer ==1) {
				game.arrowMove(arrowMove, numOfCaves);
				currentPlayer =1;
				view.showInfo("p1"+game.getInfo()+" p2"+game2.getInfo()+ " player2 turn");
			}
			else {
				game2.arrowMove(arrowMove, numOfCaves);
				currentPlayer =1;
				view.showInfo("p1"+game.getInfo()+" p2"+game2.getInfo()+ " player1 turn");
				
			}
			
		}
		else {
			game.arrowMove(arrowMove, numOfCaves);
			view.showInfo(game.getInfo());
		}
		this.reFreshGameView();
	}



	@Override
	public void restart() {
		Maze maze;
    	Setting s=Setting.getInstance();
    	if(s.mazeType.equals("Room")) {
    		maze=new RoomMaze(s.rows, s.columns, s.remainwall, s.bats, s.pits);//room
    	}
    	else {
    		maze=new WrappingRoomMaze(s.rows, s.columns, s.remainwall, s.bats, s.pits);//wrappedroom
    	}
    	int[] startPoint = new int[]{s.starty, s.startx};
    	int[] endPoint = new int[]{s.wpy, s.wpx};
    	this.game=new Game(startPoint, endPoint, maze.getCell(), s.arrow, s.columns, s.rows) ;//model
    	game.setGameView(view);
    	if(playerNum ==2) {
    		game2=new Game(startPoint, endPoint, maze.getCell(), s.arrow, s.columns, s.rows) ;//model
    		game2.setPlayerName("player2");
    		game2.setGameView(view);
    	}
    	
    	view.updateView(game,game2);
	}



	@Override
	public void exit() {
		
	}
	@Override
	public String checkClick(int r, int c) {
		String s=null;
		if(this.playerNum ==1) {
			s=this.game.checkClick(r, c);
		}
		else {
			if(currentPlayer ==1) {
				s=this.game.checkClick(r, c);
			}
			else {
				s=this.game2.checkClick(r, c);
				
			}
			
			
		}
		if(s==null)view.showMessage("invalid click");
		
		return s;
	}
}

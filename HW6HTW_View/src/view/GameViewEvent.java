package view;

public interface GameViewEvent {
	//move
	void move(String target);

	//shoot
	void shoot(String arrowMove,int numOfCaves);

	//restart
	void restart();

	//end game
	void exit();

	
	String checkClick(int r,int c) ;
}

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import model.game.Cell;
import model.game.Game;
import model.game.MonsterType;

public class GameFrame extends JFrame  implements KeyListener,CellEvent{
	/**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
    }

    
    private GameViewEvent gameController;
    public void setGameController(GameViewEvent e) {
    	this.gameController=e;
    }
                         
    private void initComponents() {

        jMenuItem1 = new JMenuItem();
        jPanel1 = new JPanel();
        btnExit = new JButton();
        btnRestart = new JButton();
        btnSetting = new JButton();
        Pane = new JPanel();
        lblInfo = new JLabel();
        jMenuItem1.setText("jMenuItem1");

        this.setTitle("Game frame");

        jPanel1.setMinimumSize(new Dimension(100, 50));
        jPanel1.setPreferredSize(new Dimension(765, 50));
        jPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        btnExit.setText("Exit");
        btnExit.setPreferredSize(new Dimension(65, 40));
        jPanel1.add(btnExit);

        btnRestart.setText("ReStart");
        btnRestart.setActionCommand("");
        btnRestart.setPreferredSize(new Dimension(97, 40));
        jPanel1.add(btnRestart);

        btnSetting.setText("Setting");
        btnSetting.setActionCommand("");
        btnSetting.setPreferredSize(new Dimension(97, 40));
        jPanel1.add(btnSetting);

		//player left arrows info
        jPanel1.add(lblInfo);
        getContentPane().add(jPanel1, BorderLayout.PAGE_START);

        //game pane
        getContentPane().add(Pane, BorderLayout.CENTER);
        
        setMaximumSize(new Dimension(880, 750));
        setMinimumSize(new Dimension(880, 750));
        setPreferredSize(new Dimension(880,700));
        this.setVisible(true);
        
        Pane.setLayout(new GridLayout(6, 8));

        btnExit.addKeyListener(this);
        btnRestart.addKeyListener(this);
        btnSetting.addKeyListener(this);
        addKeyListener(this);

		//exit button action listener
        btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

		//restart button action listener
        btnRestart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.restart();
			}
		});

		//setting button action listener
        btnSetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 SetFrame f=new SetFrame();
	                f.setVisible(true);
			}
		});
    }


    /**
     * handle key event:
     * @param event
     */
	//player move keyboard controller
    void handKey(KeyEvent event) {
    	if(event.getKeyCode()==KeyEvent.VK_RIGHT) {
    		gameController.move("E");
    	}
    	else if(event.getKeyCode()==KeyEvent.VK_UP) {
    		gameController.move("N");
    	}
    	else if(event.getKeyCode()==KeyEvent.VK_DOWN) {
    		gameController.move("S");
    	}
    	else if(event.getKeyCode()==KeyEvent.VK_LEFT) {
    		gameController.move("W");
    	}
		//player shooting keyboard controller
    	else if(event.getKeyCode()==KeyEvent.VK_E) {
    		ShootDialog d=new ShootDialog(this, true);
    		d.setDirection("E");
    		d.setVisible(true);
    		String dir=d.direction;
    		int dis=d.distance;
    		gameController.shoot(dir, dis);
    	}
    	else if(event.getKeyCode()==KeyEvent.VK_N) {
    		ShootDialog d=new ShootDialog(this, true);
    		d.setDirection("N");
    		d.setVisible(true);
    		String dir=d.direction;
    		int dis=d.distance;
    		gameController.shoot(dir, dis);
    	}
    	else if(event.getKeyCode()==KeyEvent.VK_W) {
    		ShootDialog d=new ShootDialog(this, true);
    		d.setDirection("W");
    		d.setVisible(true);
    		String dir=d.direction;
    		int dis=d.distance;
    		gameController.shoot(dir, dis);
    	}
    	else if(event.getKeyCode()==KeyEvent.VK_S) {
    		ShootDialog d=new ShootDialog(this, true);
    		d.setDirection("S");
    		d.setVisible(true);
    		String dir=d.direction;
    		int dis=d.distance;
    		gameController.shoot(dir, dis);
    	}
    }


    public void showMessage(String message) {
    	
    	JOptionPane.showMessageDialog(this, message);
    }

    
    public void showInfo(String info) {
    	lblInfo.setText(info);
    }

	//update game view for different mode: single mode, two player mode
    public void updateView(Game game,Game g2) {
    	this.Pane.removeAll();//clear all
    	Cell[][] map=game.getMap();
    	int[] playerPos=game.getPlayerLocation();//play position

    	map[playerPos[0]][playerPos[1]].getDirections();
    	int[] player2Pos=null;//player2 position
    	if(g2!=null) {
    		player2Pos=g2.getPlayerLocation();
    		map[player2Pos[0]][player2Pos[1]].getDirections();
    	}
    	
    	
        int startx=playerPos[1]-4;
        if(startx<0)startx=0;
        if(startx>map[0].length-8)startx=map[0].length-8;
        if(startx<0)startx=0;
        int starty=playerPos[0]-3;
        if(starty<0)starty=0;
        if(starty>map.length-6)starty=map.length-6;
        if(starty<0)starty=0;
        
        if(player2Pos!=null) {
        	System.out.println(player2Pos[0]+","+player2Pos[1]);
        	System.out.println(startx+","+starty);
        }
    	for(int i=0;i<6&& i+starty<map.length;i++) {
    		
    		for(int j=0;j<8&& j+startx<map[0].length;j++) {
    			Cell cell=map[i+starty][j+startx];//Corresponding cell object
    			MonsterType mtp=cell.getMonsterType();
    			
    			JCell c=new JCell(i+starty, j+startx);
    			c.setCellEvent(this);
    			String s=cell.getDirectionString();
    			if(s!=null)	{
    				//It will display after explored
    				c.setCellImage(ImageLoader.getPath(s));
    			
	    			if(mtp==MonsterType.BAT) {
	    				System.out.println("show bats");
	    				c.showMonster("bats");
	    			}else if(mtp==MonsterType.PIT) {
	    				System.out.println("show pits");
	    				c.showMonster("pit");
	    			}else if(mtp==MonsterType.WUMPUS) {
	    				System.out.println("show wumpus");
	    				c.showMonster("wumpus");
	    			}
	    			else {
						//judge nearby monster
	    				if(cell.nearby!=null) {
	    					c.showMonster(cell.nearby);
	    				}
	    				
	    			}
    			}
    			if(i+starty==playerPos[0] && j+startx==playerPos[1]) {
    				c.showPlayer();//play1
    			}
    			if(player2Pos!=null && i+starty==player2Pos[0] && j+startx==player2Pos[1]) {
    				c.showPlayer2();//play2
    			}
    			Pane.add(c);
    		}
    		
    	}

    	this.revalidate();
    	this.repaint();
    	
    }
   

    private JPanel Pane;
    private JButton btnExit;
    private JButton btnRestart;
    private JButton btnSetting;
    private JMenuItem jMenuItem1;
    private JPanel jPanel1;
    private JLabel lblInfo;
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		handKey(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void cellClick(int r, int c) {
		String s=gameController.checkClick(r,c);//Click to verify
		if(s!=null) {
			System.out.print("click to "+s);
			gameController.move(s);
		}
	}

	
          
}

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



import controller.GameController;

public class MainFrame extends JFrame implements ActionListener {
	
    public MainFrame() {
        initComponents();
    }

                       
    private void initComponents() {

        jLabel1 = new JLabel();
        lnlName = new JLabel();
        btnStart = new JButton();


        btnStartTwo = new JButton();
        jLabel1.setText("jLabel1");
        btnStartTwo.setText("Two Player Mode");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hunt the Wumpus");

        lnlName.setFont(new Font("verdana", 0, 36));
        lnlName.setHorizontalAlignment(SwingConstants.CENTER);
        lnlName.setText("Hunt the Wumpus");

        btnStart.setText("StartGame");
        
        
        //for single player
        btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameController game=new GameController(1);
				game.reFreshGameView();
				
			}
		});

        //for two player
        btnStartTwo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameController game=new GameController(2);
				game.reFreshGameView();

				
			}
		});
        btnSet=new JButton();
        btnSet.setText("Setting");
        btnSet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                SetFrame f=new SetFrame();
                f.setVisible(true);
            }
        });


        

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lnlName, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(btnSet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStartTwo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(314, 314, 314))))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lnlName, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStartTwo, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(btnSet, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        pack();
        this.setVisible(true);

    }                      

    private static MainFrame ins=null;
    
    public static MainFrame getInstance() {
    	if(ins==null) ins=new MainFrame();
    	return ins;
    }
                                        

    private JButton btnStartTwo;
    private JButton btnSet;
    private JButton btnStart;
    private JLabel jLabel1;
    private JLabel lnlName;

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("ssss");
		
	}
}

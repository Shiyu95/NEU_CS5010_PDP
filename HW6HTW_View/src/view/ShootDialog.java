package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ShootDialog extends JDialog implements KeyListener {
	 private JButton btnOK;
	    private JLabel jLabel1;
	    private JLabel lblInfo;
	    
	public String direction;
	public int distance =1;
    public ShootDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

                      
    private void initComponents() {

        btnOK = new JButton();
        jLabel1 = new JLabel();
        lblInfo = new JLabel();

       this.addKeyListener(this);
       btnOK.addKeyListener(this);
        setTitle("Shooting");

        btnOK.setText("Shoot");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel1.setText("(Direction)Press: E,S,N,W; (Distance)Press: Num");
        jLabel1.setToolTipText("");

        lblInfo.setFont(new Font("verdana", 0, 15));
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }                      

    private void btnOKActionPerformed(ActionEvent evt) {
    	this.setVisible(false);
    }


	@Override
	public void keyTyped(KeyEvent e) {
	}

	 public void setDirection(String direction) {
		this.direction = direction;
		showInfo();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		System.out.print(e.getKeyChar());
		if(e.getKeyCode()==KeyEvent.VK_E) {
			this.direction="E";
		}
		else if(e.getKeyCode()==KeyEvent.VK_N) {
			this.direction="N";
		}
		else if(e.getKeyCode()==KeyEvent.VK_S) {
			this.direction="S";
		}
		else if(e.getKeyCode()==KeyEvent.VK_W) {
			this.direction="W";
		}
		if(e.getKeyChar()>'1' && e.getKeyChar()<='9') {
			this.distance =e.getKeyChar()-'1';
		}
		showInfo();
	}
	
	void showInfo()
	{
		lblInfo.setText("Direction: "+this.direction+",dis: "+this.distance);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}                                     

    

                  
   
        
}

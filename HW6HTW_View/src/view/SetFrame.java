package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Setting;

public class SetFrame extends JFrame {
	
    public SetFrame() {
        initComponents();
    }

                          
    private void initComponents() {
    	jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        txtRows = new JTextField();
        txtCols = new JTextField();
        jLabel2 = new JLabel();
        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        txtArraw = new JTextField();
        jPanel3 = new JPanel();
        jLabel5 = new JLabel();
        txtStartX = new JTextField();
        jLabel6 = new JLabel();
        txtStartY = new JTextField();
        jPanel4 = new JPanel();
        jLabel7 = new JLabel();
        txtPits = new JTextField();
        jLabel8 = new JLabel();
        txtBats = new JTextField();
        jPanel5 = new JPanel();
        jLabel12 = new JLabel();
        cboMaze = new JComboBox<>();
        jLabel13 = new JLabel();
        txtRemainWall = new JTextField();
        jPanel6 = new JPanel();
        jLabel10 = new JLabel();
        txtWpX = new JTextField();
        jLabel11 = new JLabel();
        txtWpy = new JTextField();
        jPanel7 = new JPanel();
        btnEasy1 = new JButton();
        btnNormal = new JButton();
        btnHard = new JButton();
        btnOK = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("GameSetting");
        setMinimumSize(new Dimension(520, 500));
        setSize(new Dimension(400, 300));
        getContentPane().setLayout(new FlowLayout());

        jPanel1.setPreferredSize(new Dimension(500, 50));

        jLabel1.setText("Rows");

        jLabel2.setText("Colums");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRows, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCols, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(txtCols, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRows, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        jPanel2.setPreferredSize(new Dimension(500, 50));

        jLabel3.setText("arrows");


        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArraw, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtArraw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        jPanel3.setPreferredSize(new Dimension(500, 50));

        jLabel5.setText("StartX");


        jLabel6.setText("StartY");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStartX, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStartY, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtStartY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        jPanel4.setPreferredSize(new Dimension(500, 50));

        jLabel7.setText("PITS");


        jLabel8.setText("Bats");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPits, GroupLayout.PREFERRED_SIZE, 154,GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBats, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtBats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);

        jPanel5.setPreferredSize(new Dimension(500, 50));

        jLabel12.setText("Maze");

        cboMaze.setModel(new DefaultComboBoxModel<>(new String[] { "Room", "Warped" }));

        jLabel13.setText("remainWall");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboMaze, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRemainWall, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(txtRemainWall,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboMaze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        getContentPane().add(jPanel5);

        jPanel6.setPreferredSize(new Dimension(500, 50));

        jLabel10.setText("wumpusx");



        jLabel11.setText("wumpusy");

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWpX, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWpy, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtWpX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtWpy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel6);

        jPanel7.setPreferredSize(new Dimension(500, 50));

        btnEasy1.setText("Easy");

        btnNormal.setText("Normal");

        btnHard.setText("Hard");

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnEasy1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNormal, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHard, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnEasy1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNormal, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnHard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel7);

        btnOK.setText("OK");
        btnOK.setMaximumSize(new Dimension(200, 50));
        btnOK.setMinimumSize(new Dimension(200, 50));
        btnOK.setPreferredSize(new Dimension(200, 50));
        getContentPane().add(btnOK);
    	
        
        btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
		});
       

         btnEasy1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtArraw.setText("6");
				txtPits.setText("1");
				txtBats.setText("1");
				
			}
			
		});
         
         btnNormal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtArraw.setText("4");
				txtPits.setText("2");
				txtBats.setText("2");
			}
		});
         
	btnHard.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			txtArraw.setText("2");
			txtPits.setText("4");
			txtBats.setText("4");
		}
	});
         
      
       showSetting();
    }                      
    //show default setting for the maze game
    	private void showSetting()
    	{
    		Setting s=Setting.getInstance();
    		txtArraw.setText(s.arrow +"");
    		txtBats.setText(s.bats+"");
    		txtCols.setText(s.columns+"");
    		txtPits.setText(s.pits+"");
    		txtRows.setText(s.rows+"");
    		txtStartX.setText(s.startx+"");
    		txtStartY.setText(s.starty+"");
    		txtWpX.setText(s.wpx+"");
    		txtWpy.setText(s.wpy+"");
    		txtRemainWall.setText(s.remainwall+"");
    		if("Wrapped".equals(s.mazeType))cboMaze.setSelectedIndex(1);
    		
    	}

        //save method for save button
    	private void save() {
    		System.out.println("save setting");
    		Setting s=Setting.getInstance();
    		s.arrow =Integer.parseInt(txtArraw.getText());
    		s.bats=Integer.parseInt(txtBats.getText());
    		s.pits=Integer.parseInt(txtPits.getText());
    		s.rows=Integer.parseInt(txtRows.getText());
    	    s.startx=Integer.parseInt(txtStartX.getText());
    	    s.starty=Integer.parseInt(txtStartY.getText());
    		
    		s.wpx=Integer.parseInt(txtWpX.getText());
    		s.wpy=Integer.parseInt(txtWpy.getText());

    		
    		s.columns=Integer.parseInt(txtCols.getText());
    		s.remainwall=Integer.parseInt(txtRemainWall.getText());
    		s.mazeType=cboMaze.getSelectedIndex()==0?"Room":"Wrapped";
    		
    		System.out.println("start "+s.startx+","+s.starty+" wp "+s.wpx+","+s.wpy);
    		this.dispose();
    		
    	}
   
    	 private JButton btnEasy1;
    	    private JButton btnHard;
    	    private JButton btnNormal;
    	    private JButton btnOK;
    	    private JComboBox<String> cboMaze;
    	    private JLabel jLabel1;
    	    private JLabel jLabel10;
    	    private JLabel jLabel11;
    	    private JLabel jLabel12;
    	    private JLabel jLabel13;
    	    private JLabel jLabel2;
    	    private JLabel jLabel3;

    	    private JLabel jLabel5;
    	    private JLabel jLabel6;
    	    private JLabel jLabel7;
    	    private JLabel jLabel8;

    	    private JPanel jPanel1;
    	    private JPanel jPanel2;
    	    private JPanel jPanel3;
    	    private JPanel jPanel4;
    	    private JPanel jPanel5;
    	    private JPanel jPanel6;
    	    private JPanel jPanel7;

    	    private JTextField txtArraw;
    	    private JTextField txtBats;
    	    private JTextField txtCols;
    	    private JTextField txtPits;
    	    private JTextField txtRemainWall;
    	    private JTextField txtRows;
    	    private JTextField txtStartX;
    	    private JTextField txtStartY;
    	    private JTextField txtWpX;
    	    private JTextField txtWpy;
}

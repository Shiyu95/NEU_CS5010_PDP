package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This class represents a JPanel of the maze-grid view.
 * It represents the corresponding row and column of the maze, and the image for that cell.
 */
public class JCell extends JPanel implements MouseListener {
    private final JLabel bg;
    private final JLabel player;
    private final JLabel monster;
    private final int row;
    private final int col;
    private String path;


    private CellEvent event;

    //Constructor  for JCell.
    public JCell(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        this.setSize(new Dimension(100, 100));
        this.setPreferredSize(new Dimension(100, 100));
        this.path = "";
        setBackground(new Color(229, 229, 229));
        this.setLayout(new OverlayLayout(this));

        bg = new JLabel();
        bg.setPreferredSize(this.getPreferredSize());
        monster = new JLabel();
        monster.setPreferredSize(new Dimension(50, 50));
        player = new JLabel();
        player.setPreferredSize(new Dimension(15, 32));

        bg.setAlignmentX(0.4f);
        add(player);
        add(monster);
        add(bg);
        this.addMouseListener(this);
        bg.addMouseListener(this);
        player.addMouseListener(this);
        monster.addMouseListener(this);

    }

    /**
     * Sets the image of the cell.
     * @param path : the path of the image for the cell
     */
    public void setCellImage(String path) {
        try {
            this.path = path;
            Icon icon = new ImageIcon(ImageIO.read(new File(path))
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            bg.setIcon(icon);
            revalidate();
            repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //show player image
    public void showPlayer() {
        try {
            System.out.println("show player");
            Icon icon = new ImageIcon(ImageIO.read(new File("./res/player.png"))
                    .getScaledInstance(15, 32, Image.SCALE_SMOOTH));

            player.setIcon(icon);
            revalidate();
            repaint();
        } catch (Exception e) {
            //handle exception
            e.printStackTrace();
        }
    }



    //two player mode, show second player image
    public void showPlayer2() {
        try {
            System.out.println("show player2");
            Icon icon = new ImageIcon(ImageIO.read(new File("res/target.png"))
                    .getScaledInstance(15, 32, Image.SCALE_SMOOTH));

            player.setIcon(icon);
            revalidate();
            repaint();
        } catch (Exception e) {
            //handle exception
            e.printStackTrace();
        }
    }

    //meet different monster, show monster image
    public void showMonster(String name) {
        try {
            System.out.println("show monster: " + name);

            Icon icon = new ImageIcon(ImageIO.read(new File("./res/" + name + ".png"))
                    .getScaledInstance(50, 50, Image.SCALE_SMOOTH));

            monster.setIcon(icon);
            revalidate();
            repaint();
        } catch (Exception e) {
            //handle exception
            e.printStackTrace();
        }
    }

    //when it has a monster nearby, show sign
    public void showNear(String name) {
        try {
            System.out.println("show monster");

            Icon icon = new ImageIcon(ImageIO.read(new File("./res/" + name + ".png"))
                    .getScaledInstance(50, 50, Image.SCALE_SMOOTH));

            monster.setIcon(icon);
            revalidate();
            repaint();
        } catch (Exception e) {
            //handle exception
            e.printStackTrace();
        }
    }



    void setCellEvent(CellEvent e) {
        this.event = e;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        event.cellClick(row, col);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
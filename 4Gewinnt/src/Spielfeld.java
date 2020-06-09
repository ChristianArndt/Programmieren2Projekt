import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class Spielfeld {
    // Verknüpfungen
    Spielmechanik gameMech = new Spielmechanik();
    ImageManager images = new ImageManager();
    //
    JFrame frame;
    JLabel[][] feld = new JLabel[7][7];
    JPanel topMenu = new JPanel();
    JPanel bottomMenu = new JPanel();
    JPanel feldPanel = new JPanel();
    // Buttons
    JButton spalte1 = new JButton("Spalte 1");
    JButton spalte2 = new JButton("Spalte 2");
    JButton spalte3 = new JButton("Spalte 3");
    JButton spalte4 = new JButton("Spalte 4");
    JButton spalte5 = new JButton("Spalte 5");
    JButton spalte6 = new JButton("Spalte 6");
    JButton spalte7 = new JButton("Spalte 7");

    Spielfeld() {
        // Frame initializion
        spalte1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setzeChip(0);

            }
        });
        spalte2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setzeChip(1);

            }
        });
        spalte3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setzeChip(2);

            }
        });
        spalte4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setzeChip(3);

            }
        });
        spalte5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setzeChip(4);

            }
        });
        spalte6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setzeChip(5);

            }
        });
        spalte7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setzeChip(6);

            }
        });
        frame = new JFrame("4 Gewinnt");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);
        createFeld();
        images.loadandresize();

    }

    public static void main(String[] a) {

        new Spielfeld();
    }

    public void createFeld() {
        feldPanel.setLayout(new GridLayout(7, 7));
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                feld[i][j] = new JLabel(" ");
                feld[i][j].setOpaque(true);
                feld[i][j].setBackground(Color.white);
                feld[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                feld[i][j].setPreferredSize(new Dimension(8, 8));
                feldPanel.add(feld[i][j]);
            }
        }
        updateWindow();
    }

    public void updateWindow() {

        frame.add(topMenu, BorderLayout.NORTH);
        frame.add(feldPanel, BorderLayout.CENTER);
        frame.add(bottomMenu, BorderLayout.SOUTH);
        bottomMenu.add(spalte1);
        bottomMenu.add(spalte2);
        bottomMenu.add(spalte3);
        bottomMenu.add(spalte4);
        bottomMenu.add(spalte5);
        bottomMenu.add(spalte6);
        bottomMenu.add(spalte7);
        topMenu.add(new JButton("restart/clear"));
        topMenu.add(new JButton("back to menu"));
    }

    public void setzeChip(int y) {
        System.out.println(y);
        
        for (int i = 6 ; i >= 0; i--) {
            if (hatChip(i, y) == false){
                feld[i][y].setText("T");
                break;
            }
            
        }
        frame.repaint();
    }

    public boolean hatChip(int x, int y) {
        if (feld[x][y].getText().equals(" ")) {
            return false;

        } else {
            return true;
        }
    }

}

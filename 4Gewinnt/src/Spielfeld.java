import java.awt.*;
import javax.swing.*;

public class Spielfeld {
    JFrame frame;
    JLabel[] feld;

    Spielfeld() {
        //Frame initializion
        frame = new JFrame("4 Gewinnt");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(7,7));

        createFeld();
    } //End MainSnake

    public static void main(String[]a) {

        new Spielfeld();
    } //End main

    public void createFeld(){
        int a = 0;
        int i;
        feld = new JLabel[49];
        for (i = 0; i < 49; i++){
            feld[i]= new JLabel("");
            feld[i].setOpaque(true);
            feld[i].setBackground(Color.white);
            feld[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            feld[i].setPreferredSize(new Dimension(10,10));
            frame.add(feld[i],BorderLayout.CENTER);
            }
        }
}
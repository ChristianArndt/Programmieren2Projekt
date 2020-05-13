import javax.swing.*;
import java.awt.Graphics;

public class Spielfeld {

   // JFrame.Label[][] feld;
    public static void main(String[] args) {
        /*
        int[][] feld = new int[6][6];
        //Window
        JFrame frame = new JFrame("4 Gewinnt");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setLayout(new GridLayout(7,7 ));
        */
    }

    public void createFeld(Graphics g)
    {
        g.drawString("4 Gewinnt",10,10);
    }


}

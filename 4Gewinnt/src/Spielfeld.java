import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class Spielfeld implements ActionListener {
    // Verknüpfungen
    Spielmechanik gameMech = new Spielmechanik();
    JFrame frame;
    JLabel[] feld;
    JPanel topMenu = new JPanel();
    JPanel bottomMenu = new JPanel();
    JPanel feldPanel = new JPanel();
    // Buttons
    JButton[] spaltenArray = new JButton[7];

    // Icons einfügen
    Image img1;
    Image img2;
  

    Spielfeld() {
        // Frame initializion
        frame = new JFrame("4 Gewinnt");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        createFeld();

        try {
            img1 = ImageIO.read(new File("4Gewinnt\\images\\redcircle.png"));
            img2 = ImageIO.read(new File("4Gewinnt\\images\\yellowcircle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] a) {

        new Spielfeld();
    }

    public void createFeld() {

        feld = new JLabel[49];
        feldPanel.setLayout(new GridLayout(7, 7));
        for (int i = 0; i < 49; i++) {
            feld[i] = new JLabel(" ");
            feld[i].setOpaque(true);
            feld[i].setBackground(Color.white);
            feld[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            feld[i].setPreferredSize(new Dimension(8, 8));
            feldPanel.add(feld[i]);
        }
        for (int i = 0; i < 7; i++)

        {
            spaltenArray[i] = new JButton("Button");
        }

        updateWindow();
    }

    public void updateWindow() {

        frame.add(topMenu, BorderLayout.NORTH);
        frame.add(feldPanel, BorderLayout.CENTER);
        frame.add(bottomMenu, BorderLayout.SOUTH);
        spaltenArray[0].addActionListener(this);
        for (int i = 0; i < spaltenArray.length; i++) {
            bottomMenu.add(spaltenArray[i]);

        }
        topMenu.add(new JButton("restart/clear"));
        topMenu.add(new JButton("back to menu"));
    }

    @Override
    public void actionPerformed(ActionEvent x) {
        if (x.getSource() == spaltenArray[0]) {
            for (int i = 0; i < 49; i++) {
                if (feld[i].getText() == " ") {
                    feld[i].setText("T");
                }
            }
        }
    }
}

import javax.swing.*;
import java.awt.*;

public class Menu {
    public static void main(String[] args) {
        //Window
        JFrame frame = new JFrame("4 Gewinnt");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Menü
        JLabel gameName = new JLabel("4 Gewinnt");
        JButton newGame = new JButton("Create Lobby");
        JButton joinGame = new JButton("Join Lobby");


        //GridBagLayout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints contain = new GridBagConstraints();
        //Einteilung
        contain.fill = GridBagConstraints.HORIZONTAL;
        contain.insets = new Insets(3,3,3,3);
        contain.gridx = 0;
        contain.gridy = 0;
        contain.gridwidth = 1;
        frame.getContentPane().add(gameName, contain);
        //Create Lobby Button
        contain.gridx = 0;
        contain.gridy = 1;
        contain.gridwidth = 1;
        frame.getContentPane().add(newGame,contain);
        //Join Lobby Button
        contain.gridx = 0;
        contain.gridy = 2;
        contain.gridwidth = 2;
        frame.getContentPane().add(joinGame,contain);

    }
}

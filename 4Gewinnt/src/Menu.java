import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Menu extends JFrame implements ActionListener {
    //Menü
    JLabel gameName = new JLabel("4 Gewinnt");
    JLabel letzterGewinner = new JLabel("Letzter Gewinner: Keiner");
    JButton newGame = new JButton("Create Lobby");
    JButton joinGame = new JButton("Join Lobby");
    //Variablen
    Spielfeld game;
    SaveWinner sW = new SaveWinner();
    Menu() {
        createMenu();
        newGame.addActionListener(this);
        joinGame.addActionListener(this);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game = new Spielfeld();
                    game.serverstart();
                   
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (NotBoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    game = new Spielfeld();
                    game.clientstart();
                    
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (NotBoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
    public void createMenu(){
        //Window
        JFrame frame = new JFrame("4 Gewinnt");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

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
        //Letzter Gewinner
        contain.gridx = 0;
        contain.gridy = 3;
        contain.gridwidth = 3;
        frame.getContentPane().add(letzterGewinner,contain);
        //Liest lastWinner.txt aus
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("lastWinner.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                letzterGewinner.setText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

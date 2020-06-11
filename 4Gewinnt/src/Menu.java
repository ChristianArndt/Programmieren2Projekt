import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Menu extends JFrame implements ActionListener {
    //Menü
    JLabel gameName = new JLabel("4 Gewinnt");
    JButton newGame = new JButton("Create Lobby");
    JButton joinGame = new JButton("Join Lobby");

    Menu() {
        createMenu();
        newGame.addActionListener(this);
        joinGame.addActionListener(this);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Server startServer = new Server();
                    Spielfeld game = new Spielfeld();
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
                    //Server startServer = new Server();
                    Spielfeld game = new Spielfeld();
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

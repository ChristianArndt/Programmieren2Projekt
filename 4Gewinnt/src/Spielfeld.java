import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class Spielfeld extends UnicastRemoteObject implements CSInterface{
    // Verknüpfungen
    Spielmechanik gameMech = new Spielmechanik();
    ImageManager images = new ImageManager();

    //
    JFrame frame;
    Zelle[][] feld = new Zelle[7][7];
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

    boolean gelbxrot; // true = gelb, false = rot

    Spielfeld() throws RemoteException {
        super();
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
    public void serverstart() throws RemoteException, MalformedURLException, NotBoundException {
            Registry registry = LocateRegistry.createRegistry(5099);
            registry.rebind("4gewinnt",  new Spielfeld());
            System.out.println("Server wurde gestartet");
    }

    public void clientstart() throws RemoteException, NotBoundException, MalformedURLException {
        CSInterface service = (CSInterface) Naming.lookup("rmi://localhost:5099/4gewinnt");
        System.out.println("Client hinzugefügt");
    }

    public static void main(String[] a) throws RemoteException {

        new Spielfeld();
    }

    public void createFeld() {
        feldPanel.setLayout(new GridLayout(7, 7));
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                feld[i][j] = new Zelle();
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

        for (int i = 6; i >= 0; i--) {
            if (hatChip(i, y) == false) {

                if (gelbxrot) {
                    feld[i][y].setIcon(images.img2);
                    feld[i][y].Farbe = "gelb";
                } else {
                    feld[i][y].setIcon(images.img1);
                    feld[i][y].Farbe = "rot";
                }
                feld[i][y].setHorizontalAlignment(Zelle.CENTER);
                gelbxrot = !gelbxrot;
                System.out.println(getGewinner());
                break;
            }

        }
        frame.repaint();
    }

    public boolean hatChip(int x, int y) {
        if (feld[x][y].getIcon() == null) {
            return false;

        } else {
            return true;
        }
    }

    public int getGewinner() {
        // Gewinnbedingung
        // -1 : keiner Gewinnt, noch nicht gewonnen
        // 0 : Unentschieden
        // 1 : Spieler Eins hat gewonnen(rot)
        // 2 : Spieler Zwei hat gewonnen(gelb)
        // y= spalte

        // Überprüft die Zeilen (x) ob gewonnen wurde
        for (int x = 0; x < feld[0].length; x++) {
            Zelle[] zeile = feld[x];
            int anzahlRote = 0;
            int anzahlGelb = 0;
            for (int y = 0; y < feld.length; y++) {
                Zelle zelle = zeile[y];
                if (zelle.istRot()) {

                    anzahlRote++;
                    anzahlGelb = 0;
                } else if (zelle.istGelb()) {
                    anzahlGelb++;
                    anzahlRote = 0;
                } else {
                    // Zelle ist leer
                    anzahlRote = 0;
                    anzahlGelb = 0;
                }

                if (anzahlRote == 4) {
                    return 1;
                } else if (anzahlGelb == 4) {
                    return 2;
                }

            }

        }

        // Überprüft die Spalten (y) ob gewonnen wurde

        for (int y = 0; y < feld.length; y++) {
            int anzahlRote = 0;
            int anzahlGelb = 0;
            for (int x = 0; x < feld[0].length; x++) {
                Zelle zelle = feld[x][y];
                if (zelle.istRot()) {

                    anzahlRote++;
                    anzahlGelb = 0;
                } else if (zelle.istGelb()) {
                    anzahlGelb++;
                    anzahlRote = 0;
                } else {
                    // Zelle ist leer
                    anzahlRote = 0;
                    anzahlGelb = 0;
                }

                if (anzahlRote == 4) {
                    return 1;
                } else if (anzahlGelb == 4) {
                    return 2;
                }
            }
        }
        // Überprüft die Diagonalen ob gewonnen wurde

        // Oben links --> unten rechts

        int WIDTH = feld[0].length;
        int HEIGHT = feld.length;
        for (int k = 0; k <= WIDTH + HEIGHT - 2; k++) {
            int anzahlRote = 0;
            int anzahlGelb = 0;
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < HEIGHT && j < WIDTH) {
                    Zelle zelle = feld[i][j];

                    if (zelle.istRot()) {

                        anzahlRote++;
                        anzahlGelb = 0;
                    } else if (zelle.istGelb()) {
                        anzahlGelb++;
                        anzahlRote = 0;
                    } else {
                        // Zelle ist leer
                        anzahlRote = 0;
                        anzahlGelb = 0;
                    }

                    if (anzahlRote == 4) {
                        return 1;
                    } else if (anzahlGelb == 4) {
                        return 2;
                    }

                }
            }

        }
        // Unten links --> oben rechts

        WIDTH = feld[0].length;
        HEIGHT = feld.length;
        for (int k = 0; k <= WIDTH + HEIGHT - 2; k++) {
            int anzahlRote = 0;
            int anzahlGelb = 0;
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < HEIGHT && j < WIDTH) {
                    Zelle zelle = feld[HEIGHT - 1 - i][j];

                    if (zelle.istRot()) {

                        anzahlRote++;
                        anzahlGelb = 0;
                    } else if (zelle.istGelb()) {
                        anzahlGelb++;
                        anzahlRote = 0;
                    } else {
                        // Zelle ist leer
                        anzahlRote = 0;
                        anzahlGelb = 0;
                    }

                    if (anzahlRote == 4) {
                        return 1;
                    } else if (anzahlGelb == 4) {
                        return 2;
                    }

                }
            }

        }
        int volleZellen = 0;
        for (int x = 0; x < feld[0].length; x++) {
            for (int y = 0; y < feld.length; y++) {
                Zelle zelle = feld[x][y];
                
                if (zelle.istRot()||zelle.istGelb()){
                    volleZellen ++;
                }

            }
        }
        if (volleZellen == feld.length * feld[0].length )
        {
            return 0; //Spiel geht unentschieden aus 
        }


        return -1; // noch keiner hat gewonnen

    }

}

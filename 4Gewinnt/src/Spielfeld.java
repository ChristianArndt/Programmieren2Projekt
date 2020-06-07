import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class Spielfeld implements  ActionListener{
    //Verknüpfungen
    Spielmechanik gameMech = new Spielmechanik();
    ImageManager images = new ImageManager();
    //
    JFrame frame;
    JLabel[][] feld = new JLabel[7][7];
    JPanel topMenu = new JPanel();
    JPanel bottomMenu = new JPanel();
    JPanel feldPanel = new JPanel();
    //Buttons
    JButton spalte1 = new JButton("Button");
    JButton spalte2 = new JButton("Button");
    JButton spalte3 = new JButton("Button");
    JButton spalte4 = new JButton("Button");
    JButton spalte5 = new JButton("Button");
    JButton spalte6 = new JButton("Button");
    JButton spalte7 = new JButton("Button");


    Spielfeld() {
        //Frame initializion
        frame = new JFrame("4 Gewinnt");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        createFeld();
        images.loadandresize();


    }

    public static void main(String[]a) {

        new Spielfeld();
    }

    public void createFeld(){
        feldPanel.setLayout(new GridLayout(7,7));
        for (int i = 0; i < feld.length; i++){
            for(int j = 0; j < feld[i].length; j++){
                feld[i][j]= new JLabel(" ");
                feld[i][j].setOpaque(true);
                feld[i][j].setBackground(Color.white);
                feld[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                feld[i][j].setPreferredSize(new Dimension(8,8));
                feldPanel.add(feld[i][j]);
                }
            }
        updateWindow();
    }
    public void updateWindow()
    {
   
        frame.add(topMenu, BorderLayout.NORTH);                                        
        frame.add(feldPanel, BorderLayout.CENTER);
        frame.add(bottomMenu, BorderLayout.SOUTH);
        spalte1.addActionListener(this);
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
    @Override
    public void actionPerformed(ActionEvent x) {
        if(x.getSource() == spalte1){
            for (int i = 0; i < feld.length; i++) {
                for(int j = 0; j < feld[i].length; j++){
                    if(feld[0][0].getIcon() == null)
                    {
                        feld[0][0].setIcon(images.img2);
                    }
                }
            }
        }
    }
}


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Spielfeld implements  ActionListener{
    //Verknüpfungen
    Spielmechanik gameMech = new Spielmechanik();
    JFrame frame;
    JLabel[] feld;
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
    }

    public static void main(String[]a) {

        new Spielfeld();
    }

    public void createFeld(){
        int i;
        feld = new JLabel[49];
        feldPanel.setLayout(new GridLayout(7,7));
        for (i = 0; i < 49; i++){
            feld[i]= new JLabel(" ");
            feld[i].setOpaque(true);
            feld[i].setBackground(Color.white);
            feld[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            feld[i].setPreferredSize(new Dimension(8,8));
            feldPanel.add(feld[i]);
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
            for (int i = 0; i < 49; i++) {
                    if(feld[i].getText() == " ")
                    {
                        feld[i].setText("T");
                    }
                }
            }
        }
    }


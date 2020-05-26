import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Spielfeld {
    JFrame frame;
    JLabel[] feld;
    JPanel topMenu = new JPanel();
    JPanel bottomMenu = new JPanel();
    JPanel feldPanel = new JPanel();
    

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
            feld[i]= new JLabel("");
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
        bottomMenu.add(new JButton("klick "));
        bottomMenu.add(new JButton("klick "));
        bottomMenu.add(new JButton("klick "));
        bottomMenu.add(new JButton("klick "));
        bottomMenu.add(new JButton("klick "));
        bottomMenu.add(new JButton("klick "));
        bottomMenu.add(new JButton("klick "));
        topMenu.add(new JButton("restart/clear"));
        topMenu.add(new JButton("back to menu"));
    }

}

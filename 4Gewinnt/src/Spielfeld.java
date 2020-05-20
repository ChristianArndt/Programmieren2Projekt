import javax.swing.*;
import java.awt.*;

public class Spielfeld extends JPanel {

    public static void main(String[] args) {
        Spielfeld feld = new Spielfeld();
        JFrame app = new JFrame("4 Gewinnt");
        app.add(feld, BorderLayout.CENTER);
        app.setSize(300, 300);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(100, 50, 100, 100);

    }


}

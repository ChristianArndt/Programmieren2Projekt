import java.awt.*;

import javax.swing.JLabel;

public class Zelle extends JLabel {

    public String Farbe = "";

    public Zelle() {
        super();
       
    }

    public boolean istRot() {
        return Farbe.equals("rot");
    }

    public boolean istGelb() {
        return Farbe.equals("gelb");
    }

}
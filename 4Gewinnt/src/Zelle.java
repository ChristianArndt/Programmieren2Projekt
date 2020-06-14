import java.awt.*;

import javax.swing.JLabel;

/**
 * Sendet die Farben als return zurück
 */
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
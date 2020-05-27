import javax.swing.*;

public class Spielmechanik {

    public static void main(String[] args) {

    }
    void clearFeld() {
        Spielfeld spielFeld = new Spielfeld();
        for(int i = 0; i < 49; i++)
        {
            spielFeld.feld[i] = new JLabel(" ");
        }
    }
    void istSpalteLeer() {
        Spielfeld spielFeld = new Spielfeld();
        for (int i = 0; i < 49; i++) {
            if(spielFeld.feld[i].getText() == " ")
            {
                spielFeld.feld[0].setText("T");
            } else if(!(spielFeld.feld[i].getText() == " ")){ System.out.println("Kein leeres Feld gefunden"); }
        }
    }
}

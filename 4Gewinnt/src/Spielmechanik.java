import javax.swing.*;

public class Spielmechanik {

    public static void main(String[] args) {

    }
    void clearFeld() {
        Spielfeld spielFeld = new Spielfeld();
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; i < 7; i++) {
                spielFeld.feld[i][j] = new JLabel(" ");
            }
        }
    }
    void istSpalteLeer() {
        Spielfeld spielFeld = new Spielfeld();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; i < 7; i++) {
                if (spielFeld.feld[i][j].getText() == " ") {
                    spielFeld.feld[0][0].setText("T");
                } else if (!(spielFeld.feld[i][j].getText() == " ")) {
                    System.out.println("Kein leeres Feld gefunden");
                }
            }
        }
    }
}

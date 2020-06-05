import javax.swing.*;

public class Spielmechanik {

    public static void main(String[] args) {

    }

    void clearFeld() {
        Spielfeld spielFeld = new Spielfeld();
        for (int i = 0; i < spielFeld.feld.length; i++) {
            for (int j = 0; j < spielFeld.feld[i].length; j++) {
                spielFeld.feld[i][j] = new JLabel(" ");
            }

        }
    }

    void istSpalteLeer() {
        Spielfeld spielFeld = new Spielfeld();
        for (int i = 0; i < spielFeld.feld.length; i++) {
            for (int j = 0; j < spielFeld.feld[i].length; j++) {
                if (spielFeld.feld[i][j].getText() == " ") {
                    spielFeld.feld[0][j].setText("T");
                } else if (!(spielFeld.feld[i][j].getText() == " ")) {
                    System.out.println("Kein leeres Feld gefunden");
                }

            }
        }
    }
}

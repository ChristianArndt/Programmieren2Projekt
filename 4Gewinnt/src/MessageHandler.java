import javax.swing.*;

/**
 * Sendet eine Nachricht an die Spieler ob gewonnen oder unentschieden
 */
public class MessageHandler {
    SaveWinner sW = new SaveWinner();

    public void sendWinMsg(String winner)
    {
        if(winner == "gelb")
        {
            JOptionPane.showConfirmDialog(null, "Spieler gelb hat gewonnen!", "Winner",JOptionPane.PLAIN_MESSAGE);
            sW.saveWinner("Der Spieler gelb hat als letztes gewonnen!");
            System.exit(0);
        }
        else if(winner == "rot")
        {
            JOptionPane.showMessageDialog(null, "Spieler rot hat gewonnen!","Winner",JOptionPane.PLAIN_MESSAGE);
            sW.saveWinner("Der Spieler rot hat als letztes gewonnen!");
            System.exit(0);
        }
    }
    public void sendDrawMsg()
    {
        JOptionPane.showConfirmDialog(null, "Das Board ist voll, das Spiel ist unentschieden!", "Unentschieden",JOptionPane.PLAIN_MESSAGE);
        sW.saveWinner("Das letzte Spiel ging unentschieden aus!");
        System.exit(0);
    }
}

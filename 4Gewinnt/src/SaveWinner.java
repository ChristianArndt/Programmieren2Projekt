import javax.swing.*;
import java.io.*;
import java.rmi.RemoteException;
/**
 *  Speicherung in .txt Datei
 */
public class SaveWinner {
    //Speichert letzten Gewinner in einer Datei
    public void saveWinner(String winner) {
        File file = new File("lastWinner.txt");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(winner);
            writer.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}

import javax.swing.*;
import java.io.*;
import java.rmi.RemoteException;

public class SaveWinner {


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

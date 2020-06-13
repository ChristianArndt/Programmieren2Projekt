import java.rmi.RemoteException;

public class RunClass implements Runnable {
    Spielfeld game;
    public RunClass(Spielfeld g) throws RemoteException {
        game = g;
    }

    public void run(){

        while (true) {
            try {
                int letzterChip = game.service.chipGesetzt();
                if(letzterChip != -1)
                {
                    game.setzeChip(letzterChip);
                    game.service.resetChip();
                }
                Thread.sleep(1000);
            } catch (InterruptedException | RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}

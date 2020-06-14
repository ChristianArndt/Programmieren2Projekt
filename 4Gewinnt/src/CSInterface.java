import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface zwischen Client und Server
 */
public interface CSInterface extends Remote {
    public void setzeChip(int y) throws RemoteException;
    public int chipGesetzt() throws RemoteException;
    public void resetChip() throws RemoteException;

    
}


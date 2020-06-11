import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CSInterface extends Remote {
    public void setzeChip(int y) throws RemoteException;
}

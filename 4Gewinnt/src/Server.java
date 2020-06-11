import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    Server() throws RemoteException, MalformedURLException, NotBoundException {
        Registry registry = LocateRegistry.createRegistry(5099);
        registry.rebind("4gewinnt",  new Spielfeld());
        System.out.println("Server wurde gestartet");
    }
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        Server server = new Server();

    }
}

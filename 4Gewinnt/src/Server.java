import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    Server() throws RemoteException, MalformedURLException, NotBoundException {
        Registry registry = LocateRegistry.createRegistry(49153);
        registry.rebind("4gewinnt",  new Spielfeld());
        System.out.println("Server wurde gestartet");
    }
    
}

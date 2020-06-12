import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {

    Client() throws RemoteException, NotBoundException, MalformedURLException {
        CSInterface service = (CSInterface) Naming.lookup("rmi://localhost:49153/4gewinnt");
        System.out.println("Client hinzugefügt");
    }
    
}

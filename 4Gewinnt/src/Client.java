import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {

    Client() throws RemoteException, NotBoundException, MalformedURLException {
        CSInterface service = (CSInterface) Naming.lookup("rmi://localhost:5099/4gewinnt");
        System.out.println("Client hinzugefügt");
    }
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {


    }
}

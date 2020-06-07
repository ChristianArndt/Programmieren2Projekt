import java.net.InetSocketAddress;
import java.net.Socket;

public class VierGewinntClient {
	
	public static void main(String[] args) {
		VierGewinntClient client = new VierGewinntClient("localhost", 8000);
		
	} 
	
	private InetSocketAddress address;
	
	public VierGewinntClient(String hostname, int port) {
		address = new InetSocketAddress(hostname, port);
		
	}
	
	public void run() {				//funktion des Clients
		
		try {
		System.out.println("[Client] Verbidung wird aufgabaut...");
		Socket socket = new Socket();
		socket.connect(address, 5000);
		System.out.println("[Client] Verbidung hergstellt...");
		
		socket.close();
		
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}


import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.*;

public class VierGewinntServer {

	
	
		private int port;
		
		public VierGewinntServer (int port) {
			this.port = port;
			
		}
		public void startListening() {
			
			new Thread(new Runnable() {

				@Override
				public void run() {         //was soll der Sercer tun
					
					try {
						System.out.println("[Server] Server wird gestartet");
						ServerSocket serverSocket = new ServerSocket(port);
						System.out.println("[Server] Serververbindung wird hergestellt");
						Socket remoteClientSocket = serverSocket.accept();
						System.out.println("[Server] Verbidung mit Client hergstellt" + remoteClientSocket.getRemoteSocketAddress());
						remoteClientSocket.close();
						serverSocket.close();
						
						
					} catch(Exception e) {
						e.printStackTrace();
					}
							
					
				}
			}).start();
			
			}
		

	
}

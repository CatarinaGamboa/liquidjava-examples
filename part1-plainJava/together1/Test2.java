import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Test2 {
	
	public void createSocket(InetSocketAddress addr) throws IOException{
		int port = 5000;
		InetAddress inetAddress = InetAddress.getByName("localhost");    
		
		Socket socket = new Socket();
		socket.bind(new InetSocketAddress(inetAddress, port));
     		socket.sendUrgentData(90);
		socket.close();
	}

}

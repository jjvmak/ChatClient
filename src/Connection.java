import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
	
	
	private static ObjectOutput output;
	private static ObjectInputStream input;
	private Socket connection;
	
	private String serverIP = "86.50.105.70";

	public Connection() throws UnknownHostException, IOException {
		
//		int port = 6789;
//		String address = "86.50.105.70";
//		Socket s = new Socket(address,port);
//		
//		InputStream iS = s.getInputStream();
//		OutputStream oS = s.getOutputStream();
//		
//		ObjectOutputStream oOut = new ObjectOutputStream(oS);
//		ObjectInputStream oIn = new ObjectInputStream(iS);
//		
//		String msg = "test";
//		
//		oOut.writeObject(msg);
//		oOut.flush();
//		
//		oIn.close();
//		oOut.close();
//		s.close();
	}
	
	public void init() throws IOException {
		
		//CONNECTION
		connection = new Socket(InetAddress.getByName(serverIP), 6789);
		
		//STREAMS
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		
		whileConnected();
	}
	
	public static void sendMessage(String msg) {
		try {
			output.writeObject(msg);
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void whileConnected() {
		String msg;
		do {
			try {
				msg = (String) input.readObject();
				System.out.println(msg);
				GUI.appendMessage(msg);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} while (true);
	}

	

}

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Client {
	
	public static void main(String[] args) {
		
		GUI gui = new GUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Connection c = new Connection();
			c.init();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}

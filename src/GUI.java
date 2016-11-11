import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {

	private JTextField userText;
	private static JTextArea textArea;
	
	
	public GUI() {
		
		super("Client");
		
		//JButton disconnect = new JButton("Disconnect");
		
		userText = new JTextField();
		userText.setEditable(true);
		
		//add(disconnect, BorderLayout.NORTH);
		add(userText, BorderLayout.SOUTH);
		textArea = new JTextArea();
		textArea.setEditable(false);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		setSize(400,400);
		setVisible(true);
		
	
		
		userText.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent event) {
						
						String input = event.getActionCommand();
						Connection.sendMessage(input+"\n");
						userText.setText("");
						//String result = ""+ handler.handleShit(input);
						//textArea.setText("");
						//textArea.append(result);
			
					}
				}
		);
	}
	
	public void startConnection() throws UnknownHostException, IOException {
		Connection connection = new Connection();
	}
	
	public static void appendMessage(String msg) {
		textArea.append(msg);
	}

	
}

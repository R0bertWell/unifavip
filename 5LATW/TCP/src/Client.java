import java.awt.BorderLayout;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String charServer;
	private Socket client;
	
	public Client(String host) {
		super("Client");
		charServer = host;
		
		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener((e) -> {
			displayMessage(e.getActionCommand());
			enterField.setText("");
		});
		add(enterField, BorderLayout.NORTH);
		
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(() -> {
			displayArea.append(messageToDisplay);
		});
	}
	
	private void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(() -> {
			enterField.setEditable(editable);
		});
	}
	
	public static void main(String[] args) {
		Client application;
		if(args.length == 0) {
			application = new Client("127.0.0.1");
		}else {
			application = new Client(args[0]);
		}
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

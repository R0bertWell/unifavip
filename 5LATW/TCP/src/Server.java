import java.awt.BorderLayout;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private int counter = 1;
	
	public Server() {	
		super("Server");
		
		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener((e) -> {
			sendData(e.getActionCommand());
			enterField.setText("");
		});
		add(enterField, BorderLayout.NORTH);
		
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public void runServer() {
		try {
			server = new ServerSocket(12345, 100);
			while(true) {
				try {
					waitForConnection();
					getStreams();
					processConnection();
				} catch(EOFException eofException) {
					displayMessage("\nServer terminated connection");
				} finally {
					closeConnection();
					++counter;
				}
			}
		}catch(IOException ioExcetion) {
			closeConnection();
			++counter;
		}
	}
	
	private void waitForConnection() throws IOException {
		displayMessage("Waiting for connection\n");
		connection = server.accept();
		displayMessage("Connection " 
				+ counter 
				+ " received from: " 
				+ connection.getInetAddress().getHostName());
	}
	
	private void getStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
	}
	
	private void processConnection() throws IOException {
		String message = "\nConnection successful";
		displayMessage(message);
		sendData(message);
		setTextFieldEditable(true);
		do {
			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);
			}catch(ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnkown object type received");
			}
		}while(!message.equals("CLIENT>>> TERMINATE"));
	}
	
	private void sendData(String message) {
		try {
			if(output != null) {
				output.writeObject("SERVER>>> " + message);
				output.flush();
				displayMessage("SERVER>>> " + message);
			}
		}catch(IOException ioException) {
			ioException.printStackTrace();
			displayArea.append("\nError writing object");
		}
	}
	
	private void closeConnection() {
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false);
		try {
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
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
		Server application = new Server();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runServer();
	}

}

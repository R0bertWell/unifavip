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
			sendData(e.getActionCommand());
			enterField.setText("");
		});
		add(enterField, BorderLayout.NORTH);
		
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public void runClient() {
		try {
			connectToServer();
			getStreams();
			processConnection();
		} catch (UnknownHostException e) {
			displayMessage("\nClient terminated connection");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}
	
	private void connectToServer() throws UnknownHostException, IOException {
		displayMessage("Attempting connection\n");
		client = new Socket(InetAddress.getByName(charServer), 12345);
		displayMessage("Connected to: " + client.getInetAddress().getHostName());
	}
	
	private void getStreams() throws IOException {
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		input = new ObjectInputStream(client.getInputStream());
		displayMessage("\nGOT I/O streams\n");
	}
	
	private void processConnection() throws IOException {
		setTextFieldEditable(true);
		do {
			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);
			}catch(ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnkown object type received");
			}
		}while(!message.equals("SERVER>>> TERMINATE"));
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
	
	private void sendData(String message) {
		try {
			if(output != null) {
				output.writeObject("CLIENT>>> " + message);
				output.flush();
				displayMessage("\nCLIENT>>> " + message);
			}
		}catch(IOException ioException) {
			ioException.printStackTrace();
			displayArea.append("\nError writing object");
		}
	}
	
	private void closeConnection() {
		displayMessage("\nClosing connection\n");
		setTextFieldEditable(false);
		try {
			output.close();
			input.close();
			client.close();
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client application = new Client("127.0.0.1");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runClient();
	}
}

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TomadaDoisPinos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel lbImagem;

	public TomadaDoisPinos() {
		this.setTitle("Tomada Dois Pinos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		this.lbImagem = new JLabel("Imagem");
		this.lbImagem.setFont(new Font("Serif", Font.BOLD, 32));
		this.lbImagem.setBounds(20, 20, 450, 450);
		this.lbImagem.setIcon(new ImageIcon("tomada2.jpg"));
		this.add(lbImagem);
	}

	public void exibirTomarDoisPinos() {
		this.setVisible(true);
	}
	
}

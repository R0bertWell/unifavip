import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private Compra compra;
	private JLabel lbCompra;
	private JLabel lbStatusCompra;
	private JButton btEfetuarPagamento;
	private JButton btReceberCompra;
	private JButton btDevolverCompra;
	
	public TelaCompra(Compra compra) {
		this.compra = compra;
		this.setTitle("Tela Compra");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		this.lbCompra = new JLabel("Valor Compra: " + this.compra.getValorCompra());
		this.lbCompra.setFont(new Font("Serif", Font.BOLD, 30));
		this.lbCompra.setBounds(20, 20, 400, 40);
		this.add(lbCompra);
		
		this.btEfetuarPagamento = new JButton("Efetuar Pagamento");
		this.btEfetuarPagamento.setBounds(20, 85, 150, 25);
		btEfetuarPagamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Double valorPago = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de pagamento: "));
				try {
					compra.efetuarPagamento(valorPago);
				} catch (StatusInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				exibirStatusCompra();
			}
		});
		this.add(btEfetuarPagamento);
		
		this.btReceberCompra = new JButton("Receber Compra");
		this.btReceberCompra.setBounds(185, 85, 150, 25);
		btReceberCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					compra.receberCompra();
				} catch (StatusInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				exibirStatusCompra();
			}
		});
		this.add(btReceberCompra);
		
		this.btDevolverCompra = new JButton("Devolver Compra");
		this.btDevolverCompra.setBounds(350, 85, 150, 25);
		btDevolverCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					compra.devolverCompra();
				} catch (StatusInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				exibirStatusCompra();
			}
		});
		this.add(btDevolverCompra);

		this.lbStatusCompra = new JLabel("Status da Compra: " + this.compra.getStatusAtual().getNome());
		this.lbStatusCompra.setFont(new Font("Serif", Font.BOLD, 25));
		this.lbStatusCompra.setBounds(20, 150, 500, 100);
		this.add(lbStatusCompra);
		
		this.setVisible(true);
	}
	
	public void exibirStatusCompra() {
		lbStatusCompra.setText("Status da Compra: " + this.compra.getStatusAtual().getNome());
	}
	
}

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaOrcamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lbNome;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ComponenteOrcamento orcamento;

	public TelaOrcamento(ComponenteOrcamento orcamento) {
		this.orcamento = orcamento;
		this.setTitle("Orçamento");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		this.lbNome = new JLabel("Orçamento Casa");
		this.lbNome.setBounds(20, 20, 150, 20);
		
		criarTabela();
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(20, 60, 580, 420);

		this.add(lbNome);

		this.add(barraRolagem);
		this.setVisible(true);
	}
	
	private void criarTabela() {
		tabela = new JTable(modelo);
		modelo.addColumn("Código");
		modelo.addColumn("Item");
		modelo.addColumn("Valor");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(360);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		Iterator<ComponenteOrcamento> iterator = orcamento.createIterator();
		while(iterator.hasNext()) {
			ComponenteOrcamento item = iterator.next();
			modelo.addRow(new Object[] { item.getCodigo(), item.getNome(), item.getPreco() });
		}
	}

}

import java.util.ArrayList;
import java.util.List;

public class Item {

	private String codigo;
	private String nome;
	private double preco;
	private List<Item> subitens = new ArrayList<Item>();

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Item> getSubitens() {
		return subitens;
	}

	public void setSubitens(List<Item> subitens) {
		this.subitens = subitens;
	}

}

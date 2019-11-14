import java.util.Iterator;

public class ItemOrcamento extends ComponenteOrcamento {

	private String codigo;
	private String nome;
	private double preco;

	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public double getPreco() {
		return preco;
	}

	@Override
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public void imprimir() {
		System.out.println(codigo + " - " + nome + " - R$ " + preco);
	}
	
	@Override
	public Iterator<ComponenteOrcamento> createIterator(){
		return new NullIterator();
	}

}

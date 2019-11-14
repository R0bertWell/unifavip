import java.util.Iterator;

public abstract class ComponenteOrcamento {

	public void adicionar(ComponenteOrcamento componente) {
		throw new UnsupportedOperationException();
	}
	
	public void remover(ComponenteOrcamento componente) {
		throw new UnsupportedOperationException();
	}
	
	public ComponenteOrcamento getFilho(int i) {
		throw new UnsupportedOperationException();
	}
	
	public String getCodigo() {
		throw new UnsupportedOperationException();
	}
	
	public String getNome() {
		throw new UnsupportedOperationException();
	}
	
	public double getPreco() {
		throw new UnsupportedOperationException();
	}
	
	public void setCodigo(String codigo) {
		throw new UnsupportedOperationException();
	}

	public void setNome(String nome) {
		throw new UnsupportedOperationException();
	}

	public void setPreco(double preco) {
		throw new UnsupportedOperationException();
	}
	
	public void imprimir() {
		throw new UnsupportedOperationException();
	}
	
	public Iterator<ComponenteOrcamento> createIterator(){
		throw new UnsupportedOperationException();
	}
	
}

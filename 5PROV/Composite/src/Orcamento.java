import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orcamento extends ComponenteOrcamento {

	private String codigo;
	private String nome;
	private double preco;
	private List<ComponenteOrcamento> componentesOrcamento = new ArrayList<ComponenteOrcamento>();	
	
	@Override
	public void adicionar(ComponenteOrcamento componente) {
		componentesOrcamento.add(componente);
	}
	
	@Override
	public void remover(ComponenteOrcamento componente) {
		componentesOrcamento.remove(componente);
	}
	
	@Override
	public ComponenteOrcamento getFilho(int i) {
		return componentesOrcamento.get(i);
	}
	
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
		preco = 0;
		Iterator<ComponenteOrcamento> iterator = componentesOrcamento.iterator();
		while(iterator.hasNext()) {
			ComponenteOrcamento componenteOrcamento = iterator.next();
			preco += componenteOrcamento.getPreco();
		}
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
	public void imprimir() {
		System.out.println(codigo + " - " + nome + " - R$ " + getPreco());
		Iterator<ComponenteOrcamento> iterator = componentesOrcamento.iterator();
		while(iterator.hasNext()) {
			ComponenteOrcamento componenteOrcamento = iterator.next();
			componenteOrcamento.imprimir();
		}
	}
	
	@Override
	public Iterator<ComponenteOrcamento> createIterator(){
		return new CompositeIterator(componentesOrcamento.iterator());
	}
	
}

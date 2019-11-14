import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<ComponenteOrcamento> {

	private Stack<Iterator<ComponenteOrcamento>> stack = new Stack<Iterator<ComponenteOrcamento>>();
	
	public CompositeIterator(Iterator<ComponenteOrcamento> iterator) {
		stack.push(iterator);
	}
	
	@Override
	public boolean hasNext() {
		if(stack.empty()) {
			return false;
		}else {
			Iterator<ComponenteOrcamento> iterator = stack.peek();
			if(!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			}else {
				return true;
			}
		}
	}

	@Override
	public ComponenteOrcamento next() {
		if(hasNext()) {
			Iterator<ComponenteOrcamento> iterator = stack.peek();
			ComponenteOrcamento componenteOrcamento = iterator.next();
			if(componenteOrcamento instanceof Orcamento) {
				stack.push(componenteOrcamento.createIterator());
			}
			return componenteOrcamento;
		}
		return null;
	}

}

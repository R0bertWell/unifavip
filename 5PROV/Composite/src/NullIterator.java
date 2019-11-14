import java.util.Iterator;

public class NullIterator implements Iterator<ComponenteOrcamento> {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public ComponenteOrcamento next() {
		return null;
	}

}

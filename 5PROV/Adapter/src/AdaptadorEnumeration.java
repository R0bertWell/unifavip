import java.util.Enumeration;
import java.util.Iterator;

public class AdaptadorEnumeration implements Iterator<String> {
	
	private Enumeration<String> enumeration;
	
	public AdaptadorEnumeration(Enumeration<String> enumeration) {
		this.enumeration = enumeration;
	}

	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public String next() {
		return enumeration.nextElement();
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Método não suportado.");
	}

}

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Programa {
	
	public static void main(String[] args) {
		Vector<String> vector = new Vector<>();
		vector.add("João");
		vector.add("José");
		vector.add("Joana");
		
		AdaptadorEnumeration adaptador = new AdaptadorEnumeration(vector.elements());
	
		Programa programa = new Programa();
		programa.exibirDados(adaptador);
	
	}
	
	public void exibirDados(Iterator<String> iterator) {
		while(iterator.hasNext()) {
			String dado = iterator.next();
			System.out.println(dado);
		}
	}

}


public class Teste {
	
	public static void main(String[] args) {
		Item orcamento = new Item();
		orcamento.setCodigo("0");
		orcamento.setNome("Orçamento");
		
		Item item1 = new Item();
		item1.setCodigo("1");
		item1.setNome("Parede");
		item1.setPreco(5000);
		
		Item item1_1 = new Item();
		item1_1.setCodigo("1.1");
		item1_1.setNome("Tijolo");
		item1_1.setPreco(2000);
		item1.getSubitens().add(item1_1);
		
		Item item2 = new Item();
		item2.setCodigo("2");
		item2.setNome("Teto");
		item2.setPreco(3000);
		
		orcamento.getSubitens().add(item1);
		orcamento.getSubitens().add(item2);
		
		for(Item o : orcamento.getSubitens()) {
			System.out.println(o.getCodigo() + " - " + o.getNome() + ", R$ " + o.getPreco());
			for(Item o2 : o.getSubitens()) {
				System.out.println(o2.getCodigo() + " - " + o2.getNome() + ", R$ " + o2.getPreco());
			}
		}
	}

}

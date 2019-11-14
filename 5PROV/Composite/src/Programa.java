
public class Programa {
	
	public static void main(String[] args) {
		ComponenteOrcamento orcamento = new Orcamento();
		orcamento.setCodigo("0");
		orcamento.setNome("Orçamento Casa");

		ComponenteOrcamento item1 = new ItemOrcamento();
		item1.setCodigo("1");
		item1.setNome("Movimento de Terra");
		item1.setPreco(440);
		orcamento.adicionar(item1);
		
		ComponenteOrcamento item2 = new Orcamento();
		item2.setCodigo("2");
		item2.setNome("Paredes");
		orcamento.adicionar(item2);
		
		ComponenteOrcamento item2_1 = new ItemOrcamento();
		item2_1.setCodigo("2.1");
		item2_1.setNome("Tijolos");
		item2_1.setPreco(2439);
		item2.adicionar(item2_1);
		
		ComponenteOrcamento item2_2 = new ItemOrcamento();
		item2_2.setCodigo("2.2");
		item2_2.setNome("Reboco");
		item2_2.setPreco(204);
		item2.adicionar(item2_2);
		
		ComponenteOrcamento item3 = new ItemOrcamento();
		item3.setCodigo("3");
		item3.setNome("Teto");
		item3.setPreco(5736);
		orcamento.adicionar(item3);
		
		ComponenteOrcamento item4 = new Orcamento();
		item4.setCodigo("4");
		item4.setNome("Mão de Obra");
		orcamento.adicionar(item4);
		
//		ComponenteOrcamento item4_1 = new Orcamento();
//		item4_1.setCodigo("4.1");
//		item4_1.setNome("Pedreiros");
//		item4.adicionar(item4_1);
//		
//		ComponenteOrcamento item4_1_1 = new ItemOrcamento();
//		item4_1_1.setCodigo("4.1.1");
//		item4_1_1.setNome("Mestre");
//		item4_1_1.setPreco(9500);
//		item4_1.adicionar(item4_1_1);
//		
//		ComponenteOrcamento item4_1_2 = new ItemOrcamento();
//		item4_1_2.setCodigo("4.1.2");
//		item4_1_2.setNome("Assistente");
//		item4_1_2.setPreco(3000);
//		item4_1.adicionar(item4_1_2);
		
		ComponenteOrcamento item4_2 = new ItemOrcamento();
		item4_2.setCodigo("4.2");
		item4_2.setNome("Encanador");
		item4_2.setPreco(4200);
		item4.adicionar(item4_2);
		
		ComponenteOrcamento item4_3 = new ItemOrcamento();
		item4_3.setCodigo("4.3");
		item4_3.setNome("Eletricista");
		item4_3.setPreco(1700);
		item4.adicionar(item4_3);
		
		orcamento.imprimir();
		
		new TelaOrcamento(orcamento);
	}

}

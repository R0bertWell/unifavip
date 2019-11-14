
public class PagamentoAprovado extends StatusCompra {

	public PagamentoAprovado(Compra compra) {
		super(compra);
		this.nome = "Pagamento Aprovado";
	}

	@Override
	public void receberCompra() {
		compra.setStatusAtual(compra.getStatusCompraEntregue());
	}
	
}

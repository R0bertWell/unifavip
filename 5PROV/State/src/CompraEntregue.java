
public class CompraEntregue extends StatusCompra {

	public CompraEntregue(Compra compra) {
		super(compra);
		this.nome = "Compra Entregue";
	}

	@Override
	public void devolverCompra() {
		compra.setStatusAtual(compra.getStatusCompraDevolvida());
	}
	
}

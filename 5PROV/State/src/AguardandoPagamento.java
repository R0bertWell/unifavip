
public class AguardandoPagamento extends StatusCompra {

	public AguardandoPagamento(Compra compra) {
		super(compra);
		this.nome = "Aguardando Pagamento";
	}
	
	@Override
	public void efetuarPagamento(Double valor) {
		if(compra.getValorCompra() == valor) {
			compra.setStatusAtual(compra.getStatusPagamentoAprovado());
		}else {
			compra.setStatusAtual(compra.getStatusPagamentoReprovado());
		}
	}
	

}

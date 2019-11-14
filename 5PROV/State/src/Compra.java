
public class Compra {

	private float valorCompra;
	private StatusCompra statusAtual;
	private StatusCompra statusAguardandoPagamento;
	private StatusCompra statusPagamentoAprovado;
	private StatusCompra statusPagamentoReprovado;
	private StatusCompra statusCompraEntregue;
	private StatusCompra statusCompraDevolvida;

	public Compra(float valorCompra) {
		this.valorCompra = valorCompra;
		this.statusAguardandoPagamento = new AguardandoPagamento(this);
		this.statusPagamentoAprovado = new PagamentoAprovado(this);
		this.statusPagamentoReprovado = new PagamentoReprovado(this);
		this.statusCompraEntregue = new CompraEntregue(this);
		this.statusCompraDevolvida = new CompraDevolvida(this);
		this.statusAtual = this.statusAguardandoPagamento;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public StatusCompra getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(StatusCompra statusAtual) {
		this.statusAtual = statusAtual;
	}

	public StatusCompra getStatusAguardandoPagamento() {
		return statusAguardandoPagamento;
	}

	public StatusCompra getStatusPagamentoAprovado() {
		return statusPagamentoAprovado;
	}

	public StatusCompra getStatusPagamentoReprovado() {
		return statusPagamentoReprovado;
	}

	public StatusCompra getStatusCompraEntregue() {
		return statusCompraEntregue;
	}

	public StatusCompra getStatusCompraDevolvida() {
		return statusCompraDevolvida;
	}
	
	public void efetuarPagamento(Double valor) throws StatusInvalidoException {
		statusAtual.efetuarPagamento(valor);
	}

	public void receberCompra() throws StatusInvalidoException {
		statusAtual.receberCompra();
	}

	public void devolverCompra() throws StatusInvalidoException {
		statusAtual.devolverCompra();
	}
	
}

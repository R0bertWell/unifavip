
public abstract class StatusCompra {

	protected Compra compra;
	protected String nome;

	public StatusCompra(Compra compra) {
		this.compra = compra;
	}

	public void efetuarPagamento(Double valor) throws StatusInvalidoException {
		throw new StatusInvalidoException("Ação inválida para o status " + compra.getStatusAtual().getNome());
	}

	public void receberCompra() throws StatusInvalidoException {
		throw new StatusInvalidoException("Ação inválida para o status " + compra.getStatusAtual().getNome());
	}

	public void devolverCompra() throws StatusInvalidoException {
		throw new StatusInvalidoException("Ação inválida para o status " + compra.getStatusAtual().getNome());
	}

	public String getNome() {
		return nome;
	}

}

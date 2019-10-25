
public class Compra {

	private float valorCompra;
	private String statusCompra;

	public Compra(float valorCompra) {
		this.statusCompra = "Aguardando Pagamento";
		this.valorCompra = valorCompra;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getStatusCompra() {
		return statusCompra;
	}

	public void setStatusCompra(String statusCompra) {
		this.statusCompra = statusCompra;
	}

}

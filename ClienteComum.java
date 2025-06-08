package clientes;

public class ClienteComum extends Cliente {

	public ClienteComum(double preco) {
		super(preco);
	}
	
	@Override
	public double calcularPrecoFinal() {
		return getPreco();
	}
}

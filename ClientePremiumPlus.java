package clientes;

public class ClientePremiumPlus extends Cliente {
	
	public ClientePremiumPlus(double preco) {
		super(preco);
	}

	@Override
	public double calcularPrecoFinal() {
		return getPreco() * 0.82; // 18% de desconto
	}
}

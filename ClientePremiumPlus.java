package clientes;

public class ClientePremiumPlus extends Cliente {
	
	public ClientePremiumPlus(double preco,String cpf) {
		super(preco,cpf);
	}

	@Override
	public double calcularPrecoFinal() {
		return getPreco() * 0.82; // 18% de desconto
	}
}

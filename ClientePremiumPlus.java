package clientes;

public class ClientePremiumPlus extends Cliente {
	
	public ClientePremiumPlus(double preco,String cpf) {
		super(preco,cpf);
	}

	@Override
	public double calcularPrecoFinal(double preco) {
		return preco * 0.80; // 20% de desconto
	}
}

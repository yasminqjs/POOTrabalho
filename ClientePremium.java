package clientes;

public class ClientePremium extends Cliente {

	public ClientePremium(double preco,String cpf) {
		super(preco, cpf);
	}

	@Override
	public double calcularPrecoFinal(double preco) {
		return preco * 0.90; // 10% de desconto
	}

}

package clientes;

public class ClienteComum extends Cliente {

	public ClienteComum(double preco, String cpf) {
		super(preco, cpf);
	}
	
	@Override
	public double calcularPrecoFinal(double Preco) {
		return Preco;
	}
}

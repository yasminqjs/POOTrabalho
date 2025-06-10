package clientes;
import interfaces.VendaInterface;

abstract public class Cliente  implements VendaInterface{
	protected Double preco;
	protected String cpf;
	
	public Cliente(Double preco,String cpf) {
		this.preco = preco;
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	public double getPreco() {
		return preco;
	}
	public double calcularPrecoFinal(double precoFinal){
		return precoFinal;
	}
	
}
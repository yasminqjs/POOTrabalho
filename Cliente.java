package clientes;

abstract public class Cliente {
	protected double preco;
	
	public Cliente(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public abstract double calcularPrecoFinal();
}

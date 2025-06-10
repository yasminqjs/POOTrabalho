package entidades;

public class ProdutoHigiene extends Produto {
    private String tipo; 

    public ProdutoHigiene(double preco, int quantidade, String nome, String validade, String tipo) {
        super(preco, quantidade, nome, validade);
        this.tipo = tipo;
    }

    public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return super.toString() + " Categoria: Higiene | Tipo: " + tipo + " |";
	}

	
	
	
}

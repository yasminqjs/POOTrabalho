package entidades;

public class ProdutoHigiene extends Produto {
    private String tipo; // dental, capilar, corporal

    public ProdutoHigiene(double preco, int quantidade, String nome, String validade, String tipo) {
        super(preco, quantidade, nome, validade);
        this.tipo = tipo;
    }

    // Getters e Setters
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

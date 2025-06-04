package entidades;

public class Produto {
    private double preco;
    private int quantidade;
    private String nome;
    private String validade;

    public Produto(double preco, int quantidade, String nome, String validade) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.nome = nome;
        this.validade = validade;
    }

    // Getters e Setters

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Produto{" + "Nome ='" + nome + '\'' + ", Preco =" + preco + ", quantidade=" + quantidade + ", validade='" + validade + '\'' +  '}';
    }
}

package entidades;

import java.time.LocalDate;

public class Produto {
    private Double preco;
    private Integer quantidade;
    private String nome;
    private LocalDate validade;

    public Produto(double preco, int quantidade, String nome, String validadeEmString) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.nome = nome;
        LocalDate validade = LocalDate.parse(validadeEmString);
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

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(String validadeEmString) {
		LocalDate validade = LocalDate.parse(validadeEmString);
		this.validade = validade;
		
	}
	
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "Produto [preco=" + preco + ", quantidade=" + quantidade + ", nome=" + nome + ", validade=" + validade + "]";
	}
   
	
}
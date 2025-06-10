package entidades;

import java.time.LocalDate;

public class Produto {
    private Double preco;
    private Integer quantidade, quantidadeCarr;
    private String nome;
    private LocalDate validade;

    public Produto(double preco, int quantidade, String nome, String validadeEmString) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.nome = nome;
        LocalDate validade = LocalDate.parse(validadeEmString);
        this.validade = validade;
        this.quantidadeCarr = 0;

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
  
  	public int getQuantidadeCarr() {
		return quantidadeCarr;
	}

	public void setQuantidadeCarr(int quantidadeCarr) {
		this.quantidadeCarr = quantidadeCarr;
	}
	
	public void atualizarQuantidade() {
		quantidade = quantidade - quantidadeCarr;
	}
	
	public void desfazCarr() {
		quantidade = quantidade + quantidadeCarr;
	}
	
	public double precoNoCarr() {
		return quantidadeCarr * preco;
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
		return "Nome: " + nome + " | Quantidade = " + quantidade + " | Preco = " + preco + " | Validade = " + validade + " |";
	}
	
	public String toStringCarr() {
		return "Nome: " + nome + " | Quantidade = " + quantidadeCarr + " | Preco = " + preco + " | Validade = " + validade + " |";
	}
}
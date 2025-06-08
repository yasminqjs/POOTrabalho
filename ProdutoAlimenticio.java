package entidades;

public class ProdutoAlimenticio extends Produto {
    private String tipoComida; // comida ou bebida
    private String ehFit; // "sim" ou "nao"

    public ProdutoAlimenticio(double preco, int quantidade, String nome, String validade, String tipoComida, String ehFit) {
        super(preco, quantidade, nome, validade);
        this.tipoComida = tipoComida;
        this.ehFit = ehFit;
    }

	public String getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	public String getEhFit() {
		return ehFit;
	}

	public void setEhFit(String ehFit) {
		this.ehFit = ehFit;
	}

	@Override
	public String toString() {
		return super.toString() + "ProdutoAlimenticio [tipoComida=" + tipoComida + ", ehFit=" + ehFit + "]";
	}

	
}

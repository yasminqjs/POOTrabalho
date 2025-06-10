package entidades;

public class TinturaParaCabelo extends ProdutoBeleza {
    private String tipoDeCabelo;
    private String cor;

    public TinturaParaCabelo(double preco, int quantidade, String nome, String validade, String internacional, String luxo, String tipoDeCabelo, String cor) {
        super(preco, quantidade, nome, validade, internacional, luxo);
        this.tipoDeCabelo = tipoDeCabelo;
        this.cor = cor;
    }

	public String getTipoDeCabelo() {
		return tipoDeCabelo;
	}

	public void setTipoDeCabelo(String tipoDeCabelo) {
		this.tipoDeCabelo = tipoDeCabelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return super.toString() + " Categoria: Produto de Beleza (Tintura de Cabelo) | Tipo De Cabelo: " + tipoDeCabelo + " | Cor: " + cor + " |";
		
	}
	
	
}
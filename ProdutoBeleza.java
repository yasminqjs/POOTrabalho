package entidades;

public abstract class ProdutoBeleza extends Produto {
    private String internacional; // "internacional" ou "nacional"
    private String luxo; // "luxo" ou "popular"

    public ProdutoBeleza(double preco, int quantidade, String nome, String validade, String internacional, String luxo) {
        super(preco, quantidade, nome, validade);
        this.internacional = internacional;
        this.luxo = luxo;
    }

	public String getInternacional() {
		return internacional;
	}

	public void setInternacional(String internacional) {
		this.internacional = internacional;
	}

	public String getLuxo() {
		return luxo;
	}

	public void setLuxo(String luxo) {
		this.luxo = luxo;
	}

	@Override
	public String toString() {
		return super.toString() + "ProdutoBeleza [internacional=" + internacional + ", luxo=" + luxo + "]";
	}

   
}

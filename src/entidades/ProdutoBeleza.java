package entidades;

public abstract class ProdutoBeleza extends Produto {
    private String internacional; // true = internacional, false = nacional
    private String luxo; // true = luxo, false = popular

    public ProdutoBeleza(double preco, int quantidade, String nome, String validade, String internacional, String luxo) {
        super(preco, quantidade, nome, validade);
        this.internacional = internacional;
        this.luxo = luxo;
    }

    // Getters e Setters

    public String getInternacional() {
        return internacional;
    }

    public String getLuxo() {
        return luxo;
    }

    public void setInternacional(String internacional) {
        this.internacional = internacional;
    }

    public void setLuxo(String luxo) {
        this.luxo = luxo;
    }
    
    

}

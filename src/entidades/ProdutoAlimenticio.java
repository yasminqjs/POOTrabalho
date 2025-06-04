package entidades;

public abstract class ProdutoAlimenticio extends Produto {
    private String internacional; 
    private String luxo; 

    public ProdutoAlimenticio(String internacional, String luxo, double preco, int quantidade, String nome, String validade) {
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

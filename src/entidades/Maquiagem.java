package entidades;

public class Maquiagem extends ProdutoBeleza {
    private String cor;
    private String tipoDePele;

    public Maquiagem(double preco, int quantidade, String nome, String validade,String internacional, String luxo, String cor, String tipoDePele) {
        super(preco, quantidade, nome, validade, internacional, luxo);
        this.cor = cor;
        this.tipoDePele = tipoDePele;
    }

    // Getters e Setters

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoDePele() {
        return tipoDePele;
    }

    public void setTipoDePele(String tipoDePele) {
        this.tipoDePele = tipoDePele;
    }

    
}

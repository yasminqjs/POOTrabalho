package produtos;

public class Maquiagem extends Produto {
    private String cor;
    private String tipoDePele;

    public Maquiagem(double preco, int quantidade, String cor, String tipoDePele) {
        super(preco, quantidade);
        this.cor = cor;
        this.tipoDePele = tipoDePele;
    }

    @Override
    public String getDescricao() {
        return String.format("Maquiagem | Preço: %.2f | Qtd: %d | Cor: %s | Tipo de Pele: %s",
                preco, quantidade, cor, tipoDePele);
    }
}

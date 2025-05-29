package produtos;

public class ProdutoCapilar extends Produto {
    private Float volume;
    private String tipoDeCabelo;
    private String fragrancia;

    public ProdutoCapilar(double preco, int quantidade, float volume, String tipoDeCabelo, String fragrancia) {
        super(preco, quantidade);
        this.volume = volume;
        this.tipoDeCabelo = tipoDeCabelo;
        this.fragrancia = fragrancia;
    }

    @Override
    public String getDescricao() {
        return String.format("Produto Capilar | Preço: %.2f | Qtd: %d | Volume: %.1fml | Tipo: %s | Fragrância: %s",
                preco, quantidade, volume, tipoDeCabelo, fragrancia);
    }
}

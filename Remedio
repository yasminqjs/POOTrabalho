package produtos;

public class Remedio extends Produto {
    private String tarja;
    private String sintomas;

    public Remedio(double preco, int quantidade, String tarja, String sintomas) {
        super(preco, quantidade);
        this.tarja = tarja;
        this.sintomas = sintomas;
    }

    @Override
    public String getDescricao() {
        return String.format("Remédio | Preço: %.2f | Qtd: %d | Tarja: %s | Sintomas: %s",
                preco, quantidade, tarja, sintomas);
    }
}

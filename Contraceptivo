package produtos;

public class Contraceptivo extends Produto {
    private String genero;

    public Contraceptivo(double preco, int quantidade, String genero) {
        super(preco, quantidade);
        this.genero = genero;
    }

    @Override
    public String getDescricao() {
        return String.format("Contraceptivo | Preço: %.2f | Qtd: %d | Gênero: %s",
                preco, quantidade, genero);
    }
}

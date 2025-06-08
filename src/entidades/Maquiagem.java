package entidades;

import interfaces.Exibivel;

public class Maquiagem extends ProdutoBeleza implements Exibivel {
    private String cor;
    private String tipoDePele;

    public Maquiagem(double preco, int quantidade, String nome, String validade, String internacional, String luxo, String cor, String tipoDePele) {
        super(preco, quantidade, nome, validade, internacional, luxo);
        this.cor = cor;
        this.tipoDePele = tipoDePele;
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("Maquiagem: %s | R$%.2f | %d unidades | Cor: %s | Tipo de pele: %s%n", 
                          getNome(), getPreco(), getQuantidade(), cor, tipoDePele);
    }
}

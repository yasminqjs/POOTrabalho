package executavel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entidades.*;

import clientes.*;

import executavel.FuncoesMenu;


public class Programa {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        cadastrarAutomaticamente();
        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Alterar produto");
            System.out.println("4. Remover produto");
            System.out.println("5. Atender Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> listarProdutos();
                case 3 -> alterarProduto();
                case 4 -> removerProduto();
                case 5 -> atenderCliente();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarAutomaticamente() {
    	
        produtos.add(new ProdutoHigiene(9.99, 10, "Sabonete", "2025-12", "corporal"));
        produtos.add(new ProdutoHigiene(5.49, 20, "Pasta de dente", "2026-01", "dental"));


        produtos.add(new Remedio(19.90, 10, "Paracetamol", "2026-01", "Vermelha", "Dor de cabeça"));
        produtos.add(new Remedio(24.50, 8, "Ibuprofeno", "2026-04", "Preta", "Inflamação"));
 

        produtos.add(new Maquiagem(49.90, 10, "Base líquida", "2026-01", "nacional", "luxo", "bege", "oleosa"));
        produtos.add(new Maquiagem(39.90, 15, "Batom matte", "2025-12", "internacional", "popular", "vermelho", "todas"));


        produtos.add(new TinturaParaCabelo(29.90, 10, "Tintura Preto", "2026-01", "nacional", "popular", "liso", "preto"));
        produtos.add(new TinturaParaCabelo(34.90, 8, "Tintura Ruivo", "2026-02", "internacional", "luxo", "cacheado", "ruivo"));
       
    }
    
    private static void atenderCliente() {
    	 System.out.println("informe o tipo de cliente (comum/premium/premiumPlus)");
    	 String tipoCliente = scanner.nextLine();
    	 int opcaoC;
		do {
    	 System.out.println("1. Adicionar Produto ao carrinho do cliente");
         System.out.println("2. Remover Produto do carrinho do cliente");
         System.out.println("3. Pagar conta");
         System.out.println("0. Sair");
         opcaoC = scanner.nextInt();
         scanner.nextLine();
         switch (opcaoC) {
         case 1 -> adicionarCarrinho();
         case 2 -> removerCarrinho();
         case 3 -> pagarConta();
         case 0 -> System.out.println("Saindo...");
         default -> System.out.println("Opcao invalida!");
     }

    	 } while (opcaoC != 0);
    }

    
    private static void cadastrarProduto() {
        System.out.println("Escolha o tipo de produto para cadastrar:");
        System.out.println("1. Produto de Higiene");
        System.out.println("2. Remédio");
        System.out.println("3. Maquiagem");
        System.out.println("4. Tintura para Cabelo");
        System.out.println("5. Produto Alimenticio");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        Double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Validade (ano-mes): ");
        String validade = scanner.nextLine();

        // Verificar se já existe produto igual mesmo nome evalidade
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome) &&
                p.getValidade().equalsIgnoreCase(validade)) {
                p.setQuantidade(p.getQuantidade() + quantidade);
                System.out.println("Produto já existente. Quantidade somada com sucesso.");
                return;
            }
        }

        // Só chega aqui se não existir um produto igual
        switch (tipo) {
            case 1 -> {
                System.out.print("Tipo (dental/capilar/corporal): ");
                String tipoHigiene = scanner.nextLine();
                produtos.add(new ProdutoHigiene(preco, quantidade, nome, validade, tipoHigiene));
            }
            case 2 -> {
                System.out.print("Tarja: ");
                String tarja = scanner.nextLine();
                System.out.print("Sintomas: ");
                String sintomas = scanner.nextLine();
                produtos.add(new Remedio(preco, quantidade, nome, validade, tarja, sintomas));
            }
            case 3 -> {
                System.out.print("Internacional (sim/nao): ");
                String internacional = scanner.nextLine();
                System.out.print("Luxo (sim/nao): ");
                String luxo = scanner.nextLine();
                System.out.print("Cor: ");
                String cor = scanner.nextLine();
                System.out.print("Tipo de pele: ");
                String tipoPele = scanner.nextLine();
                produtos.add(new Maquiagem(preco, quantidade, nome, validade, internacional, luxo, cor, tipoPele));
            }
            case 4 -> {
                System.out.print("Internacional (sim/nao): ");
                String intl = scanner.nextLine();
                System.out.print("Luxo (sim/nao): ");
                String lux = scanner.nextLine();
                System.out.print("Tipo de cabelo: ");
                String tipoCabelo = scanner.nextLine();
                System.out.print("Cor: ");
                String corTintura = scanner.nextLine();
                produtos.add(new TinturaParaCabelo(preco, quantidade, nome, validade, intl, lux, tipoCabelo, corTintura));
            }
            case 5 -> {
                System.out.print("tipo (comida/bedida): ");
                String tipoComida = scanner.nextLine();
                System.out.print("Fitness (sim/nao): ");
                String fitness = scanner.nextLine();
                produtos.add(new ProdutoAlimenticio(preco, quantidade, nome, validade, tipoComida, fitness));
                break;
            }
            default -> {
                System.out.println("Tipo inválido.");
                return;
            }
        }

        System.out.println("Produto cadastrado com sucesso!");
    }


    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
        	System.out.println(p.toString());
            System.out.println("----------------------------");
        }
    }

    private static void alterarProduto() {
    	int quant;
    	double preco;
        System.out.print("Digite o nome do produto a alterar: ");
        String nome = scanner.nextLine();
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Novo nome: ");
                p.setNome(scanner.nextLine());
                System.out.print("Novo preco: ");
                preco = scanner.nextInt();
                p.setPreco(preco);
                System.out.print("Nova quantidade: ");
                quant = scanner.nextInt();
                p.setQuantidade(quant);
                scanner.nextLine();
                System.out.print("Nova validade: ");
                p.setValidade(scanner.nextLine());
                System.out.println("Produto alterado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private static void removerProduto() {
        System.out.print("Digite o nome do produto a remover: ");
        String nome = scanner.nextLine();
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            if (p.getNome().equalsIgnoreCase(nome)) {
                it.remove();
                System.out.println("Produto removido com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}

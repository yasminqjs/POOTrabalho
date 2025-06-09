package executavel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.text.Normalizer;

import entidades.Maquiagem;
import entidades.Produto;
import entidades.ProdutoHigiene;
import entidades.ProdutoAlimenticio;
import entidades.ProdutoBeleza;
import entidades.Remedio;
import entidades.TinturaParaCabelo;
import servicos.Sorts;

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
            System.out.println("5. Buscar produto");
            System.out.println("6. Ordenar produto");
            System.out.println("7. Filtrar produto por tipo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> listarProdutos();
                case 3 -> alterarProduto();
                case 4 -> removerProduto();
                case 5 -> buscarProduto();
                case 6 -> ordenarProduto();
                case 7 -> filtrarProduto();
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
        boolean removido = false;

        for (int i = produtos.size() - 1; i >= 0; i--) {
            Produto p = produtos.get(i);
            if (p.getNome().equalsIgnoreCase(nome)) {
                produtos.remove(i); // remoção segura
                removido = true;
                System.out.println("Produto removido com sucesso.");
                break;
            }
        }

        if (!removido) {
            System.out.println("Produto não encontrado.");
        }
    }


    
    private static void buscarProduto() {
    	System.out.print("Digite o nome do produto que você está buscando: ");
    	 String nome = scanner.nextLine();
    	 List<Produto> busca = new ArrayList<Produto>(); //cria um novo arraylist que vai guardar os resultados da busca
    	 
    	 nome = normalizarString(nome);
    	 
    	 for (int i = produtos.size() - 1; i >= 0; i--) {
    		 Produto p = produtos.get(i);
    	     String nomeP = p.getNome();
    	     
    	     nomeP = normalizarString(nomeP);
    	     
    	     if(nomeP.length() >= nome.length()) {
    	    	 if(nomeP.contains(nome)){
    			busca.add(p); //adiciona o produto caso a palavra buscada contenha parte de seu nome
    			 }
    		 }
    	 }
    	
    	 //mostrar os produtos que batem com a busca
    	 mostrarProdutos(busca);
         return;
    }
    
    private static String normalizarString(String string) {
    	string = Normalizer.normalize(string, Normalizer.Form.NFD); //remove os acentos da string
    	string = string.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    string = string.toLowerCase(); //deixa a string toda em minusculo
	     
    	return string;
    }
    
    private static void filtrarProduto() {
    	 System.out.println("Qual tipo de produto você deseja? ");
    	 System.out.println("1 - Remedio");
    	 System.out.println("2 - Produto de Beleza");
    	 System.out.println("3 - Produto de Higiene");
    	 System.out.println("4 - Produto Alimenticio");
    	 
    	 int num = scanner.nextInt();
    	 Class<?> classe = Produto.class; //cria uma variavel para guardar classes
    	 switch(num) { 
    	 	case 1 -> classe = Remedio.class;
    	 	case 2 -> classe = ProdutoBeleza.class;
    	 	case 3 -> classe = ProdutoHigiene.class;
    	 	case 4 -> classe = ProdutoAlimenticio.class;
    	 	default -> { 
    	 		System.out.println("O filtro escolhido não é válido!");
    	 		return;
    	 	}
    	 }
    	 
    	 List<Produto> filtro = new ArrayList<Produto>();
    	 
    	 for(Produto p : produtos) {
    		 if(classe.isInstance(p)) {
    			 filtro.add(p);
    		 }
    	 }
    	 
    	 mostrarProdutos(filtro);
    }
    
   private static void ordenarProduto() { //NAO FINALIZADO
         List<Produto> ordem = produtos;
	   
		 System.out.println("Como você deseja ordenar os produtos?");
	  	 System.out.println("1 - Preço");
	  	 System.out.println("2 - Quantidade");
	  	 System.out.println("3 - Nome");
	  	 System.out.println("4 - Validade");
	  	 
	  	 int num = scanner.nextInt();
	  	 
	  	 Sorts sort = new Sorts(); //cria um objeto de sorts para poder realizar os s
	  	 
	  	 switch(num) {
	  	 	case 1 -> Collections.sort(ordem, sort.new SortPreco());
	  	 	case 2 -> Collections.sort(ordem, sort.new SortQuantidade());
	  	 	case 3 -> Collections.sort(ordem, sort.new SortNome());
	  	 	case 4 -> Collections.sort(ordem, sort.new SortValidade());
	  	 }
	  	 
	  	 mostrarProdutos(ordem);
	  	 
	  	 return;
	   
    }
   

    
    private static void mostrarProdutos(List<Produto> lista) { //funcao interna para mostrar os produtos apos uma busca ou filtro
    	 if (lista.isEmpty()) {
             System.out.println("\nNenhum produto foi encontrado.");
             return;
         }
    	 System.out.println("\nProdutos Encontrados:");
         for (Produto p : lista) {
         	System.out.println(p.toString());
             System.out.println("----------------------------");
         }
    }
    
    
 
}

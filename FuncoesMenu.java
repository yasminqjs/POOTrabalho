package servicos;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import executavel.Programa;
import entidades.Maquiagem;
import entidades.Produto;
import entidades.ProdutoAlimenticio;
import entidades.ProdutoBeleza;
import entidades.ProdutoHigiene;
import entidades.Remedio;
import entidades.TinturaParaCabelo;

public class FuncoesMenu {
	public static Scanner scanner = new Scanner(System.in);
	protected static List<Produto> carrinho = new ArrayList<>();
	public static void adicionarCarrinho(){
		String resposta = "sim";
		do {
		listarProdutos();
		System.out.println("Digite o numero do produto a ser comprado:");
        int numero = scanner.nextInt();
		System.out.print("Digite a quantidade a ser comprada:");
		 int qntd = scanner.nextInt();
        int indice = numero - 1;
        if (indice >= 0 && indice < Programa.produtos.size()) {
        	if (Programa.produtos.get(indice).getQuantidade() >= qntd) {
        		Programa.produtos.get(indice).setQuantidadeCarr(qntd);
        		Programa.produtos.get(indice).atualizarQuantidade();
        	carrinho.add(Programa.produtos.get(indice));
            System.out.println("Deseja adicionar mais algum item? (sim/nao)");
            scanner.nextLine();
            resposta = scanner.nextLine();
        	} else {
        		System.out.println("quantidade solicitada maior do que o estoque");
        	}
	}
        else {
            System.out.println("Produto não encontrado. Por favor, introduza um número entre 1 e " + Programa.produtos.size());
        }
		} while (resposta.equalsIgnoreCase("sim"));

}
	
	
	public static void removerCarrinho(){
		int i=1;
        if (carrinho.isEmpty()) {
            System.out.println("Nenhum produto no carrinho");
            return;
        }
        
		else {
		String resposta = "sim";
		do {
		i=1;
        for (Produto p : carrinho) {
        	System.out.println(i + ".  " + p.toStringCarr());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            i++;
        }
        System.out.println("Digite o numero do produto a ser removido do carrinho:");
        int numero = scanner.nextInt();
        int indice = numero - 1;
        if (indice >= 0 && indice < carrinho.size()) {
        carrinho.get(indice).desfazCarr();
        carrinho.remove(indice);
        
        scanner.nextLine();
        
        System.out.println("Deseja remover mais algum item? (sim/nao)");
        resposta = scanner.nextLine();
        if( carrinho.size()==0) {
        	System.out.println("Seu carrinho já está vazio ");
        	
        }
        
        	}
        else System.out.println("Produto não encontrado. Por favor, introduza um número entre 1 e " + carrinho.size());
		} while (resposta.equalsIgnoreCase("sim")&& carrinho.size()!=0);
		}
	    }
	
	
	public static void verCarrinho() {
		int i=1;
		 if (carrinho.isEmpty()) {
	            System.out.println("Nenhum produto no carrinho");
	            return;
	        }
		 else {
        for (Produto p : carrinho) {
        	System.out.println(i + ".  " + p.toStringCarr());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            i++;
	}
		 }
	}
	
	
	public static void tchauCarrinho() {
		System.out.println("Deseja deixar o carrinho atual salvo? (sim/nao)");
		String resposta;
		resposta = scanner.nextLine();
		if (resposta.equalsIgnoreCase("nao")) {
			for (int i = 0; i< carrinho.size(); i++) {
				carrinho.get(i).desfazCarr();
				carrinho.remove(i);
			}
		}
	}
	
	 public static void cadastrarAutomaticamente() {
	    	
	        Programa.produtos.add(new ProdutoHigiene(9.99, 10, "Sabonete", "2025-12-05", "corporal"));
	        Programa.produtos.add(new ProdutoHigiene(5.49, 20, "Pasta de dente", "2026-01-04", "dental"));


	        Programa.produtos.add(new Remedio(19.90, 10, "Paracetamol", "2026-01-03", "Vermelha", "Dor de cabeça"));
	        Programa.produtos.add(new Remedio(24.50, 8, "Ibuprofeno", "2026-04-24", "Preta", "Inflamação"));
	 

	        Programa.produtos.add(new Maquiagem(49.90, 10, "Base líquida", "2026-01-27", "nacional", "luxo", "bege", "oleosa"));
	        Programa. produtos.add(new Maquiagem(39.90, 15, "Batom matte", "2025-12-18", "internacional", "popular", "vermelho", "todas"));


	        Programa.produtos.add(new TinturaParaCabelo(29.90, 10, "Tintura Preto", "2026-01-19", "nacional", "popular", "liso", "preto"));
	        Programa.produtos.add(new TinturaParaCabelo(34.90, 8, "Tintura Ruivo", "2026-02-11", "internacional", "luxo", "cacheado", "ruivo"));
	       
	    }

	      public static void atenderCliente() {
	    	 System.out.println("informe o tipo de cliente (comum/premium/premiumPlus)");
	    	 String tipoCliente = scanner.nextLine();
	    	 int opcaoC;
			do {
	    	 System.out.println("1. Adicionar Produto ao carrinho do cliente");
	         System.out.println("2. Remover Produto do carrinho do cliente");
	         System.out.println("3. Ver carrinho do cliente");
	         System.out.println("4. Pagar conta");
	         System.out.println("0. Sair");
	         opcaoC = scanner.nextInt();
	         scanner.nextLine();
	         switch (opcaoC) {
	         case 1 -> FuncoesMenu.adicionarCarrinho();
	         case 2 -> FuncoesMenu.removerCarrinho();
	         case 3 -> FuncoesMenu.verCarrinho();
	         //case 4 -> FuncoesMenu.pagarConta();
	         case 0 -> FuncoesMenu.tchauCarrinho();
	         default -> System.out.println("Opcao invalida!");
	     }

	    	 } while (opcaoC != 0);
	    }
	    
	    public static void cadastrarProduto() {
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
	        System.out.print("Validade (AAAA-MM-DD): ");
	        String validadeEmString = scanner.nextLine();
	        LocalDate validade = LocalDate.parse(validadeEmString);

	        // Verificar se já existe produto igual mesmo nome evalidade
	        for (Produto p : Programa.produtos) {
	            if (p.getNome().equalsIgnoreCase(nome) &&
	                p.getValidade().equals(validade)) {
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
	                Programa.produtos.add(new ProdutoHigiene(preco, quantidade, nome, validadeEmString, tipoHigiene));
	            }
	            case 2 -> {
	                System.out.print("Tarja: ");
	                String tarja = scanner.nextLine();
	                System.out.print("Sintomas: ");
	                String sintomas = scanner.nextLine();
	                Programa.produtos.add(new Remedio(preco, quantidade, nome, validadeEmString, tarja, sintomas));
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
	                Programa.produtos.add(new Maquiagem(preco, quantidade, nome, validadeEmString, internacional, luxo, cor, tipoPele));
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
	                Programa.produtos.add(new TinturaParaCabelo(preco, quantidade, nome, validadeEmString, intl, lux, tipoCabelo, corTintura));
	            }
	            case 5 -> {
	                System.out.print("tipo (comida/bedida): ");
	                String tipoComida = scanner.nextLine();
	                System.out.print("Fitness (sim/nao): ");
	                String fitness = scanner.nextLine();
	                Programa.produtos.add(new ProdutoAlimenticio(preco, quantidade, nome, validadeEmString, tipoComida, fitness));
	                break;
	            }
	            default -> {
	                System.out.println("Tipo inválido.");
	                return;
	            }
	        }

	        System.out.println("Produto cadastrado com sucesso!");
	    }


	    public static void listarProdutos() {
	        if (Programa.produtos.isEmpty()) {
	            System.out.println("Nenhum produto cadastrado.");
	            return;
	        }
	        int i=1;
	        for (Produto p : Programa.produtos) {
	        	System.out.println(i + ".  " + p.toString());
	            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
	            i++;
	        }
	    }

	   public static void alterarProduto() {
	    	int quant;
	    	double preco;
	        System.out.print("Digite o nome do produto a alterar: ");
	        String nome = scanner.nextLine();
	        for (Produto p : Programa.produtos) {
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
	                System.out.print("Nova validade (AAAA-MM-DD): ");
	                p.setValidade(scanner.nextLine());
	                System.out.println("Produto alterado com sucesso!");
	                return;
	            }
	        }
	        System.out.println("Produto não encontrado.");
	    }
	   public static void removerProduto() {
	        System.out.print("Digite o nome do produto a remover: ");
	        String nome = scanner.nextLine();
	        boolean removido = false;

	        for (int i = Programa.produtos.size() - 1; i >= 0; i--) {
	            Produto p = Programa.produtos.get(i);
	            if (p.getNome().equalsIgnoreCase(nome)) {
	            	Programa.produtos.remove(i); // remoção segura
	                removido = true;
	                System.out.println("Produto removido com sucesso.");
	                break;
	            }
	        }

	        if (!removido) {
	            System.out.println("Produto não encontrado.");
	        }
	    }


	    
	    public static void buscarProduto() {
	    	System.out.print("Digite o nome do produto que você está buscando: ");
	    	 String nome = scanner.nextLine();
	    	 List<Produto> busca = new ArrayList<Produto>(); //cria um novo arraylist que vai guardar os resultados da busca
	    	 
	    	 nome = normalizarString(nome);
	    	 
	    	 for (int i = Programa.produtos.size() - 1; i >= 0; i--) {
	    		 Produto p = Programa.produtos.get(i);
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
	    
	    public static String normalizarString(String string) {
	    	string = Normalizer.normalize(string, Normalizer.Form.NFD); //remove os acentos da string
	    	string = string.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		    string = string.toLowerCase(); //deixa a string toda em minusculo
		     
	    	return string;
	    }
	    
	    public static void filtrarProduto() {
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
	    	 
	    	 for(Produto p : Programa.produtos) {
	    		 if(classe.isInstance(p)) {
	    			 filtro.add(p);
	    		 }
	    	 }
	    	 
	    	 mostrarProdutos(filtro);
	    }
	    
	   public static void ordenarProduto() {
	         List<Produto> ordem = Programa.produtos;
		   
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
	   
	   
	    
	    public static void mostrarProdutos(List<Produto> lista) { //funcao interna para mostrar os produtos apos uma busca ou filtro
	    	 if (lista.isEmpty()) {
	             System.out.println("\nNenhum produto foi encontrado.");
	             return;
	         }
	    	 System.out.println("\nProdutos Encontrados:");
	         for (Produto p : lista) {
	         	System.out.println(p.toString());
	             System.out.println("----------------------------");
	         }
	    }}

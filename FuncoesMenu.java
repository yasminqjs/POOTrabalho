package executavel;

import java.util.ArrayList;
import java.util.List;

import entidades.Produto;

public class FuncoesMenu extends Programa {
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
        if (indice >= 0 && indice < produtos.size()) {
        	if (produtos.get(indice).getQuantidade() >= qntd) {
        	produtos.get(indice).setQuantidadeCarr(qntd);
        	produtos.get(indice).atualizarQuantidade();
        	carrinho.add(produtos.get(indice));
            System.out.println("Deseja adicionar mais algum item? (sim/nao)");
            scanner.nextLine();
            resposta = scanner.nextLine();
        	} else {
        		System.out.println("quantidade solicitada maior do que o estoque");
        	}
	}
        else {
            System.out.println("Produto não encontrado. Por favor, introduza um número entre 1 e " + produtos.size());
        }
		} while (resposta.equalsIgnoreCase("sim"));

}
	
	
	protected static void removerCarrinho(){
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
        carrinho.remove(indice);
        carrinho.get(indice).desfazCarr();
        scanner.nextLine();
        System.out.println("Deseja remover mais algum item? (sim/nao)");
        resposta = scanner.nextLine();
        
        	}
        else System.out.println("Produto não encontrado. Por favor, introduza um número entre 1 e " + carrinho.size());
		} while (resposta.equalsIgnoreCase("sim"));
		}
	    }
	
	
	protected static void verCarrinho() {
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
	
	
	pagarConta(){
		
		}
	
	protected static void tchauCarrinho() {
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
	}

package executavel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entidades.Maquiagem;
import entidades.Produto;
import entidades.ProdutoHigiene;
import interfaces.Exibivel;

public class Programa {
    private static List<Exibivel> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cadastrarAutomaticamente();
        menu();
    }

    public static void cadastrarAutomaticamente() {
        for (int i = 1; i <= 7; i++) {
            produtos.add(new Maquiagem(50 + i, 10 + i, "Base" + i, "12/2025", "Sim", "Não", "Bege", "Oleosa"));
            produtos.add(new ProdutoHigiene(10 + i, 5 + i, "Sabonete" + i, "11/2025", "Corporal"));
        }
    }

    public static void alterar() {
        System.out.print("Digite o nome do produto a ser alterado: ");
        String nomeBusca = scanner.nextLine();

        for (Exibivel e : produtos) {
            if (e instanceof Produto p && p.getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("Produto encontrado:");
                e.exibirInformacoes();

                System.out.print("Novo preço: ");
                p.setPreco(Double.parseDouble(scanner.nextLine()));

                System.out.print("Nova quantidade: ");
                p.setQuantidade(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nova validade: ");
                p.setValidade(scanner.nextLine());

                System.out.println("Produto alterado com sucesso!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
    public static void remover() {
        System.out.print("Digite o nome do produto a ser removido: ");
        String nomeBusca = scanner.nextLine();

        Iterator<Exibivel> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Exibivel e = iterator.next();
            if (e instanceof Produto p && p.getNome().equalsIgnoreCase(nomeBusca)) {
                iterator.remove();
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void menu() {
        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Buscar por nome");
            System.out.println("3. Alterar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> listar();
                case 2 -> buscar();
                case 3 -> alterar();
                case 4 -> remover();
                case 5 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }


    public static void listar() {
        System.out.println("\n--- Produtos Cadastrados ---");
        for (Exibivel p : produtos) {
            p.exibirInformacoes();
        }
    }

    public static void buscar() {
        System.out.print("Digite o nome do produto: ");
        String nomeBusca = scanner.nextLine();

        for (Exibivel p : produtos) {
            if (p instanceof Produto) {
                Produto prod = (Produto) p;
                if (prod.getNome().equalsIgnoreCase(nomeBusca)) {
                    p.exibirInformacoes();
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado.");
    }
}

package executavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;
import servicos.FuncoesMenu;

public class Programa {
	public static Scanner scanner = new Scanner(System.in);
    public static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        FuncoesMenu.cadastrarAutomaticamente();
        FuncoesMenu.cadastrarClientes();
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
            System.out.println("8. Atender Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> FuncoesMenu.cadastrarProduto();
                case 2 -> FuncoesMenu.listarProdutos();
                case 3 -> FuncoesMenu.alterarProduto();
                case 4 -> FuncoesMenu.removerProduto();
                case 5 ->FuncoesMenu. buscarProduto();
                case 6 -> FuncoesMenu.ordenarProduto();
                case 7 -> FuncoesMenu.filtrarProduto();
                case 8 -> FuncoesMenu.atenderCliente();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }}

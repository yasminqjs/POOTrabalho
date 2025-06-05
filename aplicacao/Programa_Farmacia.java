package aplicacao;

import java.util.Scanner;

public class Programa_Farmacia {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //declaracao do scanner
		boolean sair = false; //caso o usuario queira sair do programa, essa variavel sera verdadeira
		
		System.out.println("Bem vindo à Fármacia Pague Mais!");
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Listar produtos");
		System.out.println("2 - Sair");
		//colocar outras funcionalidades (se houver)
		
		//prende o usuario dentro do switch case para escanear novamente no caso de uma entrada invalida
		while(true) {
			
			//trata a entrada do usuario caso ela nao seja do tipo esperado (inteiro)
			while(!sc.hasNextInt()) {
				System.out.println("Entrada inválida. Tente Novamente:");
				sc.nextLine();			
			}
				int resposta = sc.nextInt();
				
			
				switch (resposta) {
				case 1:
					//codigo aqui
					break;
				case 2:
					sair = true;
					break;
				default: 
					System.out.println("Entrada inválida!");
					break;
				}
				if(sair = true) {break;}
		}
		
		//finalizacao do codigo
		System.out.println("Adeus!");
		sc.close();
	}

}

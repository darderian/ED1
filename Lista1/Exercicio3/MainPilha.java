package Lista1.Exercicio3;

import java.util.Scanner;

public class MainPilha {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Pilha pilha = new Pilha(20);
		int input = 0;
		int numero;

		do {
			imprimirDados();
			input = scanner.nextInt();
			switch (input){
				case 0:
					break;
				case 1:
					System.out.println("Qual numero voce quer adicionar na pilha 1?");
					numero = scanner.nextInt();
					pilha.push1((char)numero);

					System.out.println("Qual numero voce quer adicionar na pilha 2?");
					numero = scanner.nextInt();
					pilha.push2((char)numero);
					break;
				case 2:
					System.out.println("Numero removido primeira pilha: " + pilha.pop1());
					System.out.println("Numero removido da segunda pilha: " + pilha.pop2());
					break;
				case 3:
					System.out.println("Elementos da primeira pilha:");
					pilha.mostrarElementos1();
					System.out.println();
					System.out.println("Elementos da segunda pilha:");
					pilha.mostrarElementos2();
					break;
				default:
					System.out.println("Opção invalida, por favor selecione outra opcao.");
					break;

			}
		} while (input != 0);

		scanner.close();
	}

	private static void imprimirDados(){
		System.out.println("-------------------------------------------");
		System.out.println("Opcao 1: Adicionar numeros nas pilhas.");
		System.out.println("Opcao 2: Remover ultimo numero das pilhas.");
		System.out.println("Opcao 3: Mostrar numeros das duas pilhas.");
		System.out.println("Opcao 0: Sair.");
	}
}

package Lista2.Exercicio3;

import Lista1.Exercicio2.Pilha;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int escolha;

		do {
			escolha = menu();

			switch (escolha) {
				case 0:
					System.out.println("Saindo...");
					break;
				case 1:
					FilaDePilhas filaDePilhas = new FilaDePilhas(20);
					filaDePilhas.filaDePilhas();
					break;
				case 2:
					PilhaDeFilas pilhaDeFilas = new PilhaDeFilas(20);
					pilhaDeFilas.pilhaDeFilas();
					break;
				case 3:
					FilaDeFilas filaDeFilas = new FilaDeFilas(20);
					filaDeFilas.filaDeFilas();
					break;
				case 4:
					break;
				default:
					System.out.println("Opcao invalida.");
					break;
			}
		} while (escolha != 0);

		scanner.close();
	}

	private static int menu() {
		Scanner scanner = new Scanner(System.in);
		int escolha;

		System.out.println("--------------------------");
		System.out.println("Selecione a opcao:");
		System.out.println("1. Criar fila de pilhas.");
		System.out.println("2. Criar pilha de filas.");
		System.out.println("3. Criar fila de filas.");
		System.out.println("0. Sair.");
		System.out.print("Opcao: ");
		escolha = scanner.nextInt();

		return escolha;
	}
}

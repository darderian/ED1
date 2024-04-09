package Lista2.Exercicio4;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Fila filaCircular = new Fila(20);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Quantos inteiros voce deseja adicionar na fila circular simples?");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++){
			System.out.println("Digite o " + (i+1) + " inteiro.");
			int x = scanner.nextInt();
			filaCircular.insere(x);
		}

		Fila.transformarFila(filaCircular);
		System.out.println("-------------------");
		System.out.println("Fila transformada:");
		filaCircular.imprime();

		scanner.close();
	}
}

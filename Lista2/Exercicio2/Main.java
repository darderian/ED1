package Lista2.Exercicio2;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Fila f1 = new Fila(10);
		Fila f2 = new Fila(10);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Quantos elementos voce deseja inserir na fila 1?");
		int n1 = scanner.nextInt();

		for (int i=0; i<n1; i++){
			System.out.println("Insira o elemento " + (i+1) + " na fila 1.");
			int elemento = scanner.nextInt();
			f1.insere(elemento);
		}

		System.out.println("Quantos elementos voce deseja inserir na fila 2?");
		int n2 = scanner.nextInt();

		for (int i=0; i<n2; i++){
			System.out.println("Insira o elemento " + (i+1) + " na fila 2.");
			int elemento = scanner.nextInt();
			f2.insere(elemento);
		}

		f1.combinaFilas(f1, f2);

		scanner.close();
	}
}

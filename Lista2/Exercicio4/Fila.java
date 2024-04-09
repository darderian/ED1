package Lista2.Exercicio4;

import java.util.Scanner;

public class Fila
{
	/* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected int[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */

	public Fila(int tam)
	{
		tamanho = tam;
		vetor = new int[tamanho];
		ini = 0;
		n = 0;
	}

	public boolean vazia()
	{
		return (n == 0);
	}

	public boolean cheia()
	{
		return (n == tamanho);
	}

	//Retiramos o elemento do in�cio da fila
	public int remove()
	{
		int elemento = Integer.MIN_VALUE;

		if (!this.vazia())
		{
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		}

		return elemento;
	}

	//Inserimos o elemento no final da fila
	public boolean insere(int elemento)
	{
	  int fim;

	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = elemento;
	    n++;
	    return true;
	  }
	  else
	    return false;
	}

	public void imprime()
	{
		int i, j;

		if (vazia())
			System.out.println("Fila est� vazia.");
		else
			for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
				System.out.println(j + "- " + vetor[i]);
	}

	public static Fila transformarFila(Fila filaCircular){
		Scanner scanner = new Scanner(System.in);
		int escolha;

		do {
			escolha = menu();

			switch(escolha){
				case 0:
					System.out.println("Saindo...");
					break;
				case 1:
					System.out.println("Digite o inteiro.");
					int x = scanner.nextInt();
					filaCircular.insere(x);
					break;
				case 2:
					filaCircular.remove();
					filaCircular.imprime();
					break;
				case 3:
					System.out.println("Digite o inteiro que voce deseja adicionar no inicio da fila.");
					int inteiro = scanner.nextInt();

					int prec;

					if (!filaCircular.cheia())
					{
						prec = (filaCircular.ini - 1 + filaCircular.tamanho) % filaCircular.tamanho;
						filaCircular.vetor[prec] = inteiro;
						filaCircular.ini = prec;
						filaCircular.n++;
					}
					else
						System.out.println("Fila cheia! Não foi possivel adicionar o inteiro.");
					break;
				case 4:
					int elemento = Integer.MIN_VALUE;
					int ult;

					if (!filaCircular.vazia())
					{
						ult = (filaCircular.ini + filaCircular.n - 1) % filaCircular.tamanho;
						elemento = filaCircular.vetor[ult];
						filaCircular.n--;
						System.out.println("Inteiro: " + elemento + " removido com sucesso.");
					} else
						System.out.println("Fila vazia.");
					break;
				case 5:
					filaCircular.imprime();
					break;
				default:
					System.out.println("Entrada errada! Por favor, selecione outra entrada.");
					break;
			}
		} while (escolha != 0);

		scanner.close();
		return filaCircular;
	}

	private static int menu()
	{
		Scanner scanner = new Scanner(System.in);
		int escolha;

		System.out.println("--------------------------");
		System.out.println("Selecione a opcao:");
		System.out.println("1. Insere inteiro no fim da fila.");
		System.out.println("2. Remove inteiro do in�cio da fila.");
		System.out.println("3. Insere inteiro no in�cio da fila.");
		System.out.println("4. Remove inteiro do fim da fila.");
		System.out.println("5. Imprime inteiros a partir do in�cio da fila.");
		System.out.println("0. Fim.");
		System.out.println("Opcao: ");
		escolha = scanner.nextInt();

		return escolha;
	}
}
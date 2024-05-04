package Lista4.Exercicio1;

import java.util.Scanner;

public class TesteListaSingular
{
	private int apresentaMenu()
	{
		int escolha;

		Scanner scanner = new Scanner(System.in);

		System.out.println("--------------------------\n");
		System.out.println("Selecione uma opcao:\n");
		System.out.println("1. Insere elemento (no. inteiro) na lista\n");
		System.out.println("2. Remove elemento (no. inteiro) da lista\n");
		System.out.println("3. Imprime elementos da lista.\n");
		System.out.println("4. Retorna o tamanho da lista.\n");
		System.out.println("0. Fim.\n");
		System.out.println("Sua opcao: ");

		escolha = scanner.nextInt();

		return escolha;
	}
	
	public void valida(Lista4.Exercicio1.Lista lista)
	{
		int escolha, elem;

		Scanner scanner = new Scanner(System.in);

		do
		{
			escolha = apresentaMenu();

			switch(escolha)
			{
			case 0:
				break;
			case 1:
				System.out.println("Entre com elemento para inserir: ");
				elem = scanner.nextInt();
				lista.insere(elem);
				break;
			case 2:
				System.out.println("Entre com elemento para remover: ");
				elem = scanner.nextInt();
				if (lista.remove(elem))
					System.out.println("Elemento " + elem + " removido.\n");
				else
					System.out.println("Elemento n�o existe!\n");
				break;
			case 3:
				System.out.println("Conte�do da lista:\n");
				lista.imprimeRecursivo();
				break;
			case 4:
				System.out.println("Tamanho da lista = " + lista.tamanho);
				break;
			default:
				System.out.println("Entrada invalida.");
				break;
			}

		}while(escolha != 0);
				
		scanner.close();
	}
}
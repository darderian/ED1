package Lista2.Exercicio5;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Fila fila = new Fila(50);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira um inteiro N >= 1:");
		int n = scanner.nextInt();

		for (int i = 1; i <= n; i++){
			String representacaoBinaria = transformarEmBinario(i);
			fila.insere(representacaoBinaria);
		}

		fila.imprime();

		scanner.close();
	}

	public static String transformarEmBinario(int num){
		StringBuilder binario = new StringBuilder();
		while (num > 0){
			binario.insert(0, num % 2);
			num /=2;
		}
		return binario.toString();
	}
}

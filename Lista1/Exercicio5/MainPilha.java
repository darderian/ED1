package Lista1.Exercicio5;

import java.util.Scanner;

public class MainPilha
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Pilha pilha = new Pilha(50);
		String s;
		String abrir = "{[(";
		String fechar = "}])";
		boolean balanceado = false;
		char topo;
		Object aux;


		System.out.println("Entre com a String desejada:");
		s = scanner.nextLine();

		for(int i=0; i < s.length(); i++){

			if (abrir.contains(Character.toString(s.charAt(i)))){
				pilha.push(s.charAt(i));
			} else if (fechar.contains(Character.toString(s.charAt(i)))) {
				aux = pilha.retornaTopo();
				topo = (char) aux;
				if ((s.charAt(i) == ')' && topo == '(') || (s.charAt(i) == '}' && topo == '{') || (s.charAt(i) == ']' && topo == '[')) {
					balanceado = true;
					pilha.pop();
				} else {
					balanceado = false;
					break;
				}
			}
		}
		if (balanceado)
			System.out.println("A sentenca esta balanceada.");
		else
			System.out.println("A sentenca nao esta balanceada.");

		scanner.close();
	}
}

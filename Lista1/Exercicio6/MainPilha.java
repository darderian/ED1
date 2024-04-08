package Lista1.Exercicio6;

import java.util.Scanner;

public class MainPilha
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		String s;
				
		System.out.println("Entre com uma frase: ");
		s = scanner.nextLine();

		retornarFraseInvertida(s);
		scanner.close();
	}

	private static void retornarFraseInvertida(String s){
		PilhaGenerica<Character> pilha = new PilhaGenerica<>(50);
		StringBuilder fraseInvertida = new StringBuilder();
		char c;

		for (int i=0; i<s.length(); i++){
			while(i<s.length() && s.charAt(i) != ' '){
				c = s.charAt(i);
				pilha.push(c);
				i++;
			}

			while (!pilha.vazia()){
				c = pilha.pop();
				fraseInvertida.append(c);
			}
			fraseInvertida.append(' ');
		}

		System.out.println("Frase invertida: " + fraseInvertida.toString().trim());
	}
}

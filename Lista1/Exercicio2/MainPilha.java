package Lista1.Exercicio2;

import java.util.Scanner;

public class MainPilha
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		String s;

		System.out.println("Digite a String desejada:");
		s = scanner.nextLine();

		System.out.println(determinarString(s));

		scanner.close();
	}

	private static boolean determinarString(String s){
		char c1, c2;
		int i = 0;
		Pilha pilhaX = new Pilha(20);
		Pilha pilhaY = new Pilha(20);
		Pilha pilhaAux = new Pilha(20);

		while (i < s.length()) {
			while (i < s.length() && s.charAt(i) != 'C') {
				c1 = s.charAt(i);
				pilhaX.push(c1);
				i++;
			}

			i++;

			while (i < s.length() && s.charAt(i) != 'D') {
				c2 = s.charAt(i);
				pilhaY.push(c2);
				i++;
			}

			i++;

			while (!pilhaY.vazia()) {
				c2 = pilhaY.pop();
				pilhaAux.push(c2);
			}


			while (!pilhaX.vazia() && !pilhaAux.vazia()) {
				c1 = pilhaX.pop();
				c2 = pilhaAux.pop();
				if (c1 != c2) {
					return false;
				}
			}
		}
		return pilhaX.vazia() && pilhaAux.vazia();

	}
}

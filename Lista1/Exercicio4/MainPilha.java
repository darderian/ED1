package Lista1.Exercicio4;

import java.util.Scanner;

public class MainPilha
{
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite a quantidade de elementos que serão colocadas na pilha.");
		n = scanner.nextInt();

		removerElementoPilha(n);
		scanner.close();
	}

	public static <T> void removerElementoPilha(int n){
		PilhaGenerica<T> pilha = new PilhaGenerica<>(n);
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<n; i++){
			System.out.println("Digite o " + (i+1) + "º elemento da pilha.");
			T x = (T) scanner.next();
			pilha.push(x);
		}

		System.out.println("Digite o valor do elemento que você quer remover");
		T elemento = (T) scanner.next(); // Elemento a ser removido

		PilhaGenerica<T> aux = new PilhaGenerica<>(n); // Pilha auxiliar

		T topo;
		while (!pilha.vazia()) {
			topo = pilha.pop(); // Remove o elemento do topo da pilha original

			if (!topo.equals(elemento)) // Verifica se o elemento removido não é o desejado
				aux.push(topo); // Se não for, coloca de volta na pilha auxiliar
		}

		// Restaurando a pilha original com os elementos que não foram removidos
		while (!aux.vazia()) {
			pilha.push(aux.pop());
		}
		int k=n;
		for (int i=0; i < (n-1); i++){

			System.out.println((k-1) + "º elemento: " + pilha.pop());
			k--;
		}
	}
}
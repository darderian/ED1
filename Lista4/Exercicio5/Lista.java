package Lista4.Exercicio5;

import java.lang.StringBuilder;

public class Lista<T> {
	protected Elo<T> prim;

	protected class Elo<E> {
		protected E dado;
		protected Elo<E> prox;

		public Elo() {
			prox = null;
		}

		public Elo(E elem) {
			dado = elem;
			prox = null;
		}

		public Elo(E elem, Elo<E> proxElem) {
			dado = elem;
			prox = proxElem;
		}
	}

	public Lista() {
		prim = null;
	}

	public boolean vazia() { //Complexidade O(1)
		return prim == null;
	}

	public void imprime() {
		Elo<T> p;

		System.out.println("Elementos da lista:");

		for (p = prim; p != null; p = p.prox) {
			System.out.print(p.dado + " ");
		}

		System.out.println();
	}

	public int tamanho() {
		int tam = 0;
		Elo p = prim;

		while (p != null) {
			tam++;
			p = p.prox;
		}

		return tam;
	}

	public void insere(T elem) {
		Elo<T> p = new Elo<T>(elem);

		p.prox = prim;
		prim = p;
	}

	public void inverteAsLetrasDasPalavras() {
		Elo<T> p;
		for (p = prim; p != null; p = p.prox) {
			inverteAsLetrasDasPalavras(p);
		}
	}

	private void inverteAsLetrasDasPalavras(Elo<T> p) {
		StringBuilder palavraReversa = new StringBuilder();
		String palavraOriginal = p.dado.toString();

		for (int i = palavraOriginal.length() - 1; i >= 0; i--) {
			palavraReversa.append(palavraOriginal.charAt(i));
		}

		p.dado = (T) palavraReversa.toString();
	}
}
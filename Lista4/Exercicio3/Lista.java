package Lista4.Exercicio3;

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

	public void imprime() { //Complexidade O(n)
		Elo<T> p;

		System.out.println("Elementos da lista:");

		for (p = prim; p != null; p = p.prox) {
			System.out.print(p.dado + " \n");
		}

		System.out.println();
	}

	public int tamanho() { //Complexidade O(n)
		int tam = 0;
		Elo p = prim;

		while (p != null) {
			tam++;
			p = p.prox;
		}

		return tam;
	}
}
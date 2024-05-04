package Lista4.Exercicio4;

public class Lista<T> {
	protected Elo<T> prim;
	protected Elo<T> ult;

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

		if (vazia()) {
			prim = p;
			ult = p;
		} else {
			ult.prox = p;
			ult = p;
		}
	}
}
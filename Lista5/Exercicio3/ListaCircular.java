package Lista5.Exercicio3;

public class ListaCircular extends Lista {
	public void imprime() {
		Elo p;
		System.out.println("Elementos da lista");

		p = prim;

		if (p != null) {
			do {
				System.out.print(p.dado + " ");
				p = p.prox;

			} while (p != prim);
		}

		System.out.println();
	}

	public void insere(int novo) {
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null) {
			/* Percorre at� alcancar o in�cio. */
			while (p.prox != prim) {
				p = p.prox;
			}

			p.prox = q;
			q.prox = prim;
		} else {
			prim = q;
			prim.prox = q;
		}
	}

	public boolean remove(int elem) {
		Elo p = null;
		Elo ant = null;

		if (prim == null) return false;

		for (p = prim; ((p.prox != prim) && (p.dado != elem)); p = p.prox)
			ant = p;

		if (p.dado == elem) {
			if (p == prim) {
				if (prim == prim.prox) {
					prim = null;
				} else {
					for (ant = prim; (ant.prox != prim); ant = ant.prox) ;

					ant.prox = prim.prox;
					prim = prim.prox;
				}
			} else {
				ant.prox = p.prox;
			}

			p = null;

			return true;
		} else
			return false;
	}

	public ListaCircular inverteLista(){
		if (prim == null || prim.prox == prim) {
			return this;
		}

		Elo anterior = null;
		Elo atual = prim;
		Elo proximo;

		do {
			proximo = atual.prox;
			atual.prox = anterior;
			anterior = atual;
			atual = proximo;
		} while (atual != prim);

		prim.prox = anterior;
		prim = anterior;

		return this;
	}
}
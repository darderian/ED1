package Lista5.Exercicio2;

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

	public ListaCircular merge(ListaCircular lista2) {
		return mergeAlternating(this, lista2);
	}

	private static ListaCircular mergeAlternating(ListaCircular lista1, ListaCircular lista2) {
		ListaCircular resultado = new ListaCircular();

		Elo p1 = lista1.prim;
		Elo p2 = lista2.prim;

		while (p1 != null || p2 != null) {
			if (p1 != null) {
				resultado.insere(p1.dado);
				p1 = p1.prox;
			}

			if (p2 != null) {
				resultado.insere(p2.dado);
				p2 = p2.prox;
			}

			if (p1 == lista1.prim && p2 == lista2.prim) {
				break;
			}
		}
		return resultado;
	}
}
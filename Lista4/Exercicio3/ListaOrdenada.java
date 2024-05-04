package Lista4.Exercicio3;

public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> {

	public void insere(T novo) { //Complexidade O(n)
		Elo<T> p, ant = null;

		Elo<T> q = new Elo<T>(novo);

		for (p = prim; (p != null) && (p.dado.compareTo(novo) < 0); p = p.prox)
			ant = p;

		if (ant == null)
			prim = q;
		else
			ant.prox = q;

		q.prox = p;
	}

	public boolean remove(T elem) { //Complexidade O(n)
		Elo<T> p;
		Elo<T> ant = null;

		for (p = prim; (p != null) && (p.dado.compareTo(elem) != 0); p = p.prox)
			ant = p;

		if ((p == null) || (p.dado.compareTo(elem) != 0))
			return false;

		if (p == prim)
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;

		return true;
	}
}
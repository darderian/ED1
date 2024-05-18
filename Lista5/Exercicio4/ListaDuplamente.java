package Lista5.Exercicio4;

public class ListaDuplamente {
	protected Elo prim;

	protected class Elo {
		protected int dado;
		protected Elo ant;
		protected Elo prox;

		public Elo() {
			ant = null;
			prox = null;
		}

		public Elo(int elem) {
			dado = elem;
			ant = null;
			prox = null;
		}

		public Elo(int elem, Elo antElem, Elo proxElem) {
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}

	public ListaDuplamente() {
		prim = null;
	}

	public boolean vazia() {
		return prim == null;
	}

	public void insere(int novo) {
		Elo p;

		p = new Elo(novo);

		p.prox = prim;

		p.ant = null;

		if (prim != null)
			prim.ant = p;

		prim = p;
	}

	private Elo busca(int elem) {
		Elo p = null;

		for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox) ;

		return p;
	}

	public boolean remove(int elem) {
		Elo p = null;
		p = busca(elem);

		if (p == null) return false;

		if (p == prim)
			prim = prim.prox;
		else
			p.ant.prox = p.prox;
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;

		return true;
	}

	public void imprime() {
		Elo p;
		int contador = 0;
		System.out.println("Elementos da lista:");

		for (p = prim; p != null; p = p.prox) {
			System.out.print("Indice " + contador + "- " + p.dado + "\n");
			contador++;
		}

		System.out.println();
	}

	public void trocaElos(int indiceElo1, int indiceElo2) {
		if (indiceElo1 == indiceElo2) return;

		// Busca pelos elos com base nos índices
		Elo elo1 = buscaPorIndice(indiceElo1);
		Elo elo2 = buscaPorIndice(indiceElo2);

		// Verifica se os elos foram encontrados
		if (elo1 == null || elo2 == null) {
			System.out.println("Um dos índices fornecidos não corresponde a nenhum elo na lista.");
			return;
		}

		// Atualiza os elos anteriores e posteriores
		if (elo1.ant != null) {
			elo1.ant.prox = elo2;
		} else {
			prim = elo2;
		}

		if (elo2.ant != null) {
			elo2.ant.prox = elo1;
		} else {
			prim = elo1;
		}

		if (elo1.prox != null) {
			elo1.prox.ant = elo2;
		}

		if (elo2.prox != null) {
			elo2.prox.ant = elo1;
		}

		// Troca os elos de posição na lista
		Elo temp = elo1.prox;
		elo1.prox = elo2.prox;
		elo2.prox = temp;

		temp = elo1.ant;
		elo1.ant = elo2.ant;
		elo2.ant = temp;
	}

	private Elo buscaPorIndice(int indice) {
		if (indice < 0) {
			return null; // Índice inválido
		}

		Elo p = prim;
		int contador = 0;

		while (p != null && contador < indice) {
			p = p.prox;
			contador++;
		}

		return p;
	}
}
package Lista4.Exercicio7;

public class ListaCircular extends Lista {

	public void inserir(Inimigo inimigo) {
		Elo novo = new Elo(inimigo);

		if (prim == null) {
			prim = novo;
			prim.prox = prim;
		} else {
			Elo p = prim;
			while (p.prox != prim) {
				p = p.prox;
			}
			p.prox = novo;
			novo.prox = prim;
		}
	}

	public Inimigo localizar(Inimigo inimigo) {
		Elo p = prim;
		do {
			if (p.inimigo == inimigo) {
				return p.inimigo;
			}
			p = p.prox;
		} while (p != prim);
		return null;
	}

	public int efetuarDano(Inimigo inimigo, double dano) {
		Elo p = prim;
		Elo ant = null;
		do {
			if (p.inimigo == inimigo) {
				p.inimigo.setVida(p.inimigo.getVida() - (int) dano);

				if (p.inimigo.getVida() <= 0) {
					if (p == prim) {
						prim = prim.prox;
						ant = prim;
						while (ant.prox != p) {
							ant = ant.prox;
						}
						ant.prox = prim;
					} else {
						ant.prox = p.prox;
					}
					return 1;
				}
				return 0;
			}
			ant = p;
			p = p.prox;
		} while (p != prim);
		return -1;
	}
}

package Lista4.Exercicio2;

public class ListaOrdenada extends Lista4.Exercicio2.Lista
{
	/* Insere elemento na lista na posi��o adequada, mantendo-a ordenada. */
	public void insere(int novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p;
		Elo ant = null; /* refer�ncia para anterior */
		
		for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
			ant = p;
		
		/* Se p � null ou p.dado != elem, ent�o n�o encontrou elemento. */
		if ((p == null) || (p.dado != elem))
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do in�cio. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
		 * o Garbage Collector ir� liberar essa mem�ria. */
		p = null;
		
		return true;
	}

	private int passarElementoParaAux()
	{
		Elo p = prim;
		int aux = Integer.MIN_VALUE;

		if(p != null){
			aux = prim.dado;
			prim = prim.prox;
		}

		return aux;
	}
	public ListaOrdenada mesclarListas(ListaOrdenada lista1, ListaOrdenada lista2){
		ListaOrdenada listaAux = new ListaOrdenada();

		while(!lista1.vazia() && !lista2.vazia()){
			listaAux.insere(lista1.passarElementoParaAux());
			listaAux.insere(lista2.passarElementoParaAux());
		}

		return listaAux;
	}
}
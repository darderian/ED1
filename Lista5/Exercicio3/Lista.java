package Lista5.Exercicio3;

public class Lista
{
	protected Elo prim;
	
	protected class Elo
	{
		protected int dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(int elem)
		{
			dado = elem;
			prox = null;
		}
		
		public Elo(int elem, Elo proxElem)
		{
			dado = elem;
			prox = proxElem;
		}
	}
	
	public Lista()
	{
		prim = null;
	}

	public boolean vazia()
	{
		return prim == null;
	}

	public void insere(int novo)
	{
		Elo p = new Elo(novo);
		p.prox = prim;
		prim = p;
	}

	public boolean remove(int elem)
	{
		Elo p;
		Elo ant = null;
		
		for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			ant = p;

		if (p == null)
			return false;
		
		if (p == prim)
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;
		
		return true;
	}

	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}

	public int tamanho()
	{
		int tam = 0;
		Elo p = prim;
		
		while(p != null)
		{
			tam++;
			p = p.prox;
		}
		
		return tam;
	}
}
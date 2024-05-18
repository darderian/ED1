package Lista5.Exercicio1;

public class ListaDuplamente
{
	protected Elo prim;
	
	protected class Elo
	{
		protected int dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(int elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(int elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public ListaDuplamente()
	{
		prim = null;
	}

	public boolean vazia()
	{
		return prim == null;
	}

	public void insere(int novo)
	{
		Elo p;

		p = new Elo(novo);
		
		p.prox = prim;
		
		p.ant = null;
		
		if (prim != null)
			prim.ant = p;
		
		prim = p;

	}

	private int buscaPrimeiro(int elem)
	{
		Elo p = null;
		
		for(p = prim; p != null; p = p.prox){
			if (elem == p.dado) return p.dado;
		}
		return Integer.MIN_VALUE;
	}

	private Elo busca(int elem)
	{
		Elo p = null;

		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;
	}

	public int removePrimeiro(){
		Elo p = prim;
		if (p == null) return Integer.MIN_VALUE;
		int x = prim.dado;
		prim = prim.prox;

		if(p.prox != null)
			p.prox.ant = p.ant;

		return x;
	}

	public boolean remove(int elem)
	{
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

	public static ListaDuplamente intersecaoListas(ListaDuplamente l1, ListaDuplamente l2){
		ListaDuplamente l3 = new ListaDuplamente();
		Elo p = l1.prim;

		while (p != null){
			if (l2.busca(p.dado) != null){
				l3.insere(p.dado);
			}
			p = p.prox;
		}

		return l3;
	}
}
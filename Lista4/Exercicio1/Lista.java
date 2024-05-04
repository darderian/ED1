package Lista4.Exercicio1;

public class Lista
{
	protected Elo prim;
	protected int tamanho;
	
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
		tamanho = 0;
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
		tamanho++;
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
		tamanho--;
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

	public void imprimeRecursivo()
	{
		System.out.println("Elementos da lista:");
		
		if(this.vazia())
			return;
		
		imprimeRecursivo(prim);
		
		System.out.println();
	}
	
	private void imprimeRecursivo(Elo p)
	{
		if(p == null)
			return;
		
		System.out.print(p.dado + " ");
		
		imprimeRecursivo(p.prox);
	}

	public int tamanho()
	{
		return tamanho;
	}
}
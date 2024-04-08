package Lista1.Exercicio3;

public class Pilha
{
	private int n;
	private int vetor[];
	private int topo1;

	private int topo2;
	
	public Pilha()
	{
		n = 10;
		vetor = new int[n];
		topo1 = -1;
		topo2 = n;
	}
	
	public Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new int[tamanho];
		topo1 = -1;
		topo2 = n;
	}
	
	public boolean vazia1()
	{
		return topo1 == -1 ? true : false;
	}

	public boolean vazia2() { return topo2 == n - 1? true : false; }
	
	public boolean cheia1()
	{
		return topo1 + 1 == topo2 ? true : false;
	}

	public boolean cheia2() { return topo2 - 1 == topo1 ? true : false; }
	
	public int pop1()
	{
		int numero = -1;

		if (!this.vazia1())
		{
			numero = vetor[topo1];
			topo1--;
		}
		else
		{
			System.out.println("Pilha 1 vazia: pop não funcionou.");
		}

		return numero;
	}

	public int pop2()
	{
		int numero = -1;

		if (!this.vazia2())
		{
			numero = vetor[topo2];
			topo2++;
		}
		else
		{
			System.out.println("Pilha 2 vazia: pop não funcionou.");
		}

		return numero;
	}

	public boolean push1(int elemento)
	{
		if (!this.cheia1())
		{
			vetor[++topo1] = elemento;
			return true;
		}
		else
		{
			System.out.println("Pilha 1 cheia: push não funcionou.\n");
			return false;
		}
	}

	public boolean push2(int elemento)
	{
		if (!this.cheia2())
		{
			vetor[--topo2] = elemento;
			return true;
		}
		else
		{
			System.out.println("Pilha 2 cheia: push não funcionou.\n");
			return false;
		}
	}


	public void mostrarElementos1() {
		System.out.print("Pilha 1: ");
		for (int i = 0; i <= topo1; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println();
	}

	public void mostrarElementos2() {
		System.out.print("Pilha 2: ");
		for (int i = n - 1; i >= topo2; i--) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println();
	}
}
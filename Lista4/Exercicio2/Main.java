package Lista4.Exercicio2;

public class Main
{
	public static void main(String[] args)
	{
		ListaOrdenada lista1 = new ListaOrdenada();
		lista1.insere(2);
		lista1.insere(9);
		lista1.insere(5);
		lista1.insere(1);

		ListaOrdenada lista2 = new ListaOrdenada();
		lista2.insere(3);
		lista2.insere(8);
		lista2.insere(4);
		lista2.insere(6);

		ListaOrdenada lista3 = new ListaOrdenada();
		lista3 = lista3.mesclarListas(lista1, lista2);

		lista3.imprime();
	}
}
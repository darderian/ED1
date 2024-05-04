package Lista4.Exercicio3;

public class Main
{
	public static void main(String[] args) //O(1)
	{
		ListaOrdenada<String> lista = new ListaOrdenada<String>();
		lista.insere("Caio");
		lista.insere("Julia");
		lista.insere("Joao");
		lista.insere("Gabriel");
		lista.insere("Maria");
		lista.insere("Bernardo");
		lista.insere("Leandro");
		lista.insere("Bernarda");

		lista.imprime();
	}
}
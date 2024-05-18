package Lista5.Exercicio3;

public class Main {
    public static void main(String [] args){

        /*
        A complexidade do método é O(n), pois, se a lista tiver n elementos o loop executa essas operações n vezes.
        */

        ListaCircular lista = new ListaCircular();

        lista.insere(2);
        lista.insere(3);
        lista.insere(5);
        lista.insere(6);
        lista.insere(7);
        lista.insere(9);

        System.out.println("Lista original:");
        lista.imprime();

        lista.inverteLista();

        System.out.println("Lista invertida:");
        lista.imprime();
    }
}

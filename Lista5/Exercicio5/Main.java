package Lista5.Exercicio5;

public class Main {
    public static void main(String[] args) {
       /*
       A complexidade de tempo é O(n), onde n é o número de elementos na lista mais longa entre a lista atual (this)
       a lista fornecida como argumento (lista2).
       Isso ocorre porque o método faz uma única chamada recursiva para cada elemento em ambas as listas,
       e cada elemento é comparado uma vez.
       */

        ListaDuplamente l1 = new ListaDuplamente();
        ListaDuplamente l2 = new ListaDuplamente();
        ListaDuplamente l3 = new ListaDuplamente();

        for (int i = 0; i < 5; i++)
        {
            l1.insere(i);
            l2.insere(i);
            l3.insere(i + 1);
        }

        System.out.println(l1.verificaIgualdade(l2));
        System.out.println(l1.verificaIgualdade(l3));

    }
}

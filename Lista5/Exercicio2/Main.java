package Lista5.Exercicio2;

public class Main {
    public static void main(String[] args){

        /*
        A complexidade computacional alcançada é de O(n²), pois, deve-se percorrer 2 listas de tamanho n para realizar o método.
        */

        ListaCircular l1 = new ListaCircular();
        l1.insere(1);
        l1.insere(3);
        l1.insere(5);
        l1.insere(7);
        l1.insere(9);

        ListaCircular l2 = new ListaCircular();

        l2.insere(2);
        l2.insere(4);
        l2.insere(6);
        l2.insere(8);
        l2.insere(10);

        ListaCircular lista3 = l1.merge(l2);
        lista3.imprime();
    }
}

package Lista5.Exercicio1;

public class Main {
    public static void main(String[] args){
        /*
        Para cada elemento em l1, realizei uma busca em l2, que é uma operação de complexidade O(n).
        */

        ListaDuplamente l1 = new ListaDuplamente();
        ListaDuplamente l2 = new ListaDuplamente();

        l1.insere(3);
        l1.insere(4);
        l1.insere(5);
        l1.insere(7);
        l1.insere(9);

        l2.insere(3);
        l2.insere(4);
        l2.insere(6);
        l2.insere(8);
        l2.insere(9);

        ListaDuplamente l3 = ListaDuplamente.intersecaoListas(l1, l2);

        l1.imprime();
        l2.imprime();
        l3.imprime();
    }
}

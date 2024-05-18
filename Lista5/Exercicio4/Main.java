package Lista5.Exercicio4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /*
        O método percorre a lista até 2 vezes para buscar os elos nos índices especificados, resultando
        em uma complexidade O(n), onde n é o número de elementos da lista.
        */

        ListaDuplamente lista = new ListaDuplamente();
        Scanner scanner = new Scanner(System.in);

        lista.insere(56);
        lista.insere(81);
        lista.insere(73);
        lista.insere(86);
        lista.insere(52);
        lista.insere(46);
        lista.insere(33);
        lista.insere(27);
        lista.insere(43);

        System.out.println("Lista atual:");
        lista.imprime();

        System.out.println("Insira os indices que voce deseja trocar\n");

        System.out.println("Primeiro indice:");
        int indiceElo1 = scanner.nextInt();
        System.out.println("\nSegundo indice:");
        int indiceElo2 = scanner.nextInt();

        lista.trocaElos(indiceElo1, indiceElo2);
        System.out.println("Lista atualizada:");
        lista.imprime();
    }
}

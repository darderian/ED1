package Lista5.Exercicio6;

public class Main {
    public static void main(String[] args){

        /*
        A complexidade é O(n), pois para organizar as chamadas, devemos percorrer toda a lista encadeada com tamanho n.
        */

        CentralDeAtendimento central = new CentralDeAtendimento();
        Chamada c1 = new Chamada(10, "Brazil");
        Chamada c2 = new Chamada(5, "Paraguay");
        Chamada c3 = new Chamada(5, "Uruguay");
        Chamada c4 = new Chamada(3, "United States");
        Chamada c5 = new Chamada(20, "England");

        central.adicionarChamada(c1);
        central.adicionarChamada(c2);
        central.adicionarChamada(c3);
        central.adicionarChamada(c4);
        central.adicionarChamada(c5);

        central.imprimirFila();
    }
}
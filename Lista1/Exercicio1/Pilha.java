package Lista1.Exercicio1;

public class Pilha {
    private int n;
    private char vetor[];
    private int topo;

    public Pilha() {
        n = 10;
        vetor = new char[n];
        topo = -1;
    }

    public Pilha(int tamanho) {
        n = tamanho;
        vetor = new char[tamanho];
        topo = -1;
    }

    public boolean vazia() {
        return topo == -1 ? true : false;
    }

    public boolean cheia() {
        return topo == n - 1 ? true : false;
    }

    public char pop() {
        char c = '\0';

        if (!this.vazia()) {
            c = vetor[topo];
            topo--;
        } else {
            System.out.println("Ex1.Pilha vazia: pop não funcionou.");
        }

        return c;
    }

    public boolean push(char elemento) {
        if (!this.cheia()) {
            vetor[++topo] = elemento;
            return true;
        } else {
            System.out.println("Ex1.Pilha cheia: push não funcionou.\n");
            return false;
        }
    }

    public char retornaTopo() {
        char elemento = '\0';

        if (!this.vazia()) {
            elemento = vetor[topo];
        } else {
            System.out.println("Ex1.Pilha vazia.");
        }

        return elemento;
    }

    public void imprime() {
        for (int i = topo; i >= 0; i--)
            System.out.println("Elemento: " + vetor[i]);
    }
}
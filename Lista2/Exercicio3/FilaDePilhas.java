package Lista2.Exercicio3;

import java.util.Scanner;

public class FilaDePilhas {
    private int tamanho;    /* Tamanho do vetor */
    private Pilha[] vetor;  /* Vetor de elementos */
    private int ini;        /* Posicao do proximo elemento a ser retirado */
    private int n;          /* Numero de elementos na fila */

    public FilaDePilhas(int tam) {
        tamanho = tam;
        vetor = new Pilha[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia() {
        return (n == 0);
    }

    public boolean cheia() {
        return (n == tamanho);
    }

    public Pilha remove() {
        Pilha elemento = null;

        if (!this.vazia()) {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    public boolean insere(Pilha pilha) {
        if (!cheia()) {
            int fim = (ini + n) % tamanho;
            vetor[fim] = pilha;
            n++;
            return true;
        } else
            return false;
    }

    //Retiramos o elemento do início da fila

    public void imprime() {
        if (vazia())
            System.out.println("Fila esta vazia.");
        else {
            for (int i = 0; i < n; i++) {
                int index = (ini + i) % tamanho;
                System.out.println("Pilha " + (i + 1) + ":");
                vetor[index].imprime();
            }
        }
    }

    public void filaDePilhas() {
        int input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----------------------------------");
            System.out.println("Selecione a opcao.");
            System.out.println("1: Adicionar uma pilha na fila.");
            System.out.println("2: Remover uma pilha da fila.");
            System.out.println("3: Imprimir a fila.");
            System.out.println("4: Sair");
            System.out.println("Opcao:");
            input = scanner.nextInt();

            switch (input) {
                case 4:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    Pilha pilha = new Pilha(3);
                    char c;
                    System.out.println("Insira 3 caracteres na pilha:");
                    for (int i = 0; i < 3; i++) {
                        System.out.println((i + 1) + ": ");
                        c = scanner.next().charAt(0);
                        pilha.push(c);
                    }
                    insere(pilha);
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    imprime();
                    break;
                default:
                    System.out.println("Entrada errada, selecione outra.");
                    break;
            }
        } while (input != 4);
        scanner.close();
    }

    private class Pilha {
        private int n;
        private char vetor[];
        private int topo;

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
                System.out.println("Pilha vazia: pop não funcionou.");
            }

            return c;
        }

        public boolean push(char elemento) {
            if (!this.cheia()) {
                vetor[++topo] = elemento;
                return true;
            } else {
                System.out.println("Pilha cheia: push não funcionou.\n");
                return false;
            }
        }

        public void imprime() {
            for (int i = 0; i <= topo; i++) {
                System.out.println("Caractere " + (i + 1) + ": " + vetor[i]);
            }
        }
    }
}

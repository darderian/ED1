package Lista2.Exercicio3;

import java.util.Scanner;

public class FilaDeFilas {
    private int tamanho;    /* Tamanho do vetor */
    private Fila[] vetor;   /* Vetor de elementos */
    private int ini;        /* Posicao do proximo elemento a ser retirado */
    private int n;          /* Numero de elementos na fila */

    public FilaDeFilas(int tam) {
        tamanho = tam;
        vetor = new Fila[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia() {
        return (n == 0);
    }

    public boolean cheia() {
        return (n == tamanho);
    }

    public Fila remove() {
        Fila elemento = null;

        if (!this.vazia()) {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    public boolean insere(Fila fila) {
        if (!cheia()) {
            int fim = (ini + n) % tamanho;
            vetor[fim] = fila;
            n++;
            return true;
        } else
            return false;
    }

    public void imprime() {
        if (vazia())
            System.out.println("Fila de Filas está vazia.");
        else {
            for (int i = 0; i < n; i++) {
                int index = (ini + i) % tamanho;
                System.out.println("Fila " + (i + 1) + ":");
                vetor[index].imprime();
            }
        }
    }

    public void filaDeFilas() {
        int input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Selecione uma opcao");
            System.out.println("1: Adicionar uma fila na fila de filas.");
            System.out.println("2: Remover uma fila da fila de filas.");
            System.out.println("3: Imprimir a fila de filas.");
            System.out.println("4: Sair");
            System.out.println("Opcao:");
            input = scanner.nextInt();

            switch (input) {
                case 4:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    Fila fila = new Fila(3);
                    int[] elementos = new int[3];
                    System.out.println("Insira 3 inteiros na fila:");
                    for (int i = 0; i < 3; i++) {
                        System.out.print((i + 1) + ": ");
                        elementos[i] = scanner.nextInt();
                    }
                    for (int elemento : elementos) {
                        fila.insere(elemento);
                    }
                    insere(fila);
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

    private class Fila {
        private int tamanho;    /* Tamanho do vetor */
        private int[] vetor;    /* Vetor de elementos */
        private int ini;        /* Posicao do proximo elemento a ser retirado */
        private int n;          /* Numero de elementos na fila */

        public Fila(int tam) {
            tamanho = tam;
            vetor = new int[tamanho];
            ini = 0;
            n = 0;
        }

        public boolean vazia() {
            return (n == 0);
        }

        public boolean cheia() {
            return (n == tamanho);
        }

        public void insere(int elemento) {
            if (!cheia()) {
                int fim = (ini + n) % tamanho;
                vetor[fim] = elemento;
                n++;
            }
        }

        public int remove() {
            int elemento = -1;

            if (!vazia()) {
                elemento = vetor[ini];
                ini = (ini + 1) % tamanho;
                n--;
            }

            return elemento;
        }

        public void imprime() {
            if (vazia())
                System.out.println("Fila esta vazia.");
            else {
                for (int i = 0; i < n; i++) {
                    int index = (ini + i) % tamanho;
                    System.out.println("Elemento " + (i + 1) + ": " + vetor[index]);
                }
            }
        }
    }
}

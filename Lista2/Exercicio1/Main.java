package Lista2.Exercicio1;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        SistemaOperacional sistema = new SistemaOperacional(30);
        int escolha, id;

        do
        {
            escolha = menu();

            switch(escolha) {
                case 0:
                    break;
                case 1:
                    System.out.println("Entre com o processo para adicionar: ");
                    id = scanner.nextInt();
                    if (!sistema.adicionarProcesso(id) )
                        System.out.println("Fila cheia.");
                    break;
                case 2:
                    int idRemovido = sistema.removerProcesso();
                    if (idRemovido != Integer.MIN_VALUE)
                        System.out.println("Processo " + idRemovido + " removido.");
                    else
                        System.out.println("Fila vazia.");
                    break;
                case 3:
                    System.out.println("Conteudo da fila:");
                    sistema.imprimirFila();
                    break;
                default:
                    System.out.println("Opcao invalida! Por favor, selecione outra opcao.");
                    break;
            }

        }while(escolha != 0);

        scanner.close();
    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        System.out.println("--------------------------");
        System.out.println("Selecione a opcao:");
        System.out.println("1. Inserir processo na fila.");
        System.out.println("2. Remover processo com maior tempo de espera.");
        System.out.println("3. Imprimir processos da fila.");
        System.out.println("0. Sair.");
        System.out.print("Opcao: ");
        escolha = scanner.nextInt();

        return escolha;
    }

}
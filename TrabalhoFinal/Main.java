
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numPontos = {10, 20, 30, 40, 50, 100, 200, 500, 1000, 5000, 10000, 20000, 50000, 100000};
        GeradorAleatorio gerador = new GeradorAleatorio();
        Cluster rootFila = null, rootNaive = null;
        // Arrays para armazenar os tempos médios
        double[] temposMediosNaive = new double[numPontos.length];
        double[] temposMediosFila = new double[numPontos.length];

        for (int i = 0; i < numPontos.length; i++) {
            int n = numPontos[i];
            List<Cluster> pontos = gerador.gerarPontos(n);

            long totalNaiveTimeNs = 0, totalFilaTimeNs = 0;
            for (int j = 0; j < 10; j++) {
                System.out.println("\nBateria de teste nº " + (j + 1) + " para " + n + " pontos\n");

                if (j != 0) {
                    pontos = gerador.gerarPontos(n);
                }

                if (j == 9&&n<500) {
                    System.out.println("\nLista de pontos:");
                    int aux = 1;
                    for (Cluster ponto : pontos) {
                        System.out.println(aux + "º " + ponto.getCentroide());
                        aux++;
                    }
                }

                // Medindo tempo para o algoritmo Naive
                long startTime = System.nanoTime();
                rootNaive = ClusterizacaoHierarquicaNaive.clusteriza(pontos);
                long endTime = System.nanoTime();
                totalNaiveTimeNs += (endTime - startTime);

                // Medindo tempo para o algoritmo com Fila de Prioridade
                long startTime2 = System.nanoTime();
                rootFila = ClusterHPrioridade.clusteriza(pontos);
                long endTime2 = System.nanoTime();
                totalFilaTimeNs += (endTime2 - startTime2);

                if (j < 9) {
                    System.out.println("Tempo do Teste NAIVE nº " + (j + 1) + ": " + (endTime - startTime) / 10 + " ns (" + (endTime - startTime) / 1_000_000.0 + " ms)");
                    System.out.println("Tempo do Teste FILA nº " + (j + 1) + ": " + (endTime2 - startTime2) / 10 + " ns (" + (endTime2 - startTime2) / 1_000_000.0 + " ms)");
                }
            }

            // Calculando o tempo médio
            double averageNaiveTimeMs = totalNaiveTimeNs / 10_000_000.0; // Convertendo de ns para ms
            double averageFilaTimeMs = totalFilaTimeNs / 10_000_000.0;   // Convertendo de ns para ms

            // Armazenando os tempos médios nos arrays
            temposMediosNaive[i] = averageNaiveTimeMs;
            temposMediosFila[i] = averageFilaTimeMs;

            System.out.println("\nPressione Enter para continuar ");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter

            System.out.println("\nÁrvore de Clusters (Naive):");
            rootNaive.imprimirArvore();

            long averageNaiveTimeNs = totalNaiveTimeNs / 10;
            averageNaiveTimeMs = averageNaiveTimeNs / 1_000_000.0;
            System.out.println("\nTempo médio de execução Naive com n." + n + " pontos: " + averageNaiveTimeNs + " ns (" + averageNaiveTimeMs + " ms)");
            System.out.println("\nPressione Enter para continuar para a a arvore com fila ");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter

            rootFila.imprimirArvore();

            averageNaiveTimeNs = totalFilaTimeNs / 10;
            averageNaiveTimeMs = averageNaiveTimeNs / 1_000_000.0;
            System.out.println("\nTempo médio de execução Naive com n." + n + " pontos: " + averageNaiveTimeNs + " ns (" + averageNaiveTimeMs + " ms)");

            System.out.println("\nPressione Enter para continuar para o próximo valor de n...");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter

            System.out.println("\n-----------------------------\n");
        }

        // Exibindo o relatório unificado
        System.out.println("\nRelatório Unificado:");
        System.out.println("Número de Pontos | Tempo Médio Naive (ms) | Tempo Médio Fila (ms)");
        for (int i = 0; i < numPontos.length; i++) {
            System.out.printf("%16d | %22.4f | %19.4f%n", numPontos[i], temposMediosNaive[i], temposMediosFila[i]);
        }

        teclado.close();
    }
}

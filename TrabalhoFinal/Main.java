
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numPontos = {10, 20, 30, 40, 50, 100, 200, 500, 1000, 5000, 10000, 20000, 50000, 100000};
        GeradorAleatorio gerador = new GeradorAleatorio();
        Cluster rootNaive = null,rootFila=null;

        for (int n : numPontos) {
            List<Cluster> pontos = gerador.gerarPontos(n);

            long totalNaiveTimeNs = 0, totalFilaTimeNs= 0;
            for (int i = 0; i < 10; i++) {
                System.out.println("\nBateria de teste nº "+(i+1)+"\n");
                if (i != 0) {
                    pontos = gerador.gerarPontos(n);
                }
                if (i == 9) {
                    System.out.println("\nLista de pontos:");

                    int aux = 1;
                    for (Cluster ponto : pontos) {
                        System.out.println(aux + "º" + ponto.getCentroide());
                        aux++;
                    }
                }

                long startTime = System.nanoTime();
                rootNaive = ClusterizacaoHierarquicaNaive.clusteriza(pontos);
                long endTime = System.nanoTime();
                totalNaiveTimeNs += (endTime - startTime);

                if (i < 9) {
                    System.out.println("Tempo do Teste NAIVE nº" + (i + 1) + ": " + (endTime - startTime) / 10 + " ns (" + (endTime - startTime) / 1_000_000.0 + " ms)");
                }
                startTime = System.nanoTime();
                rootFila = ClusterizacaoHierarquicaNaive.clusteriza(pontos);
                endTime = System.nanoTime();
                totalFilaTimeNs += (endTime - startTime);

                if (i < 9) {
                    System.out.println("Tempo do Teste FILA nº" + (i + 1) + ": " + (endTime - startTime) / 10 + " ns (" + (endTime - startTime) / 1_000_000.0 + " ms)");
                }
            }

            System.out.println("\nPressione Enter para continuar ");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter

            System.out.println("\nÁrvore de Clusters (Naive):");
            rootNaive.imprimirArvore();

            long averageNaiveTimeNs = totalNaiveTimeNs / 10;
            double averageNaiveTimeMs = averageNaiveTimeNs / 1_000_000.0;
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

        teclado.close();
    }
}


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numPontos = {10, 20, 30, 40, 50, 100, 200, 500, 1000, 5000, 10000, 20000, 50000, 100000};
        GeradorAleatorio gerador = new GeradorAleatorio();
        Cluster rootNaive = null;

        for (int n : numPontos) {
            List<Cluster> pontos = gerador.gerarPontos(n);

            long totalNaiveTimeNs = 0;
            for (int i = 0; i < 10; i++) {
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
                    System.out.println("\nTempo do Teste nº" + (i + 1) + ": " + (endTime - startTime) / 10 + " ns (" + (endTime - startTime) / 1_000_000.0 + " ms)");
                }
            }

            System.out.println("\nPressione Enter para continuar ");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter

            System.out.println("\nÁrvore de Clusters (Naive):");
            rootNaive.imprimirArvore();
            System.out.println("----0---1---2---3---4---5---6---7---8---9---10---11---12---13---14---15---16---17---18---19---20");

            long averageNaiveTimeNs = totalNaiveTimeNs / 10;
            double averageNaiveTimeMs = averageNaiveTimeNs / 1_000_000.0;
            System.out.println("\nTempo médio de execução Naive: " + averageNaiveTimeNs + " ns (" + averageNaiveTimeMs + " ms)");

            System.out.println("\nPressione Enter para continuar para o próximo valor de n...");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter

            System.out.println("\n-----------------------------\n");
        }

        teclado.close();
    }
}

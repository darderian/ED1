
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numPontos = {10, 20, 30, 40, 50, 100, 200, 500, 1000, 5000, 10000, 20000, 50000, 100000};
        // Criação do gerador de pontos aleatórios
        GeradorAleatorio gerador = new GeradorAleatorio();
        for (int n : numPontos) {
            //gera pontos e registra 
            List<Ponto> pontos = gerador.gerarPontos(n);
            //inicializa o temporizador de teste
            long totalNaiveTimeNs = 0;
            //roda dez vezes para conseguir uma media
            for (int i = 0; i < 10; i++) {
                if (i != 0) {
                    pontos = gerador.gerarPontos(n);
                }
                if (i == 9) {
                    System.out.println("\nLista de pontos:");
                    int aux = 1;
                    for (Ponto ponto : pontos) {
                        System.out.println(aux + "º" + ponto);
                        aux++;
                    }
                    System.out.println("\nPressione Enter para continuar ");
                    teclado.nextLine();  // Aguarda o usuário pressionar Enter
                }
                long startTime = System.nanoTime();
                ClusterizacaoHierarquicaNaive.clusteriza(pontos, i);
                long endTime = System.nanoTime();
                totalNaiveTimeNs += (endTime - startTime);
                if (i < 9) {
                    System.out.println("\nTempo do Teste nº" + (i + 1) + ": " + (endTime - startTime) / 10 + " ns (" + (endTime - startTime) / 1_000_000.0 + " ms)");
                }
            }
            long averageNaiveTimeNs = totalNaiveTimeNs / 10;
            double averageNaiveTimeMs = averageNaiveTimeNs / 1_000_000.0;
            System.out.println("\nTempo médio de execução Naive: " + averageNaiveTimeNs + " ns (" + averageNaiveTimeMs + " ms)");
            System.out.println("\nCluster Final:" + pontos);

            System.out.println("\nPressione Enter para continuar para o próximo valor de n...");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter
        }
        teclado.close();
    }

}

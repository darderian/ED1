import java.util.List;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
         Scanner teclado = new Scanner(System.in);
         int[] numPontos = {10, 20, 30, 40, 50, 100, 200, 500, 1000, 5000, 10000, 20000, 50000, 100000};
        // Criação do gerador de pontos aleatórios
        GeradorAleatorio gerador = new GeradorAleatorio();
        for(int n:numPontos)
        {
            long totalNaiveTimeNs = 0;
            

            
            for (int i = 0; i < 10; i++)
            {
                List<Ponto> pontos = gerador.gerarPontos(n);
                long startTime = System.nanoTime();
                ClusterizacaoHierarquicaNaive.clusteriza(pontos,i);
                long endTime = System.nanoTime();
                totalNaiveTimeNs += (endTime - startTime);
                if(i<9)System.out.println("Teste nº:"+(i+1)+"\nTempo de execução Naive: " + (endTime - startTime)/10 + " ns (" + (endTime - startTime)/ 1_000_000.0 + " ms)");
            }
            long averageNaiveTimeNs = totalNaiveTimeNs / 10;
            double averageNaiveTimeMs = averageNaiveTimeNs / 1_000_000.0;
            System.out.println("Tempo médio de execução Naive: " + averageNaiveTimeNs + " ns (" + averageNaiveTimeMs + " ms)");
            
            
            System.out.println("\nPressione Enter para continuar para o próximo valor de n...");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter
        }   
    }
           
}
        
    

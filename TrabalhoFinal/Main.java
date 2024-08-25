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
            List<Ponto> pontos = gerador.gerarPontos(n);
            ClusterizacaoHierarquicaNaive.clusteriza(pontos);
            System.out.println("\nPressione Enter para continuar para o próximo valor de n...");
            teclado.nextLine();  // Aguarda o usuário pressionar Enter

            System.out.println("\n-----------------------------\n");
        }   
    }
           
}
        
    

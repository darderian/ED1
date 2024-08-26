
import java.util.*;

public class ClusterizacaoHierarquicaNaive {

    public static void clusteriza(List<Ponto> pontos, int iteraçãoTeste) {
        int count = 0;
        if (iteraçãoTeste == 9) {
            System.out.println("\n-----------------------------------------");
        }
        while (pontos.size() > 1) {
            double menorDistancia = Double.MAX_VALUE;
            Ponto PontoA = new Ponto(), PontoB = new Ponto(), aux;
            for (int i = 0; i < pontos.size(); i++) {
                for (int j = i + 1; j < pontos.size(); j++) {
                    double distancia = Ponto.distancia(pontos.get(i), pontos.get(j));
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        PontoA = pontos.get(i);
                        PontoB = pontos.get(j);
                    }
                }
            }
            if (iteraçãoTeste == 9) {
                System.out.println("\n" + (count + 1) + "ºiteração\nPar de menor distancia: \nponto A:" + PontoA + "\nponto B:" + PontoB);
            }
            aux = Ponto.calculaCentroide(PontoA, PontoB);
            if (iteraçãoTeste == 9) {
                System.out.println("\nnovo cluster criado:" + aux + "\n-----------------------------------------");
            }
            pontos.remove(PontoA);
            pontos.remove(PontoB);
            pontos.add(aux);
            count++;
        }

    }
}


import java.util.*;

public class ClusterizacaoHierarquicaNaive {

    public static Cluster clusteriza(List<Cluster> pontos) {
        // Caso base: se há apenas um ponto, retorna um cluster com esse ponto
        if (pontos.size() == 1) {
            return pontos.get(0); // Cluster para um único ponto (folha)
        }

        double menorDistancia = Double.MAX_VALUE;
        Cluster pontoA = null, pontoB = null;

        // Encontrar o par de pontos com a menor distância
        for (int i = 0; i < pontos.size(); i++) {
            for (int j = i + 1; j < pontos.size(); j++) {
                double distancia = Ponto.distancia(pontos.get(i).getCentroide(), pontos.get(j).getCentroide());
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    pontoA = pontos.get(i);
                    pontoB = pontos.get(j);
                }
            }
        }

        // Criar o novo cluster com os dois pontos mais próximos
        Cluster cluster = new Cluster(pontoA, pontoB);

        // Remover os pontos do cluster e adicionar o centroide ao conjunto de pontos restantes
        pontos.remove(pontoA);
        pontos.remove(pontoB);
        pontos.add(cluster); // Adiciona o centróide como novo ponto

        // Continuar a clusterização recursivamente até restar apenas um cluster (a raiz)
        return clusteriza(pontos);
    }
}

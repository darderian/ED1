
import java.util.*;

public class ClusterHPrioridade {

    public static Cluster clusteriza(List<Cluster> clusters) {
        FilaPrioridade filaPrioridade = new FilaPrioridade();
        filaPrioridade.inicializar(clusters);

        while (clusters.size() > 1) {
            FilaPrioridade.ClusterDistancia menorDistancia = filaPrioridade.remover();
            Cluster cluster1 = menorDistancia.getCluster1();
            Cluster cluster2 = menorDistancia.getCluster2();

            // Cria um novo cluster combinando os dois clusters mais próximos
            Cluster novoCluster = new Cluster(cluster1, cluster2);

            // Atualiza a lista de clusters
            clusters.remove(cluster1);
            clusters.remove(cluster2);
            clusters.add(novoCluster);

            // Atualiza as distâncias na fila de prioridade
            filaPrioridade.atualizarDistancias(novoCluster);
        }

        return clusters.get(0); // Retorna o cluster resultante que é a raiz da árvore
    }
}

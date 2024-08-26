import java.util.*;

public class FilaPrioridade {
    private final PriorityQueue<ClusterDistancia> fila;

    public FilaPrioridade() {
        this.fila = new PriorityQueue<>(Comparator.comparingDouble(ClusterDistancia::getDistancia));
    }

    public void inicializar(List<Cluster> clusters) {
        fila.clear();

        for (int i = 0; i < clusters.size(); i++) {
            for (int j = i + 1; j < clusters.size(); j++) {
                Cluster cluster1 = clusters.get(i);
                Cluster cluster2 = clusters.get(j);
                double distancia = cluster1.calcularDistanciaPara(cluster2);
                fila.add(new ClusterDistancia(cluster1, cluster2, distancia));
            }
        }
    }

    public void atualizarDistancias(Cluster cluster) {
        // Criar uma nova lista de distâncias a serem atualizadas
        List<ClusterDistancia> distanciasAtualizadas = new ArrayList<>();
        
        for (ClusterDistancia cd : fila) {
            if (cd.getCluster1().equals(cluster) || cd.getCluster2().equals(cluster)) {
                distanciasAtualizadas.add(cd);
            }
        }
        
        // Remover as distâncias antigas da fila
        fila.removeAll(distanciasAtualizadas);
        
        // Recalcular as distâncias e adicionar as novas entradas na fila
        for (ClusterDistancia cd : distanciasAtualizadas) {
            Cluster cluster1 = cd.getCluster1();
            Cluster cluster2 = cd.getCluster2();
            if (cluster.equals(cluster1) || cluster.equals(cluster2)) {
                Cluster outroCluster = cluster.equals(cluster1) ? cluster2 : cluster1;
                double novaDistancia = cluster.calcularDistanciaPara(outroCluster);
                fila.add(new ClusterDistancia(cluster, outroCluster, novaDistancia));
            }
        }
    }

    public ClusterDistancia remover() {
        return fila.poll();
    }

    public boolean isVazia() {
        return fila.isEmpty();
    }

    public int getSize() {
        return fila.size();
    }

    public void clear() {
        fila.clear();
    }

    // Classe interna para representar a distância entre dois clusters
    public static class ClusterDistancia {
        private final Cluster cluster1;
        private final Cluster cluster2;
        private final double distancia;

        public ClusterDistancia(Cluster cluster1, Cluster cluster2, double distancia) {
            this.cluster1 = cluster1;
            this.cluster2 = cluster2;
            this.distancia = distancia;
        }

        public Cluster getCluster1() {
            return cluster1;
        }

        public Cluster getCluster2() {
            return cluster2;
        }

        public double getDistancia() {
            return distancia;
        }
    }
}

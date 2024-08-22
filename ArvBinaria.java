package TrabalhoFinal;

import java.util.List;

public class ArvBinaria {
    private Cluster cluster;
    private ArvBinaria esq, dir;

    public ArvBinaria(Cluster cluster) {
        this.cluster = cluster;
        this.esq = null;
        this.dir = null;
    }

    public Cluster retornaCluster() { return cluster; }
    public ArvBinaria retornaEsq() { return esq; }
    public ArvBinaria retornaDir() { return dir; }

    public void defineRaiz(Cluster raiz) { cluster = raiz; }
    public void defineDir(ArvBinaria filho) { dir = filho; }
    public void defineEsq(ArvBinaria filho) { esq = filho; }

    public static ArvBinaria clusterizar(List<ArvBinaria> clusters) {
        while (clusters.size() > 1) {
            ArvBinaria noA = null;
            ArvBinaria noB = null;
            double menorDistancia = Double.MAX_VALUE;

            // Encontrar os dois clusters mais próximos
            for (int i = 0; i < clusters.size(); i++) {
                for (int j = i + 1; j < clusters.size(); j++) {
                    double distancia = Ponto.distancia(
                            clusters.get(i).retornaCluster().getCentroide(),
                            clusters.get(j).retornaCluster().getCentroide()
                    );
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        noA = clusters.get(i);
                        noB = clusters.get(j);
                    }
                }
            }

            // Combinar os dois clusters mais próximos
            ArvBinaria novoNo = combinarClusters(noA, noB);
            clusters.remove(noA);
            clusters.remove(noB);
            clusters.add(novoNo);
        }
        return clusters.get(0);
    }

    public static ArvBinaria combinarClusters(ArvBinaria noA, ArvBinaria noB) {
        Cluster novoCluster = new Cluster(noA.retornaCluster().getCentroide());
        novoCluster.uneClusters(noB.retornaCluster());

        ArvBinaria novoNo = new ArvBinaria(novoCluster);
        novoNo.defineEsq(noA);
        novoNo.defineDir(noB);

        return novoNo;
    }

    public void mostra() {
        System.out.println("Cluster com centroide em: (" + cluster.getCentroide().getX() + ", " + cluster.getCentroide().getY() + ")");
        System.out.print("Pontos: ");
        for (Ponto ponto : cluster.getPontos()) {
            System.out.print("(" + ponto.getX() + ", " + ponto.getY() + ") ");
        }
        System.out.println();

        if (esq != null) {
            System.out.println("Filho Esquerdo:");
            esq.mostra();
        }

        if (dir != null) {
            System.out.println("Filho Direito:");
            dir.mostra();
        }
    }
}

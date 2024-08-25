import java.util.List;

public class ArvBinaria {
    private Cluster cluster;
    private ArvBinaria esq, dir;

    public ArvBinaria(Cluster cluster) 
    {
        this.cluster = cluster;
        this.esq = null;
        this.dir = null;
    }

    public Cluster retornaCluster()
    {
        return cluster;
    }
    public ArvBinaria retornaEsq()
    {
        return esq;
    }
    public ArvBinaria retornaDir()
    {
        return dir;
    }
    public void defineRaiz(Cluster raiz)
    {
        cluster = raiz;
    }
    public void defineDir(ArvBinaria filho)
    {
        dir = filho;
    }
    public void defineEsq(ArvBinaria filho)
    {
        esq = filho;
    }

    public static ArvBinaria clusterizar(List<ArvBinaria> cluster){
        while(cluster.size() > 1){
            ArvBinaria noA = null;
            ArvBinaria noB = null;
            double menorDistancia = Double.MAX_VALUE;
            for (int i = 0; i < cluster.size(); i++){
                for (int j = i + 1; j < cluster.size(); j++){
                    double distancia = Ponto.distancia(cluster.get(i).retornaCluster().getCentroide(), cluster.get(j).retornaCluster().getCentroide());
                    if (distancia < menorDistancia){
                        menorDistancia = distancia;
                        noA = cluster.get(i);
                        noB =  cluster.get(j);
                    }
                }
            }
            ArvBinaria novoNo = combinarClusters(noA,noB);
            cluster.remove(noA);
            cluster.remove(noB);
            cluster.add(novoNo);
        }
        return cluster.get(0);


    }

    public static ArvBinaria combinarClusters(ArvBinaria noA, ArvBinaria noB) {
        Cluster novoCluster = new Cluster(noA.retornaCluster().getCentroide());
        novoCluster.uneClusters(noB.retornaCluster());

        ArvBinaria novoNo = new ArvBinaria(novoCluster);
        novoNo.defineEsq(noA);
        novoNo.defineDir(noB);

        return novoNo;
    }


    public void mostra(String prefixo) {
        System.out.println(prefixo + "Cluster com centroide em: (" + Math.round(( cluster.getCentroide().getX() * 100.0) /100.0) + ", " + Math.round(( cluster.getCentroide().getY() * 100.0) /100.0) + ")");

        System.out.print(prefixo + "Pontos: ");
        for (Ponto ponto : cluster.getPontos()) {
            System.out.print("(" + Math.round((ponto.getX() * 100.0)/100.0) + ", " + Math.round((ponto.getY() * 100.0)/100.0) + ") ");
        }
        System.out.println();


        if (esq != null) {
            System.out.println(prefixo + "Filho Esquerdo:");
            esq.mostra(prefixo + "    ");
        }

        if (dir != null) {
            System.out.println(prefixo + "Filho Direito:");
            dir.mostra(prefixo + "    ");
        }
    }





}

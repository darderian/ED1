package TrabalhoFinal;

import java.util.ArrayList;

public class Cluster {
    private ArrayList<Ponto> pontos;
    private Ponto centroide;

    public Cluster(Ponto pontoInicial) {
        this.pontos = new ArrayList<>();
        this.pontos.add(pontoInicial);
        this.centroide = pontoInicial;
    }

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    public Ponto getCentroide() {
        return centroide;
    }

    public void recalculaCentroide() {
        if (pontos.isEmpty()) return;

        double somaX = 0;
        double somaY = 0;
        for (Ponto ponto : pontos) {
            somaX += ponto.getX();
            somaY += ponto.getY();
        }
        double novoX = somaX / pontos.size();
        double novoY = somaY / pontos.size();
        this.centroide = new Ponto(novoX, novoY);
    }

    public void uneClusters(Cluster cluster2) {
        this.pontos.addAll(cluster2.getPontos());
        recalculaCentroide();
    }
}

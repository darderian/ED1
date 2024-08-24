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

    public void recalculaCentroide(){
        double somaX = 0;
        double somaY = 0;
        for (Ponto ponto:pontos) {
            somaX += ponto.getX();
            somaY += ponto.getY();
        }
        double novoX = Math.round((somaX/ pontos.size()) * 100.0) /100.0;
        double novoY = Math.round((somaY/ pontos.size()) * 100.0) /100.0;
        this.centroide = new Ponto(novoX, novoY);
    }

    public void uneClusters(Cluster cluster2){
        this.pontos.addAll(cluster2.getPontos());
        recalculaCentroide();
    }

}

public class Cluster 
{
    public static Ponto calculaCentroide(Ponto A, Ponto B) {
        double novoX = GeradorAleatorio.arredondar((A.getX() + B.getX()) / 2, 2);
        double novoY = GeradorAleatorio.arredondar((A.getY() + B.getY()) / 2, 2);
    
        Ponto centroid = new Ponto(novoX, novoY);
        return centroid;
    }
}

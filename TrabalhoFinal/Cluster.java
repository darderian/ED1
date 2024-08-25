public class Cluster 
{
    private Ponto centroide,PontoA,PontoB;

    public Cluster(Ponto A,Ponto B) 
    {
        this.PontoA=A;
        this.PontoB=B;
        this.centroide =calculaCentroide(A, B) ;
    }

    public Ponto getcentroide() 
    {
        return centroide;
    }

    public static Ponto calculaCentroide(Ponto A, Ponto B) {
        double novoX = GeradorAleatorio.arredondar((A.getX() + B.getX()) / 2, 2);
        double novoY = GeradorAleatorio.arredondar((A.getY() + B.getY()) / 2, 2);
    
        Ponto centroid = new Ponto(novoX, novoY);
        return centroid;
    }
}

import java.util.Objects;

public class Ponto {
    private final double x;
    private final double y;

    public Ponto()
    {
        this.x = 0;
        this.y = 0;
    }
    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static double distancia(Ponto p1, Ponto p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ponto ponto = (Ponto) obj;
        return Double.compare(ponto.x, x) == 0 && Double.compare(ponto.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

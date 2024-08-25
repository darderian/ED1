import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class GeradorAleatorio {

    private Random random;
    private final int intervaloMaximo =100;/// define o maximo que poder ser gerado

    public GeradorAleatorio() {
        this.random = new Random();
    }

    public List<Ponto> gerarPontos(int quantidade) {
        List<Ponto> pontos = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            double x = arredondar(random.nextDouble() * intervaloMaximo, 2);
            double y = arredondar(random.nextDouble() * intervaloMaximo, 2);
            pontos.add(new Ponto(x, y));
        }
        return pontos;
    }
    public static double arredondar(double valor, int casasDecimais) {
        BigDecimal bd = new BigDecimal(Double.toString(valor));
        bd = bd.setScale(casasDecimais, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

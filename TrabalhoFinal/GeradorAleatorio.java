package TrabalhoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorAleatorio {

    private Random random;

    public GeradorAleatorio() {
        this.random = new Random();
    }

    public List<Ponto> gerarPontos(int quantidade, double intervaloMaximo) {
        List<Ponto> pontos = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            double x = random.nextDouble() * intervaloMaximo;
            double y = random.nextDouble() * intervaloMaximo;
            pontos.add(new Ponto(x, y));
        }
        return pontos;
    }
}

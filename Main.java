package TrabalhoFinal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criação do gerador de pontos aleatórios
        GeradorAleatorio gerador = new GeradorAleatorio();

        // Gerar 10 pontos aleatórios com coordenadas no intervalo [0, 20)
        List<Ponto> pontosGerados = gerador.gerarPontos(4, 100.0);

        // Criação dos clusters iniciais
        List<ArvBinaria> listaClusters = new ArrayList<>();
        for (Ponto ponto : pontosGerados) {
            ArvBinaria cluster = new ArvBinaria(new Cluster(ponto));
            listaClusters.add(cluster);
        }

        // Clusterização
        ArvBinaria arvoreFinal = ArvBinaria.clusterizar(listaClusters);

        // Exibição da árvore de clusterização
        System.out.println("Estrutura da árvore de clusterização:");
        arvoreFinal.mostra();
    }
}

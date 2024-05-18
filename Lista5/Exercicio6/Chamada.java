package Lista5.Exercicio6;

public class Chamada {

    private int custo;
    private String origem;

    public Chamada(int custo, String origem) {
        this.custo = custo;
        this.origem = origem;
    }

    @Override
    public String toString() {
        return "Chamada de " + origem + ", custando R$" + custo + ",00";
    }

    public int getCusto() {
        return custo;
    }
}

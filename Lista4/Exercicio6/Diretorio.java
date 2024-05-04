package Lista4.Exercicio6;

public class Diretorio extends Lista<Object> {
    private String nome;

    public Diretorio(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String toString() {
        return listarConteudo(this, 0);
    }

    private String listarConteudo(Diretorio diretorio, int nivel) {
        StringBuilder builder = new StringBuilder();
        String prefixo = " ".repeat(nivel * 2);
        builder.append(prefixo).append(diretorio.nome).append("\n");

        Elo<Object> arquivoAtual = diretorio.prim;
        while (arquivoAtual != null) {
            if (arquivoAtual.dado instanceof Arquivo) {
                builder.append(prefixo).append("  ").append(arquivoAtual.dado).append("\n");
            } else if (arquivoAtual.dado instanceof Diretorio) {
                builder.append(listarConteudo((Diretorio) arquivoAtual.dado, nivel + 1));
            }
            arquivoAtual = arquivoAtual.prox;
        }

        return builder.toString();
    }

    public void adicionarArquivo(Arquivo arquivo) {
        insere(arquivo);
    }

    public void adicionarDiretorio(Diretorio diretorio) {
        insere(diretorio);
    }
}

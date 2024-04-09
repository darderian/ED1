package Lista2.Exercicio1;

public class SistemaOperacional {
    private Fila filaProcessos;

    public SistemaOperacional(int tamanhoFila) {
        filaProcessos = new Fila(tamanhoFila);
    }

    public boolean adicionarProcesso(int idProcesso) {
        return filaProcessos.insere(idProcesso);
    }

    public int removerProcesso(){
        return filaProcessos.remove();
    }

    public void imprimirFila() {
        filaProcessos.imprime();
    }
}



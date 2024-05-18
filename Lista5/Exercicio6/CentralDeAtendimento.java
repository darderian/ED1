package Lista5.Exercicio6;

public class CentralDeAtendimento {

    private ListaDuplamenteGenerica<Chamada> fila;

    public CentralDeAtendimento() {
        fila = new ListaDuplamenteGenerica<>();
    }

    public void adicionarChamada(Chamada chamada) {
        fila.insere(chamada);
    }

    public boolean atenderChamada() {
        return fila.remove();
    }

    public boolean filaVazia() {
        return fila.vazia();
    }

    public void imprimirFila() {
        fila.imprime();
    }
}
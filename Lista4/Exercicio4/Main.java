package Lista4.Exercicio4;

public class Main {
    public static void main(String[] args){
        Lista<String> lista = new Lista<>();
        lista.insere("Mesmo");
        lista.insere("o");
        lista.insere("azul");
        lista.insere("sendo");
        lista.insere("bonito");
        lista.insere(",");
        lista.insere("eu");
        lista.insere("prefiro");
        lista.insere("o");
        lista.insere("amarelo");
        lista.insere(".");

        lista.imprime();
    }
}

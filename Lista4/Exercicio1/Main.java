package Lista4.Exercicio1;

/*
Resposta: A complexidade é O(n), pois o while é percorrido n vezes. Sim, uma forma de melhorar a complexidade seria
declarando tamanho = 0 na criação da lista e depois atualizando constantemente o tamanho a cada elemento
adicionado ou retirado da lista, tornando a complexidade O(1).
*/
public class Main {
    public static void main (String[] args){
        Lista lista = new Lista();
        TesteListaSingular teste = new TesteListaSingular();

        teste.valida(lista);
    }
}

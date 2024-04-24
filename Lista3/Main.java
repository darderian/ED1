package Lista3;

public class Main{

    /*     Questões Discursivas
     *
     * 1-
     *      a) O(n)
     *      b) O(n^2)
     *      c) O(n log n)
     *
     * 2-       Termo Dominante        O()
     *
     *      a)      0.001n^5            n^5
     *      b)      50nlog n            n log n
     *      c)      2.5 n^1.75          n^1.75
     *      d)      n^2 log2 n          n^2 log2 n
     *      e)      n log2 n            n log2 n
     *      f)      3 log8 n            log8 n
     *      g)      0.01n^2             n^2
     *      h)      100n^2              n^2
     *      i)      0.5n^1.25           n^1.25
     *      j)      n(log2 n)^2         n(log2 n)^2
     *      k)      n^3                 n^3
     *      l)      0.003 log4 n        log4 n
     *
     * 3-
     *
     *      i) Complexidade do while - O(n), repetirá n vezes
     *         Complexidade dos if's e return's é O(1)
     *         Multiplicando O(n) * O(1) = O(n)
     *         Complexidade do algoritmo é O(n)
     *
     *      ii) Complexidade do for - O(n), repetirá n vezes
     *          Complexidade dos if's e return's é O(1)
     *          Multiplicando O(n) * O(1) = O(n)
     *          Complexidade do algoritmo é O(n)
     *
     *      iii) O while repertira n vezes log n, ja que em toda
     *           a repeticao o tamanho de n é dividido pela metade
     *           e a quantidade de repeticoes depende de n, logo
     *           a Complexidade é O(n log n)
     *
     * 4- Codigo main
     *
     * 5-
     *      Complexidade do for - O(n), dentro de outro for repetirá n^2 vezes
     *      Complexidade das atribuicoes, dos if's e return's é O(1)
     *      Multiplicando O(n^2) * O(1) = O(n^2)
     *      Complexidade do algoritmo no pior caso é O(n^2)
     *
     */

    public static void main(String[] args) {

        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(100);

        for (int i = 0; !pilha.cheia(); i++)//Complexidade O(n)
            pilha.push(i);

        System.out.println(retornaPares(pilha));

    }

    public static int retornaPares(PilhaGenerica<Integer> pilha) {

        int cont = 0;

        while (!pilha.vazia()){ //Complexidade O(n)

            if (pilha.pop() % 2 == 0)
                cont++;

        }

        return cont;
    }


}
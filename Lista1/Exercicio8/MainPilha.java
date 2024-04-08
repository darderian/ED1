package Lista1.Exercicio8;

import java.util.HashSet;

public class MainPilha {
    public static void main(String[] args) {
        int n = 5;
        PilhaGenerica<Integer> sequencias = new PilhaGenerica<>(n);

        for (int i = 0; i < n; i++){
            sequencias.push(i + 1);
        }

        PilhaGenerica<int[]> subsequencias = gerarSubsequencias(sequencias);
        encontrarParesUnicos(subsequencias);
    }

    public static PilhaGenerica<int[]> gerarSubsequencias(PilhaGenerica<Integer> sequencias){
        PilhaGenerica<int[]> subsequencias = new PilhaGenerica<>(sequencias.tamanho() * sequencias.tamanho());

        // Loop para gerar todas as subsequências
        for (int i = 0; i < sequencias.tamanho(); i++) {
            PilhaGenerica<Integer> temp = new PilhaGenerica<>(sequencias.tamanho());

            for (int j = 0; j < sequencias.tamanho(); j++) {
                temp.push(sequencias.retornaElemento(j));
            }

            for (int j = 0; j <= i; j++) {
                int[] subsequence = new int[i - j + 1];
                for (int k = 0; k < subsequence.length; k++) {
                    subsequence[k] = temp.retornaElemento(j + k);
                }
                subsequencias.push(subsequence);
            }
        }

        return subsequencias;
    }

    public static void encontrarParesUnicos(PilhaGenerica<int[]> subsequencias) {
        HashSet<String> paresUnicos = new HashSet<>();

        while (!subsequencias.vazia()) {
            int[] subsequence = subsequencias.pop();
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;

            for (int num : subsequence) {
                if (num > max) {
                    secondMax = max;
                    max = num;
                } else if (num > secondMax && num != max) {
                    secondMax = num;
                }
            }

            if (secondMax != Integer.MIN_VALUE) {
                paresUnicos.add("(" + secondMax + "," + max + ")");
            }
        }

        System.out.println("Quantidade de pares unicos: " + paresUnicos.size());
        System.out.println("Pares unicos: " + paresUnicos);
    }
}

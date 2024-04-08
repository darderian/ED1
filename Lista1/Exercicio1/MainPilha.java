package Lista1.Exercicio1;

import java.util.Scanner;

public class MainPilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;

        System.out.println("Digite a String desejada: ");
        s = scanner.nextLine();

        System.out.println(determinarPalindromo(s));

        scanner.close();
    }

    public static boolean determinarPalindromo(String s){
        int i = 0, contador1 = 0;
        char c1, c2;
        Pilha pilhaX = new Pilha(50);
        Pilha pilhaY = new Pilha(50);

        while(s.charAt(i) != 'C'){
            c1 = s.charAt(i);
            pilhaX.push(c1);
            i++;
            contador1++;
        }

        int j = s.length() - 1, contador2 = 0;
        while(s.charAt(j) != 'C'){
            c2 = s.charAt(j);
            pilhaY.push(c2);
            j--;
            contador2++;
        }

        if (contador1 != contador2){
            System.out.println("X e Y tem tamanhos diferentes.");
            return false;
        } else {
            while(!pilhaX.vazia()){
                c1 = pilhaX.pop();
                c2 = pilhaY.pop();
                if (c1 != c2){
                    return false;
                }
                i++;
            }
            return true;
        }
    }
}
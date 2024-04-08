package Lista1.Exercicio7;

import java.util.Scanner;

public class MainPilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a expressão aritmetica:");
        String expressao = scanner.nextLine().replaceAll("\\s", "");

        ExpressaoAritmetica avaliador = new ExpressaoAritmetica();
        double resultado = avaliador.avaliarExpressao(expressao);
        System.out.println("Resultado: " + resultado);
    }
}


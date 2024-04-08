package Lista1.Exercicio7;

class ExpressaoAritmetica {

    public ExpressaoAritmetica() {
    }

    public double avaliarExpressao(String expressao) {
        String posfixa = converterParaPosfixa(expressao);
        return avaliarPosfixa(posfixa);
    }

    private String converterParaPosfixa(String expressao) {
        StringBuilder posfixa = new StringBuilder();
        PilhaGenerica<Character> pilha = new PilhaGenerica<>(50);

        for (int i = 0; i < expressao.length(); i++) {
            char caracter = expressao.charAt(i);

            if (Character.isDigit(caracter)) {
                posfixa.append(caracter);
                if (i + 1 < expressao.length() && !Character.isDigit(expressao.charAt(i + 1))) {
                    posfixa.append(" ");
                }
            } else if (caracter == '(') {
                pilha.push(caracter);
            } else if (caracter == ')') {
                while (!pilha.vazia() && pilha.retornaTopo() != '(') {
                    posfixa.append(pilha.pop()).append(" ");
                }
                pilha.pop();
            } else {
                while (!pilha.vazia() && precedencia(caracter) <= precedencia(pilha.retornaTopo())) {
                    posfixa.append(pilha.pop()).append(" ");
                }
                pilha.push(caracter);
            }
        }

        while (!pilha.vazia()) {
            posfixa.append(pilha.pop()).append(" ");
        }

        return posfixa.toString();
    }

    private int precedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        }
        return 0;
    }

    private double avaliarPosfixa(String posfixa) {
        String[] tokens = posfixa.split("\\s+");
        PilhaGenerica<Double> pilhaValores = new PilhaGenerica<>(50);

        for (String token : tokens) {
            if (!token.isEmpty()) {
                if (Character.isDigit(token.charAt(0))) {
                    pilhaValores.push(Double.parseDouble(token));
                } else {
                    double operando2 = pilhaValores.pop();
                    double operando1 = pilhaValores.pop();
                    switch (token) {
                        case "+":
                            pilhaValores.push(operando1 + operando2);
                            break;
                        case "-":
                            pilhaValores.push(operando1 - operando2);
                            break;
                        case "*":
                            pilhaValores.push(operando1 * operando2);
                            break;
                        case "/":
                            pilhaValores.push(operando1 / operando2);
                            break;
                    }
                }
            }
        }

        return pilhaValores.pop();
    }
}


public class Cluster {

    private Ponto centroide;
    private Cluster left;
    private Cluster right;

    // Construtor para criar um cluster a partir de dois pontos
    public Cluster(Ponto pontoA, Ponto pontoB) {
        this.centroide = Ponto.calculaCentroide(pontoA, pontoB);
        this.left = new Cluster(pontoA); // Cria o cluster esquerdo com o ponto A
        this.right = new Cluster(pontoB); // Cria o cluster direito com o ponto B
    }

    // Construtor para criar um cluster com um único ponto (folha)
    public Cluster(Ponto ponto) {
        this.centroide = ponto;
        this.left = null;
        this.right = null;
    }

    // Construtor para criar um cluster a partir de dois clusters existentes
    public Cluster(Cluster left, Cluster right) {
        this.centroide = Ponto.calculaCentroide(left.getCentroide(), right.getCentroide());
        this.left = left;
        this.right = right;
    }

    // Getter para o centroide
    public Ponto getCentroide() {
        return centroide;
    }

    // Getter para o filho esquerdo
    public Cluster getLeft() {
        return left;
    }

    // Getter para o filho direito
    public Cluster getRight() {
        return right;
    }

    // Define o filho esquerdo
    public void setLeft(Cluster left) {
        this.left = left;
    }

    // Define o filho direito
    public void setRight(Cluster right) {
        this.right = right;
    }

    public void imprimirArvore() {
        imprimirArvore("", true, "Raiz");
    }

    // Método privado para impressão hierárquica da árvore
    private void imprimirArvore(String prefixo, boolean estaUltimo, String tipo) {
        // Imprime o tipo do nó e seu centroide
        System.out.println(prefixo + (estaUltimo ? "└── " : "├── ") + tipo + ": " + this.getCentroide());

        String novoPrefixo = prefixo + (estaUltimo ? "    " : "│   ");

        boolean temFilhoEsquerdo = this.left != null;
        boolean temFilhoDireito = this.right != null;

        if (temFilhoEsquerdo || temFilhoDireito) {
            if (temFilhoEsquerdo) {
                // Imprime o filho esquerdo
                if (this.left.getLeft() == null && this.left.getRight() == null) {
                    // Se o filho esquerdo é uma folha
                    this.left.imprimirArvore(novoPrefixo, !temFilhoDireito, "Folha");
                } else {
                    // Se o filho esquerdo não é uma folha
                    this.left.imprimirArvore(novoPrefixo, !temFilhoDireito, "Nó");
                }
            } else {
                // Se não há filho esquerdo
                System.out.println(novoPrefixo + "└── Esquerda: null");
            }

            if (temFilhoDireito) {
                // Imprime o filho direito
                if (this.right.getLeft() == null && this.right.getRight() == null) {
                    // Se o filho direito é uma folha
                    this.right.imprimirArvore(novoPrefixo, true, "Folha");
                } else {
                    // Se o filho direito não é uma folha
                    this.right.imprimirArvore(novoPrefixo, true, "Nó");
                }
            } else {
                // Se não há filho direito
                System.out.println(novoPrefixo + "└── Direita: null");
            }
        }
    }

}

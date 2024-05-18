package Lista5.Exercicio5;

public class ListaDuplamente
{
    protected Elo prim;

    protected class Elo
    {
        protected int dado;
        protected Elo ant;
        protected Elo prox;

        public Elo()
        {
            ant = null;
            prox = null;
        }

        public Elo(int elem)
        {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(int elem, Elo antElem, Elo proxElem)
        {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }

    public ListaDuplamente()
    {
        prim = null;
    }

    public boolean vazia()
    {
        return prim == null;
    }

    public void insere(int novo)
    {
        Elo p;

        p = new Elo(novo);

        p.prox = prim;

        p.ant = null;

        if (prim != null)
            prim.ant = p;

        prim = p;
    }

    private Elo busca(int elem)
    {
        Elo p = null;

        for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

        return p;
    }

    public boolean remove(int elem)
    {
        Elo p = null;
        p = busca(elem);

        if (p == null) return false;

        if (p == prim)
            prim = prim.prox;
        else
            p.ant.prox = p.prox;

        if (p.prox != null)
            p.prox.ant = p.ant;

        p = null;

        return true;
    }

    public void imprime()
    {
        Elo p;

        System.out.println("Elementos da lista:");

        for(p = prim; p != null; p = p.prox)
        {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    public boolean verificaIgualdade(ListaDuplamente lista2) {

        if (lista2 == null)
            return false;

        return verificaIgualdadeRecursivo(prim, lista2.prim);
    }

    private boolean verificaIgualdadeRecursivo(Elo p, Elo q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null || p.dado != q.dado)
            return false;

        return verificaIgualdadeRecursivo(p.prox, q.prox);
    }
}
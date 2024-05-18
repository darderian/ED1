package Lista5.Exercicio6;

public class ListaDuplamenteGenerica <T>{

    protected Elo prim;

    protected class Elo
    {
        protected T dado;
        protected Elo ant;
        protected Elo prox;

        public Elo()
        {
            ant = null;
            prox = null;
        }

        public Elo(T elem)
        {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(T elem, Elo antElem, Elo proxElem)
        {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }

    public ListaDuplamenteGenerica()
    {
        prim = null;
    }

    public boolean vazia()
    {
        return prim == null;
    }

    public void insere(T novo)
    {
        Elo p;
        p = new Elo(novo);

        if (vazia())
        {
            prim = p;
            return;
        }

        Elo q = prim;

        if (((Chamada) p.dado).getCusto() > ((Chamada) q.dado).getCusto()) {
            p.prox = q;
            q.ant = p;
            prim = p;
            return;
        }

        while (q.prox != null && (((Chamada) q.prox.dado).getCusto() >= ((Chamada) p.dado).getCusto()))
            q = q.prox;


        p.prox = q.prox;
        p.ant = q;

        if (q.prox != null)
            q.prox.ant = p;

        q.prox = p;
    }

    public boolean remove()
    {
        Elo p = prim;

        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox;

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
            System.out.print(((Chamada)p.dado).toString());
            System.out.println();
        }

        System.out.println();
    }
}

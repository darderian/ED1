package Lista1.Exercicio8;

import java.util.Vector;

public class PilhaGenerica<T>
{
    private int n;
    private Vector<T> vetor;
    private int topo;

    public PilhaGenerica(int tamanho)
    {
        n = tamanho;
        vetor = new Vector<T>(tamanho);
        topo = -1;
    }

    public boolean vazia()
    {
        return topo == -1 ? true : false;
    }

    public boolean cheia()
    {
        return topo == n - 1 ? true : false;
    }

    public T pop()
    {
        T elemento;

        if (!this.vazia())
        {
            elemento = vetor.get(topo--);
            return elemento;
        }
        else
        {
            //Impressão para fins didáticos
            System.out.println("Pilha vazia: pop nao funcionou.");
            return null;
        }
    }

    public boolean push(T elemento)
    {
        if (!this.cheia())
        {
            vetor.add(++topo, elemento);
            return true;
        }
        else
        {
            //Impressão para fins didáticos
            System.out.println("Pilha cheia: push nao funcionou.\n");
            return false;
        }
    }

    public T retornaElemento(int index)
    {
        if(index >= 0 && index <= topo)
            return vetor.get(index);
        else
            return null;
    }

    public int tamanho()
    {
        return topo + 1;
    }
}
package Lista4.Exercicio6;

public class Main {
    public static void main(String[] args) {
        Diretorio jogos = new Diretorio("Jogos");
        Diretorio faculdade = new Diretorio("Faculdade");
        Diretorio aces = new Diretorio("ACEs");
        Diretorio filmes = new Diretorio("Filmes");
        Diretorio superHeroicos = new Diretorio("Super-heroicos");
        Diretorio marvel = new Diretorio("Marvel");
        Diretorio dc = new Diretorio("DC");
        Diretorio drama = new Diretorio("Drama");
        Diretorio comediaRomantica = new Diretorio("Comedias Romanticas");

        Arquivo campoMinado = new Arquivo("Campo Minado");
        Arquivo paciencia = new Arquivo("Paciencia");
        Arquivo worldOfWarcraft = new Arquivo("World of Warcraft");
        Arquivo edd1 = new Arquivo("EDD1");
        Arquivo edd2 = new Arquivo("EDD2");
        Arquivo aa = new Arquivo("AA");
        Arquivo ace1 = new Arquivo("ACE1");
        Arquivo ace2 = new Arquivo("ACE2");
        Arquivo ace3 = new Arquivo("ACE3");
        Arquivo tpd = new Arquivo("TPD");
        Arquivo vingadores = new Arquivo("Vingadores");
        Arquivo homemAranha = new Arquivo("Homem-Aranha");
        Arquivo superman = new Arquivo("Superman");
        Arquivo brilhoEterno = new Arquivo("Brilho Eterno de Uma Mente Sem Lembrancas");

        jogos.adicionarArquivo(campoMinado);
        jogos.adicionarArquivo(paciencia);
        jogos.adicionarArquivo(worldOfWarcraft);
        faculdade.adicionarArquivo(edd1);
        faculdade.adicionarArquivo(edd2);
        faculdade.adicionarArquivo(aa);
        faculdade.adicionarDiretorio(aces);
        aces.adicionarArquivo(ace1);
        aces.adicionarArquivo(ace2);
        aces.adicionarArquivo(ace3);
        faculdade.adicionarArquivo(tpd);
        filmes.adicionarDiretorio(superHeroicos);
        filmes.adicionarDiretorio(drama);
        filmes.adicionarDiretorio(comediaRomantica);
        superHeroicos.adicionarDiretorio(marvel);
        superHeroicos.adicionarDiretorio(dc);
        marvel.adicionarArquivo(vingadores);
        marvel.adicionarArquivo(homemAranha);
        dc.adicionarArquivo(superman);
        drama.adicionarArquivo(brilhoEterno);
        comediaRomantica.adicionarArquivo(null);

        System.out.println(filmes);
    }
}

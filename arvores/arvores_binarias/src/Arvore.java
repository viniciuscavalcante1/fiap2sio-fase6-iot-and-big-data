public class Arvore {
    public int dado;
    public Arvore esq;
    public Arvore dir;

    public static void mostra_em_ordem(Arvore a) {
        if (a != null) {
            mostra_em_ordem(a.esq);
            System.out.println(" " + a.dado);
            mostra_em_ordem(a.dir);
        }
    }
}

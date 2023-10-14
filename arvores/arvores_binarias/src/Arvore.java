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

    public static void mostra_pre_ordem(Arvore a) {
        if (a != null) {
            System.out.println(" " + a.dado);
            mostra_pre_ordem(a.esq);
            mostra_pre_ordem(a.dir);
        }
    }

    public static void mostra_pos_ordem(Arvore a) {
        if (a != null) {
            mostra_pos_ordem(a.esq);
            mostra_pos_ordem(a.dir);
            System.out.println(" " + a.dado);
        }
    }
}

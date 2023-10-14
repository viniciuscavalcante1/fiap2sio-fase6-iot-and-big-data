public class ArvoreBuscaBinaria {
    public int dado;
    public ArvoreBuscaBinaria esq;
    public ArvoreBuscaBinaria dir;

    public static ArvoreBuscaBinaria init() {
        return null;
    }

    public static ArvoreBuscaBinaria inserir(ArvoreBuscaBinaria a, int info) {
        // insere um novo nó na árvore de busca binária
        if (a == null) {
            a = new ArvoreBuscaBinaria();
            a.dado = info;
            a.esq = null;
            a.dir = null;
        } else if (info < a.dado) {
            a.esq = inserir(a.esq, info);
        } else {
            a.dir = inserir(a.dir, info);
        }
        return a;
    }
}

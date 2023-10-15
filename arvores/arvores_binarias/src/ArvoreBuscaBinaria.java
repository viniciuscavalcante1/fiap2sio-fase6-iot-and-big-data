public class ArvoreBuscaBinaria {
    public int dado;
    public ArvoreBuscaBinaria esq;
    public ArvoreBuscaBinaria dir;
    public int h_esq;
    public int h_dir;

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

    public static ArvoreBuscaBinaria remove_valor(ArvoreBuscaBinaria a, int info) {
        if (a != null) {
            if (info == a.dado) {
                if (a.esq == null && a.dir == null) {
                    // nó folha
                    return null;
                }
                if (a.esq == null) {
                    // nó com um filho à direita
                    return a.dir;
                }
                if (a.dir == null) {
                    // nó com um filho à esquerda
                    return a.esq;
                }
// nó com dois filhos
                ArvoreBuscaBinaria aux, ref;
                ref = a.dir;
                aux = a.dir;
                while (aux.esq != null) {
                    aux = aux.esq;
                }
                aux.esq = a.esq;
                return ref;
            } else {
                if (info < a.dado) {
                    a.esq = remove_valor(a.esq, info);
                }
                else {
                    a.dir = remove_valor(a.dir, info);
                }
            }
        } return a;
    }
}

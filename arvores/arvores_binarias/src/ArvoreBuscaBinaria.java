public class ArvoreBuscaBinaria {
    public int dado;
    public ArvoreBuscaBinaria esq;
    public ArvoreBuscaBinaria dir;
    public int h_esq;
    public int h_dir;

    public static ArvoreBuscaBinaria init() {
        return null;
    }

    public static ArvoreBuscaBinaria rotacao_direita (ArvoreBuscaBinaria p){
        // faz rotação para direita em relação ao nó apontado por p
        ArvoreBuscaBinaria q,temp;
        q = p.esq;
        temp = q.dir;
        q.dir = p;
        p.esq = temp;
        if (temp == null)
            p.h_esq = 0;
        else if (temp.h_dir > temp.h_esq)
            p.h_esq = temp.h_dir + 1;
        else
            p.h_esq = temp.h_esq + 1;

        if (p.h_dir > p.h_esq)
            q.h_dir = p.h_dir + 1;
        else
            q.h_dir = p.h_esq + 1;
        return q;
    }

    public static ArvoreBuscaBinaria rotacao_esquerda(ArvoreBuscaBinaria p) {
// faz rotação para esquerda em relação ao nó apontado por p
        ArvoreBuscaBinaria q,temp;
        q = p.dir;
        temp = q.esq;
        q.esq = p;
        p.dir = temp;
        if (temp == null)
            p.h_dir = 0;
        else if (temp.h_dir > temp.h_esq)
            p.h_dir = temp.h_dir + 1;
        else
            p.h_dir = temp.h_esq + 1;

        if (p.h_dir > p.h_esq)
            q.h_esq = p.h_dir + 1;
        else
            q.h_esq = p.h_esq + 1;
        return q;
    }

    public static ArvoreBuscaBinaria balanceamento (ArvoreBuscaBinaria p) {
// analisa FB e realiza rotações necessárias para balancear árvore
        int FB = p.h_dir - p.h_esq;
        if (FB > 1) {
            int FB_filho_dir = p.dir.h_dir - p.dir.h_esq;
            if (FB_filho_dir >= 0)
                p = rotacao_esquerda(p);
            else {
                p.dir = rotacao_direita(p.dir);
                p = rotacao_esquerda(p);
            }
        }
        else {
            if (FB < -1) {
                int FB_filho_esq = p.esq.h_dir - p.esq.h_esq;
                if (FB_filho_esq <= 0)
                    p = rotacao_direita(p);
                else {
                    p.esq = rotacao_esquerda(p.esq);
                    p = rotacao_direita(p);
                }
            }
        }
        return p;
    }


    public static ArvoreBuscaBinaria inserir(ArvoreBuscaBinaria p, int info) {
// insere elemento em uma ABB
        if (p == null) {
            //insere nó como folha
            p=new ArvoreBuscaBinaria();
            p.dado = info;
            p.esq = null;
            p.dir = null;
            p.h_dir=0;
            p.h_esq=0;
        }
        else if (info < p.dado) {
            p.esq= inserir (p.esq, info);
            if (p.esq.h_dir > p.esq.h_esq)
                p.h_esq = p.esq.h_dir + 1;
            else
                p.h_esq = p.esq.h_esq + 1;
            p = balanceamento(p);
        }
        else {
            p.dir=inserir(p.dir, info);
            if (p.dir.h_dir > p.dir.h_esq)
                p.h_dir = p.dir.h_dir + 1;
            else
                p.h_dir = p.dir.h_esq + 1;
            p = balanceamento(p);
        }
        return p;
    }
}

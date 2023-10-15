import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entra = new Scanner(System.in);
        ArvoreBuscaBinaria raiz = ArvoreBuscaBinaria.init();
        int op,num;

        do {
            System.out.println("0- Encerrar Programa");
            System.out.println("1- inserir 1 elemento na árvore");
            System.out.println("2- listar elementos da árvore ");
            System.out.println("3- remover 1 elemento da árvore ");
            op = entra.nextInt();
            switch(op) {
                case 0:
                    System.out.println("Programa Encerrado");
                    break;
                case 1:
                    System.out.print("Digite valor do elemento: ");
                    num = entra.nextInt();
                    raiz = ArvoreBuscaBinaria.inserir(raiz, num);
                    break;
                case 2:
                    System.out.println("Apresentacao da arvore em ordem");
                    ArvoreBuscaBinaria.mostra_em_ordem(raiz);
                    break;
                case 3:
                    System.out.print("Digite valor do elemento a ser removido: ");
                    num = entra.nextInt();
                    raiz = ArvoreBuscaBinaria.remove_valor(raiz, num);
                    break;
                default:
                    System.out.println("Opcao invalida");
                    op = -1;
            }
        }while (op !=0);
        entra.close();
    }
}
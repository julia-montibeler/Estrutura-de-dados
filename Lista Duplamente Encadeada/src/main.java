import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ListaDupla> listas = new ArrayList<>();

        while (true) {
            System.out.println("1 - Criar nova lista");
            System.out.println("2 - Manipular listas");
            System.out.println("3 - Encerrar");
            int r = sc.nextInt();
            System.out.println("");

            if (r == 3) {
                break;
            }

            if (r == 1) {
                ListaDupla lista = new ListaDupla();
                listas.add(lista);
                System.out.println("Lista criada");
            }

            if (r == 2) {
                for (int i = 0; i < listas.size(); i++) {
                    System.out.print("Lista "+i + ": ");
                    listas.get(i).imprime();
                }
                System.out.println("");
                System.out.println("Qual lista deseja manipular?");
                int l = sc.nextInt();
                System.out.println("");
                while (true) {
                    System.out.println("1 - Inserir no ínicio");
                    System.out.println("2 - Inserir no fim");
                    System.out.println("3 - Imprimir");
                    System.out.println("4 - Verificar se está vazia");
                    System.out.println("5 - Retirar elemento");
                    System.out.println("6 - Esvaziar lista");
                    System.out.println("7 - Verificar igualdade entre 2 listas");
                    System.out.println("8 - Mesclar 2 listas");
                    System.out.println("9 - Comprimento da lista");
                    System.out.println("10 - Voltar");
                    System.out.println("");
                    r = sc.nextInt();

                    if (r == 10) {
                        break;
                    }

                    switch (r) {
                        case 1:
                            System.out.println("Valor a ser inserido: ");
                            listas.get(l).insere(sc.nextInt());
                            break;
                        case 2:
                            System.out.println("Valor a ser inserido: ");
                            listas.get(l).insereFim(sc.nextInt());
                            break;
                        case 3:
                            listas.get(l).imprime();
                            break;
                        case 4:
                            if (listas.get(l).vazia()) {
                                System.out.println("A lista está vazia");
                            } else {
                                System.out.println("A lista possui elementos");
                            }
                            break;
                        case 5:
                            System.out.println("Valor que deseja retirar: ");
                            listas.get(l).retira(sc.nextInt());
                            break;
                        case 6:
                            listas.get(l).libera();
                            break;
                        case 7:
                            for (int i = 0; i < listas.size(); i++) {
                                System.out.print(i + ": ");
                                listas.get(i).imprime();
                            }
                            System.out.println("Digite o número da lista que deseja usar para comparar: ");
                            boolean a = listas.get(l).igual(listas.get(sc.nextInt()));
                            if (a) {
                                System.out.println("As listas são iguais");
                            } else {
                                System.out.println("AS listas são diferentes");
                            }
                            break;
                        case 8:
                            for (int i = 0; i < listas.size(); i++) {
                                System.out.print(i + ": ");
                                listas.get(i).imprime();
                            }
                            System.out.println("Digite o número da lista que deseja usar para mesclar: ");
                            ListaDupla l3 = listas.get(l).merge(listas.get(sc.nextInt()));
                            System.out.print("A lista resultante é: ");
                            l3.imprime();
                            System.out.println("Deseja armazenar? (1 - sim, 2 - não)");
                            r = sc.nextInt();
                            if (r == 1) {
                                listas.add(l3);
                                System.out.println("A lista foi armazenada");
                            }
                            System.out.println("");
                            break;
                        case 9:
                            System.out.println("A lista tem " + listas.get(l).comprimento() + " elementos");
                    }
                    System.out.println("");
                }
            }
            System.out.println();
        }
    }
}

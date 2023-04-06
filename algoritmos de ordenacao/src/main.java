import java.util.Random;

public class main {
    public static void main(String[] args) {
        for(int i = 10; i <= 10000; i *= 10) {
            int [] v1 = criaVetorEmbaralhado(i);
            System.out.println("Tempo de execução (ms) " + i + " elementos: ");
            System.out.println("Bubble Sort: "+ tempoBubble(v1));
            v1 = criaVetorEmbaralhado(i);
            System.out.println("Quick Sort: "+ tempoQuick(v1));
            v1 = criaVetorEmbaralhado(i);
            System.out.println("Merge Sort: "+ tempoMerge(v1));
        }
    }

    //Gerar vetor aleatório com o tamanho desejado
    public static int [] criaVetorEmbaralhado(int tam) {
        Random r = new Random();
        int [] vetor = new int[tam];
        int n = 0;
        for (int i = 0; i < tam-1; i++) {
            n = r.nextInt(tam);
            while (pertence(vetor, n)) {
                n = r.nextInt(tam);
            }
            vetor[i] = n;
        }
        return vetor;
    }

    public static boolean pertence( int[] v, int n) {
        for (int i : v) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    //Métodos para calcular tempo de execução
    public static long tempoBubble(int[] v) {
        long inicio = System.currentTimeMillis();

        bubbleSort(v, v.length);

        long fim = System.currentTimeMillis();

        return (fim - inicio);
    }

    public static long tempoQuick(int[] v) {
        long inicio = System.currentTimeMillis();

        quickSort(v, v.length);

        long fim = System.currentTimeMillis();

        return (fim - inicio);
    }

    public static long tempoMerge(int[] v) {
        long inicio = System.currentTimeMillis();

        mergeSort(v, v.length);

        long fim = System.currentTimeMillis();

        return (fim - inicio);
    }

    //BubbleSort
    public static void bubbleSort(int[] v, int n) {
        int j;
        boolean troca = false;
        for (int i = 0; i < n-1; i++) {
            if (v[i] > v[i+1]) {
                int temp = v[i];
                v[i] = v[i+1];
                v[i+1] = temp;
                troca = true;
            }
        }

        if(troca) {
            bubbleSort(v, n-1);
        }
    }


    //QuickSort
    public static void quickSort(int[] v, int n) {
        quickSortAux(v, 0, n-1);
    }

    public static void quickSortAux(int[] v, int a, int b) {
        if (a < b) {
            int indicePivo = particionar(v, a, b);
            quickSortAux(v, a, indicePivo-1);
            quickSortAux(v, indicePivo+1, b);
        }
    }

    public static int particionar(int[] v, int a, int b) {
        int temp = v[a];
        while(a < b) {
            while (v[a] < temp) {
                a++;
            }
            while (v[b] > temp) {
                b--;
            }
            troca(v, a, b);
        }
        return a;
    }

    public static void troca(int[]v, int a , int b) {
        int temp = v[a];
        v[a] = v[b];
        v[b] = temp;
    }


    //MergeSort
    public static void mergeSort (int[] v, int n) {
        mergeSortAux(v, 0, n-1);
    }

    public static void mergeSortAux(int[] v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortAux(v, inicio, meio);
            mergeSortAux(v, meio + 1, fim);
            merge(v, inicio, meio, fim);
        }
    }

    public static void merge(int[] v, int inicio, int meio, int fim) {
        int n1 = meio - inicio +1;
        int n2 = fim - meio;

        int[] esq = new int[n1+1];
        int[] dir = new int[n2+1];

        for (int i = 0; i < n1; i++) {
            esq[i] = v[inicio + i];
        }

        for (int j = 0; j < n2; j++) {
            dir[j] = v[meio + j + 1];
        }

        esq[n1] = Integer.MAX_VALUE;
        dir[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = inicio; k <= fim; k++) {
            if (esq[i] <= dir[j]) {
                v[k] = esq[i];
                i++;
            } else {
                v[k] = dir[j];
                j++;
            }
        }
    }
}

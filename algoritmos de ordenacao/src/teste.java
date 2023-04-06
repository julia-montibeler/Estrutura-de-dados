import java.util.Arrays;

    class Teste
    {
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

        public static void main(String[] args)
        {
            int[] a = {5,6,1,3,4,9,2,7,8,11};

            for (int x: a) {
                System.out.print(x+" ");
            }
            System.out.println("");
            mergeSort(a, a.length);
            for (int x: a) {
                System.out.print(x+" ");
            }
        }
    }

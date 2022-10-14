package br.com.ed.bingo;

public class MetodosIterativos {
    public static int[] selectionSort(int[] vetor) {
        int menor = 0, aux = 0;
        for (int i = 0; i < vetor.length; i++) {
            menor = i;
            for (int k = i + 1; k < vetor.length; k++) {
                if (vetor[k] > vetor[menor]) {
                    menor = k;
                }
                System.out.println(i + " " + k);

            }
            aux = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = aux;
        }
        return vetor;
    }

    public static int[] insertionSort(int[] vetor) {
        int temp;
        for (int i = 1; i < vetor.length; ) {
            if (vetor[i] < vetor[i - 1]) {
                temp = vetor[i];
                vetor[i] = vetor[i - 1];
                vetor[i - 1] = temp;

                if (i > 1) {
                    i--;
                }
            } else {
                i++;
            }
        }

        return vetor;
    }
}

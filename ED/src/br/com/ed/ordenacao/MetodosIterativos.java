package br.com.ed.ordenacao;

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
}

package br.com.ed.ordenacao;

import java.util.Arrays;
import java.util.HashSet;

public class MetodosIterativos {
    public static int[] selectionSort(int[] vetor) {
        int menor = 0, aux = 0;
        for (int i = 0; i < vetor.length; i++) {
            menor = i;
            for (int k = i + 1; k < vetor.length; k++) {
                organizarPrint(vetor, k);

                if (vetor[k] < vetor[menor]) {
                    menor = k;
                }
            }
            aux = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = aux;


        }
        return vetor;
    }

    public static int[] insertionSort(int[] vetor) {
        for (int i = 0, aux = 0; i < vetor.length - 1; ) {
            organizarPrint(vetor, i);
            if (vetor[i] > vetor[i + 1]) {
                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
                if (i > 0)
                    i--;
            } else {
                i++;
            }
        }

        return vetor;
    }

    public static int[] bubbleSort(int[] vetor) {
        int tamanho = vetor.length, aux;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho - 1; j++) {
                organizarPrint(vetor, j);
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    aux = vetor[i];
                }
            }
        }
        return vetor;
    }

    public static int maiorNumero(int[] vetor) {
        int maior = vetor[0];

        for (int i : vetor) {
            if (maior < i) {
                maior = i;
            }
        }

        return maior;
    }

    public static void organizarPrint(int[] vetor, int menor) {
        String[][] matriz = new String[vetor.length][maiorNumero(vetor) + 1];
        HashSet<Integer> contem = new HashSet<>();

        for (int i = 0; i < vetor.length; i++) {
            Arrays.fill(matriz[i], "░░");
        }


        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[i] + 1; j++) {
                if (i == menor) {
                    matriz[i][j] = "├┤";
                } else {
                    matriz[i][j] = "██";
                }
            }
        }

        mostrarMatriz(matriz);
    }

    public static void mostrarMatriz(String[][] matriz) {
        String aux = "";
        for (int j = matriz[0].length - 1; j > 0; j--) {
            for (int i = 0; i < matriz.length; i++) {
                aux += matriz[i][j];
            }
            aux += "\n";
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.fillInStackTrace());
        }
        System.out.println(aux);
    }


}

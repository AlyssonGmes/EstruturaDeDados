package br.com.edu.ordenacao;

public class Main {

    public static void main(String[] args) {
        int vetor[] = new int[]{3, 0, 1, 8, 7, 2, 5, 4, 9, 6,10,23,15,11,22,18,12,19,14};

        SortingAlgorithms.quickSort(vetor, 0, vetor.length - 1);
    }
}

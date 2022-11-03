package br.com.edu.ordenacao;

public class Main {

    public static void main(String[] args) {
        int vetor[] = new int[]{3, 0, 1, 8, 7, 2, 5, 4, 9, 6};

        QuickSort.ordena(vetor, 0, vetor.length - 1);

        for (int i : vetor) {
            System.out.print(i + " ");
        }

    }
}

package br.com.ed.ordenacao;

public class Main {

    public static void main(String[] args) {
        int vetor[] = new int[]{0, 7, 1, 5, 4, 3, 2, 9, 1, 2, 3, 10, 11, 8, 6};

        MetodosIterativos.setVelocidadePrint(500);
        MetodosIterativos.selectionSort(vetor);

    }
}

package br.com.ed.ordenacao;

public class Main {

    public static void main(String[] args) {
        int vetor[] = new int[]{0, 7, 1, 5, 4, 3, 2, 9, 1, 2, 3, 10, 11, 8, 6};

        MetodosIterativos.setVelocidadePrint(200);
        //  MetodosIterativos.insertionSort(vetor);
        int n[] = {1, 2, 3};
        int[] k = {5, 6, 7};

        int m[] = new int[6];
        n = MetodosIterativos.merge(n, k);
        for(int i : n){
            System.out.println(i);
        }
    }
}

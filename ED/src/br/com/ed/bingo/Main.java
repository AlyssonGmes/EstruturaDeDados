package br.com.ed.bingo;

public class Main {

    public static void main(String[] args) {
        int[] vetor = {9, 2, 6, 5, 3, 4, 10, 0};

        for(int v : MetodosIterativos.insertionSort(vetor)){
            System.out.print(v+" ");
        }
    }
}

package br.com.ed.ordenacao;

public class Main {

    public static void main(String[] args) {
        int vetor[] = new int[]{1, 5, 4, 3, 2, 9, 0};
        for(int n : MetodosIterativos.selectionSort(vetor)){
            System.out.print(n+" - ");
        }

    }
}

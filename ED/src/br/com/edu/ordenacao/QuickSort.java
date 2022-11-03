package br.com.edu.ordenacao;

public class QuickSort {

    public static void ordena(int[] vetor, int esquerda, int direita) {
        int pivo = 0;
        if (esquerda < direita) {
            pivo = buscaPivo(vetor, esquerda, direita);
            ordena(vetor, esquerda, pivo);
            ordena(vetor, pivo + 1, direita);
        }
    }

    public static int buscaPivo(int[] vetor, int esquerda, int pivo) {

        int temp;

        boolean trocaContexto = true;

        do {
            if (trocaContexto) {
                if (vetor[esquerda] > vetor[pivo]) {
                    temp = vetor[esquerda];
                    vetor[esquerda] = vetor[pivo];
                    vetor[pivo] = temp;
                    esquerda++;
                    trocaContexto = false;
                } else {
                    pivo--;
                }
            } else {
                if (vetor[pivo] < vetor[esquerda]) {
                    temp = vetor[esquerda];
                    vetor[esquerda] = vetor[pivo];
                    vetor[pivo] = temp;
                    pivo--;
                    trocaContexto = true;
                } else {
                    esquerda++;
                }
            }
        }

        while (esquerda != pivo);


        return pivo;
    }

}
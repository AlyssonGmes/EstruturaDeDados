package br.com.ed.bingo;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bingo b1 = new Bingo();
        Bingo.armazenarBingo(b1.gerarBingo(3, 7,7));

        Cartela.mostrarCartelas(Bingo.getConjuntoBingo());

    }

    public static double[] criarVetor(int tamanho){
        double [] vetor = new double[tamanho];

        for(int i = 0; i < tamanho; i++){

            vetor[i] = ((double)(new Random().nextInt(100)))/10;
        }
        return vetor;
    }
}

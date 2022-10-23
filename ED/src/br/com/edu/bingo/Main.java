package br.com.edu.bingo;

import br.com.edu.bingo.product.Bingo;
import br.com.edu.bingo.product.Cartela;
import br.com.edu.bingo.product.Premio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bingo b1 = new Bingo();
        b1.criarPremio(500, "Primeiro lugar", "Primeiro jogador a preencher a cartela.");
        b1.criarPremio(250, "Segundo lugar", "Segundo jogador a preencher a cartela.");
        b1.criarPremio(100, "Terceiro lugar", "Terceiro jogador a preencher a cartela.");

        b1.gerarBingo(50, 5, 5);
        // Cartela.mostrarCartelas(b1.conjuntoBingo);
        //b1.verPremios();
        Cartela.mostrarCartelas(b1.conjuntoBingo);

        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
        Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);

        Premio.verGanhadores(b1.conjuntoBingo);
    }
}
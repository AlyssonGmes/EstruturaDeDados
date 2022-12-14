package ifs.ed1.bingo;

import java.util.Scanner;
public class GerenciarBingo {
    public static void menu() throws Exception {
        Scanner scn = new Scanner(System.in);
        int qtdCartelas, qtdLinhas, qtdColunas;
        System.out.print("Insira a quantidade de cartelas: ");
        qtdCartelas = scn.nextInt();
        System.out.print("Insira a quantidade de linhas: ");
        qtdLinhas = scn.nextInt();
        System.out.print("Insira a quantidade de colunas: ");
        qtdColunas = scn.nextInt();
        System.out.println();

        Bingo bingo = new Bingo(qtdCartelas, qtdLinhas, qtdColunas);

        bingo.listarCartelas();

        int temp;
        boolean valor = true;
        System.out.println("Em breve o sorteio será iniciado.");
        Thread.sleep(3000);
        do {
            bingo.SortearNumero();

            Thread.sleep(100);

        } while(bingo.getQtdDezenasRestantes() != 0);
        System.out.println("Fim de jogo.");

        //bingo.listarNaoSorteados();
    }
}

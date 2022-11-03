package br.com.edu.bingo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rnd = new Scanner(System.in);
        ModuloGerenciador mg = new ModuloGerenciador();
        int opcao;

        do {
            System.out.println("1 - Novo Bingo ");
            System.out.println("2 - Mostrar todas as cartelas");
            System.out.println("3 - Sortear dezena");
            System.out.println("4 - Ver ganhadores");
            System.out.println("5 - Ver dezenas sorteadas");
            System.out.println("6 - Sair");
            opcao = rnd.nextInt();
            mg.menu(opcao);
        } while (opcao != 6);

    }
}
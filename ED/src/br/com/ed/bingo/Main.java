package br.com.ed.bingo;

public class Main {
    public static void main(String[] args) {
        Bingo b1 = new Bingo();
        Bingo.armazenarBingo(b1.gerarBingo(3, 7, 7));
        Bingo.armazenarBingo(b1.gerarBingo(3, 3, 3));
        Cartela.mostrarCartelas(Bingo.conjuntoBingo);
        b1.zerarBingo();
        Cartela.mostrarCartelas(Bingo.conjuntoBingo);
        ///Cartela.mostrarCatela(new Cartela(3,5));
    }
}
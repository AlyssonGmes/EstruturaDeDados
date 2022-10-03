public class Main {
    public static void main(String[] args) {
        Cartela c1 = new Cartela();

        Cartela.mostrarCartela(c1.gerarCartela(5,5));

        Bingo hrDoBingo = new Bingo();
        Cartela.mostrarCartelas(hrDoBingo.gerarBingo(5, 5, 5));
    }
}

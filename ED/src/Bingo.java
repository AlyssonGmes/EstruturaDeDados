
//Questao 4.1
public class Bingo {
    public Object[] gerarBingo(int numDeCartelas, int m, int n) {
        Cartela temp = new Cartela();

        Object[] arrCartelas = new Object[numDeCartelas];

        for (int i = 0; i < numDeCartelas; i++) {
            arrCartelas[i] = temp.gerarCartela(m, n);

        }
        return arrCartelas;
    }

    //Questao 5
    //Faça um programa para armazenar um conjunto de cartelas de bingo (gerada na
    //questão anterior).
}

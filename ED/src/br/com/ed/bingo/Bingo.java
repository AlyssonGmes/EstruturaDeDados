package br.com.ed.bingo;

//Questao 4.1
public class Bingo {

    //Bingos prontos armazenados
    public static Object[] conjuntoBingo = new Object[10];

    //index do array de bingos
    private static int pos = 0;

    //Gera n cartelas
    public Object[] gerarBingo(int numDeCartelas, int m, int n) {
        Cartela temp = new Cartela();

        Object[] arrCartelas = new Object[numDeCartelas];

        for (int i = 0; i < numDeCartelas; i++) {
            arrCartelas[i] = temp.gerarCartela(m, n);

        }
        return arrCartelas;
    }

    //Questao 5
    //Armazena bingos criados no vetor de objetos "conjuntoBingo"
    static void armazenarBingo(Object[] bingo) {
        if (bingo.length >= conjuntoBingo.length - pos) {
            Object[] novoConjunto = new Object[conjuntoBingo.length + bingo.length + 30];
            for (int i = 0; i < conjuntoBingo.length; i++) {
                novoConjunto[i] = conjuntoBingo[i];
                if (conjuntoBingo[i] == null) {
                    break;
                }
            }

            for (int i = 0; i < bingo.length; pos++, i++) {
                novoConjunto[pos] = bingo[i];
            }

            conjuntoBingo = novoConjunto;
        } else {
            for (int i = 0; i < bingo.length; i++, pos++) {
                conjuntoBingo[pos] = bingo[i];
            }
        }
    }

    public static Object[] getConjuntoBingo() {
        return conjuntoBingo;
    }
}
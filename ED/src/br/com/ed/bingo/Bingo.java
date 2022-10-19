package br.com.ed.bingo;

//Questao 4.1
public class Bingo {
    //Bingos prontos armazenados
    public static Cartela[] conjuntoBingo = new Cartela[10];

    //index do array de bingos
    private static int pos = 0;

    //Gera n cartelas
    public Cartela[] gerarBingo(int numDeCartelas, int m, int n) {
        Cartela[] arrCartelas = new Cartela[numDeCartelas];
        for (int i = 0; i < numDeCartelas; i++) {
            arrCartelas[i] = new Cartela(m, n);
        }
        return arrCartelas;
    }

    //Questao 5
    //Armazena bingos criados no vetor de objetos "conjuntoBingo"
    static void armazenarBingo(Cartela[] bingo) {
        if (bingo.length >= conjuntoBingo.length - pos) {
            Cartela[] novoConjunto = new Cartela[conjuntoBingo.length + bingo.length + 30];
            for (int i = 0; i < conjuntoBingo.length; i++) {
                novoConjunto[i] = conjuntoBingo[i];
                if (conjuntoBingo[i] == null) {
                    break;
                }
            }

            System.out.println("Olá");
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


    public void zerarBingo() {
        conjuntoBingo = null;
        System.out.println("Bingo excluído.");
        Cartela.setId_cartela(0);
    }

    Premio premioDoBingo;

    //Gerenciar prêmio do bingo
    public void gerenciarPremio(double valor, String nome, String descricao, int numero, Object[] cartelasGanhadoras, int[] numerosSorteados) {
        premioDoBingo.gerenciarPremio(valor, nome, descricao, numero, cartelasGanhadoras, numerosSorteados);
    }
}
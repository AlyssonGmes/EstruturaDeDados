import java.util.Random;
import java.util.Set;

public class Cartelas {
    private final int[][] casas = new int[5][5];
    private final Random rnd = new Random();

    //gera 1 cartela
    private int[][] gerarCartela() {

        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                casas[i][k] = rnd.nextInt(59)+1;
            }

            if(i==4){
                if(validarCartela(casas)){
                  //     i = 0;
                }
            }
        }

        return casas;
    }

    //exibe todas as cartelas a partir de um array de objetos
    public void mostrarCartelas(Object[] arr) {
        int[][] num;

        for (Object n : arr) {
            //pegar cartelas
                num = (int[][]) n;
                //imprimir cartela
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (num[j][k] < 10) {
                            System.out.print("0" + num[j][k] + " ");
                        } else {
                            System.out.print(num[j][k] + " ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("\n");
        }
    }


    //retorna um array de objetos contendo n tabelas
    public Object[] gerarBingo(int numDeCartelas) {
        Object[] arrCartelas = new Object[numDeCartelas];

        for (int i = 0; i < numDeCartelas; i++) {
            arrCartelas[i] = gerarCartela();
        }

        return arrCartelas;
    }

    //retorna true se algum elemento for igual
    private boolean validarCartela(int[][] cartela) {
        for (int linha = 0; linha < 5; linha++) {
            for (int col = 0; col < 5; col++) {

                for (int l = 0; l < 5; l++) {
                    for (int c = 0; c < 5; c++) {

                        if(linha != l && col != c){
                            if(cartela[linha][col] == cartela[l][c]){
                                System.out.println(cartela[linha][col]+ " repetido\n");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

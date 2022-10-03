import java.util.Random;

public class Cartelas {
    private final Random rnd = new Random();

    //gera 1 cartela
    private int[][] gerarCartela() {
        final int[][] casas = new int[5][5];
        int cartelasProntas = 0;

        for (int i = cartelasProntas; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                casas[i][k] = rnd.nextInt(59) + 1;
            }

            if(i == 4){
                if(validarTabela(casas)){
                    i = cartelasProntas;
                }
                cartelasProntas++;
            }
        }

        return casas;
    }

    //retorna um array de objetos contendo n cartelas
    public Object[] gerarBingo(int numDeCartelas) {
        Object[] arrCartelas = new Object[numDeCartelas];

        for (int i = 0; i < numDeCartelas; i++) {
            arrCartelas[i] = gerarCartela();

        }
        return arrCartelas;
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


    //retorna true se a cartela possuir números iguais
    public boolean validarTabela(int[][] arrCartela) {
        //ponteiro 1
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {

                //ponteiro 2
                for (int i1 = 0; i1 < 5; i1++) {
                    for (int k1 = 0; k1 < 5; k1++) {

                        //para não apontar para a mesma posição
                        if(i != i1 || k !=k1){
                            if(arrCartela[i][k] == arrCartela[i1][k1]){
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

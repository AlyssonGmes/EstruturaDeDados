import java.util.Calendar;
import java.util.Date;
import java.util.Random;

//Questao 4
public class Cartela {
    private final Random rnd = new Random();

    //Número identificador da cartela
    private static int id_cartela = 0;
    private int identificador;
    private Date dataDeGeração = Calendar.getInstance().getTime();

    public Cartela() {
        identificador = id_cartela;
        id_cartela++;
    }


    //gera 1 cartela
    public int[][] gerarCartela(int m, int n) {
        final int[][] casas = new int[m][n];
        int cartelasProntas = 0;

        for (int i = cartelasProntas; i < m; i++) {
            for (int k = 0; k < n; k++) {
                casas[i][k] = rnd.nextInt(59) + 1;
            }

            if (i == 4) {
                if (validarTabela(casas)) {
                    i = cartelasProntas;
                }
                cartelasProntas++;
            }
        }

        return casas;
    }

    //exibe uma única cartelas a partir de um array de inteiros
    public static void mostrarCartela(int[][] cartela) {
        for (int j = 0; j < cartela.length; j++) {
            for (int k = 0; k < cartela[0].length; k++) {
                if (cartela[j][k] < 10) {
                    System.out.print("0" + cartela[j][k] + " ");
                } else {
                    System.out.print(cartela[j][k] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    //exibe todas as cartelas a partir de um array de objetos
    public static void mostrarCartelas(Object[] arr) {
        int[][] num;

        for (Object n : arr) {
            //pegar cartelas
            num = (int[][]) n;

            //Tabelas armazenadas sempre apresentarão valores nulos
            if (num == null) {
                break;
            }

            //imprimir cartela
            for (int j = 0; j < num.length; j++) {
                for (int k = 0; k < num[0].length; k++) {
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
    private boolean validarTabela(int[][] arrCartela) {
        //ponteiro 1
        for (int i = 0; i < arrCartela.length; i++) {
            for (int k = 0; k < arrCartela[0].length; k++) {

                //ponteiro 2
                for (int i1 = 0; i1 < arrCartela.length; i1++) {
                    for (int k1 = 0; k1 < arrCartela[0].length; k1++) {

                        //para não apontar para a mesma posição
                        if (i != i1 || k != k1) {
                            if (arrCartela[i][k] == arrCartela[i1][k1]) {
                                return true;
                            }
                        }
                    }
                }

            }
        }

        return false;
    }


    public static int getId_cartela() {
        return id_cartela;
    }

    public int getIdentificador() {
        return identificador;
    }

    public Date getDataDeGeração() {
        return dataDeGeração;
    }
}
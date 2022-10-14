package br.com.ed.bingo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

//Questao 4
public class Cartela implements ICartelaJogo {
    private static final Random rnd = new Random();

    int[][] cartela;

    //Referência para criar ids
    private static int id_cartela = 0;

    //Identificador único de cada cartela
    private final int identificador;

    //Data de criação: String
    String dataDeGeracao = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

    //formata a saída das dezenas
    final static DecimalFormat df = new DecimalFormat("00.###");

    //Construtor de Cartela, incrementando identificador a cada cartela criada
    public Cartela() {
        identificador = id_cartela;
        id_cartela++;
    }

/*    //gera 1 cartela de matriz m x n
    public int[][] gerarCartela(int m, int n) {
        final int[][] casas = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                casas[i][k] = rnd.nextInt(59) + 1;
            }
        }
        return removerDuplicados(casas);
    }*/

    //Utilizar o método ordenarCartela e incrementa os números duplicados na cartela
    public static int[][] removerDuplicados(int[][] arr) {
        int aux;
        do {
            arr = ordernarCartela(arr);
            aux = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < arr[0].length - 1; k++) {

                    //Comparação padrão início-fim da linha
                    if (arr[i][k] == arr[i][k + 1]) {
                        if (arr[i][k] > 0 && arr[i][k] < 60) {
                            arr[i][k]++;
                            aux++;
                        } else {
                            arr[i][k] = 1;
                            aux++;
                        }
                    }

                    //compara o último da linha com o primeiro da próxima linha
                    if (k == arr[0].length - 2 && i < arr.length - 1) {
                        if (arr[i + 1][0] == arr[i][k + 1]) {
                            arr[i + 1][0]++;
                        }
                    }
                }
            }
        } while (aux > 0);
        return arr;
    }

    //Ordena uma cartela
    public static int[][] ordernarCartela(int[][] arr) {
        for (int i = 0, temp; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                for (int m = 0; m < arr.length; m++) {
                    for (int n = 0; n < arr[0].length; n++) {
                        if (arr[i][k] < arr[m][n]) {
                            temp = arr[m][n];
                            arr[m][n] = arr[i][k];
                            arr[i][k] = temp;
                        }
                    }
                }
            }
        }
        return arr;
    }

    //exibe uma única cartelas a partir de um array de inteiros
    public void mostrarCartela() {

        for (int[] arr : this.cartela) {
            for (int pos : arr) {
                System.out.print(df.format(pos) + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    //exibe todas as cartelas a partir de um array de objetos
    public static void mostrarCartelas(Object[] arr) {
        int[][] temp;

        for (Object cartelas : arr) {
            temp = (int[][]) cartelas;
            if (temp == null) {
                break;
            }

            for (int[] cartela : temp) {
                for (int pos : cartela) {
                    System.out.print(df.format(pos) + " ");
                }
                System.out.println();
            }

            System.out.println();
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

    public int[][] getCartela() {
        return cartela;
    }

    public void setCartela(int[][] cartela) {
        this.cartela = cartela;
    }

    public String
    getDataDeGeracao() {
        return dataDeGeracao;
    }

    //Gera um objeto do tipo ICartelaJogo, com 1 cartela nesta instância
    static ICartelaJogo gerarCartelaJogo(int N, int M) {
        final int[][] casas = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                casas[i][k] = rnd.nextInt(59) + 1;
            }
        }

        Cartela novaCartela = new Cartela();
        novaCartela.cartela = removerDuplicados(casas);

        return novaCartela;
    }

    public void marcarNumeroSorteado(int N) {

    }

    public boolean ehCartelaVencedora(boolean verificarPorLinha) {

        return false;
    }

    //comentário
}

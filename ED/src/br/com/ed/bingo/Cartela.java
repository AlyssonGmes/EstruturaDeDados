package br.com.ed.bingo;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

//Questao 4
public class Cartela implements ICartelaJogo {
    private final Random rnd = new Random();

    //Número identificador da cartela
    private static int id_cartela = 0;
    private final int identificador;

    String dataDeGeracao = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

    public Cartela() {
        identificador = id_cartela;
        id_cartela++;
    }

    //gera 1 cartela
    public int[][] gerarCartela(int m, int n) {
        final int[][] casas = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                casas[i][k] = rnd.nextInt(59) + 1;
            }
        }
        return removerDuplicados(casas);
    }

    public static int[][] removerDuplicados(int[][] arr) {
        int aux;
        do {
            arr = ordernar(arr);
            aux = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < arr[0].length - 1; k++) {
                    if (arr[i][k] == arr[i][k + 1]) {
                        if (arr[i][k] > 0 && arr[i][k] < 60) {
                            arr[i][k]++;
                            aux++;
                        } else {
                            arr[i][k] = 1;
                            aux++;
                        }
                    }

                    if (k == arr[0].length - 1 && i != arr.length - 1) {
                        if (arr[i][k] == arr[i + 1][k]) {
                            arr[i + 1][k]++;
                        }
                    }
                }
            }
        } while (aux > 0);
        return arr;
    }

    public static int[][] ordernar(int[][] arr) {
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

    public String
    getDataDeGeracao() {
        return dataDeGeracao;
    }

    //Implementações da interface ICarteloJogo
    static ICartelaJogo gerarCartelaJogo(int N, int M) {
        return null;
    }

    public void marcarNumeroSorteado(int N) {

    }

    public boolean ehCartelaVencedora(boolean verificarPorLinha) {
        return false;
    }
}

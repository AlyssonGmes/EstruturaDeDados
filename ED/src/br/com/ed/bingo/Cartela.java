package br.com.ed.bingo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

//Questao 4
public class Cartela implements ICartelaJogo {
    private final Random rnd = new Random();
    //Referência para criar ids
    private static int id_cartela = 0;

    //Identificador único de cada cartela
    private final int identificador;

    //Data de criação: String
    private String dataDeGeracao;

    private int[][] cartela;

    //Construtor de Cartela, incrementando identificador a cada cartela criada
    public Cartela(int m, int n) {
        identificador = id_cartela;
        id_cartela++;
        dataDeGeracao = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        cartela = gerarCartela(m, n);
    }

    //gera 1 cartela de matriz m x n
    public int[][] gerarCartela(int m, int n) {
        final int[][] casas = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                casas[i][k] = rnd.nextInt(59) + 1;
            }
        }
        return removerDuplicados(casas);
    }

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

    //exibe todas as cartelas a partir de um array de objetos
    public static void mostrarCartelas(Cartela[] arr) {
        if(arr == null){
            System.out.println("O bingo não existe.");
            return;
        }
        for (Cartela i : arr) {
            if (i != null)
                mostrarCatela(i);
        }
    }

    public static void mostrarCatela(Cartela arr) {
        System.out.println(arr.getIdentificador() + 1 + "ª" + "\t| Data de Criação: " + arr.getDataDeGeracao());
        verMatriz(arr.cartela);
    }

    public static void verMatriz(int[][] arr) {
        //imprimir matriz
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr[0].length; k++) {
                if (arr[j][k] < 10) {
                    System.out.print("0" + arr[j][k] + " ");
                } else {
                    System.out.print(arr[j][k] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("");

    }

    //Implementações da interface ICarteloJogo
    static ICartelaJogo gerarCartelaJogo(int n, int m) {
        return new Cartela(n, m);
    }

    public void marcarNumeroSorteado(int N) {
        int[][] arr = new int[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                if (arr[i][k] == N) {
                    arr[i][k] = 0;
                }
            }
        }
    }

    public boolean ehCartelaVencedora(boolean verificarPorLinha) {
        int[][] arr = new int[0][0];

        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                if (arr[i][k] == 0) {
                    contador++;
                }
            }
        }
        if (contador == arr.length * arr[0].length) {
            return true;
        }

        return false;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getDataDeGeracao() {
        return dataDeGeracao;
    }

    public static void setId_cartela(int id_cartela) {
        Cartela.id_cartela = id_cartela;
    }

    //retorna true se a cartela possuir números iguais (em desuso)
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
}
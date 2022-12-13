import java.util.Arrays;
import java.util.HashSet;

public class Algoritmos {
    static int velocidade = 450;

    public static int[] selectionSort(int[] vetor) {
        int menor = 0, aux = 0;
        for (int i = 0; i < vetor.length; i++) {
            menor = i;
            for (int k = i + 1; k < vetor.length; k++) {
                organizarPrint(vetor, k);

                if (vetor[k] < vetor[menor]) {
                    menor = k;
                }
            }
            aux = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = aux;


        }
        return vetor;
    }

    public static int[] mergeSort(int[] vetor) {

        int metadeTamanho = vetor.length / 2;
        int[] vetorEsquerdo = new int[metadeTamanho];
        int[] vetorDireito = new int[vetor.length - metadeTamanho];

        if (vetor.length < 2) {
            return vetor;
        }

        for (int i = 0; i < metadeTamanho; i++) {
            vetorEsquerdo[i] = vetor[i];
        }

        for (int i = metadeTamanho; i < vetor.length; i++) {
            vetorDireito[i - metadeTamanho] = vetor[i];
        }

        return merge(vetor, mergeSort(vetorEsquerdo), mergeSort(vetorDireito));
    }

    public static int[] merge(int[] vetor, int[] vetorL, int[] vetorR) {
        int tamanhoL = vetorL.length;
        int tamanhoR = vetorR.length;
        int i = 0, j = 0, k = 0;

        do {
            if (vetorL[i] <= vetorR[j]) {
                vetor[k] = vetorL[i];
                i++;
            } else {
                vetor[k] = vetorR[j];
                j++;
            }
            k++;
        } while (i < tamanhoL && j < tamanhoR);

        while (i < tamanhoL) {
            vetor[k] = vetorL[i];
            k++;
            i++;
        }
        while (j < tamanhoR) {
            vetor[k] = vetorR[j];
            k++;
            j++;
        }

        return vetor;
    }

    //lomuto

    public static int[] quickSort(int[] vetor, int esquerda, int direita) {
        ordena(vetor, 0, vetor.length - 1);
        return vetor;
    }

    public static void ordena(int[] vetor, int esquerda, int direita) {
        int pivo = 0;

        if (esquerda < direita) {
            pivo = buscaPivo(vetor, esquerda, direita);
            ordena(vetor, esquerda, pivo);

            ordena(vetor, pivo + 1, direita);
        }
    }

    public static int buscaPivo(int[] vetor, int esquerda, int pivo) {

        int temp;

        boolean trocaContexto = true;

        do {
            if (trocaContexto) {
                if (vetor[esquerda] > vetor[pivo]) {
                    temp = vetor[esquerda];
                    vetor[esquerda] = vetor[pivo];
                    vetor[pivo] = temp;
                    esquerda++;
                    trocaContexto = false;
                } else {
                    pivo--;
                }
            } else {
                if (vetor[pivo] < vetor[esquerda]) {
                    temp = vetor[esquerda];
                    vetor[esquerda] = vetor[pivo];
                    vetor[pivo] = temp;
                    pivo--;
                    trocaContexto = true;
                } else {
                    esquerda++;
                }
            }
            organizarPrint(vetor, pivo);
        }

        while (esquerda != pivo);
        return pivo;
    }

    public static int[] insertionSort(int[] vetor) {
        for (int i = 0, aux = 0; i < vetor.length - 1; ) {
            organizarPrint(vetor, i);
            if (vetor[i] > vetor[i + 1]) {
                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
                if (i > 0) i--;
            } else {
                i++;
            }
        }

        return vetor;
    }

    public static int[] bubbleSort(int[] vetor) {
        int tamanho = vetor.length, aux;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                organizarPrint(vetor, j);
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }

            }
        }
        return vetor;
    }

    public static int maiorNumero(int[] vetor) {
        int maior = vetor[0];

        for (int i : vetor) {
            if (maior < i) {
                maior = i;
            }
        }

        return maior;
    }

    public static void organizarPrint(int[] vetor, int menor) {
        String[][] matriz = new String[vetor.length][maiorNumero(vetor) + 1];
        HashSet<Integer> contem = new HashSet<>();

        for (int i = 0; i < vetor.length; i++) {
            Arrays.fill(matriz[i], "░░");
        }


        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[i] + 1; j++) {
                if (i == menor) {
                    if (vetor[menor] > 9) {
                        matriz[i][j] = "" + vetor[menor];
                    } else {
                        matriz[i][j] = " " + vetor[menor];
                    }
                } else {
                    matriz[i][j] = "██";
                }
            }
        }

        mostrarMatriz(matriz);

    }

    public static void mostrarMatriz(String[][] matriz) {
        String aux = "";
        for (int j = matriz[0].length - 1; j > 0; j--) {
            for (int i = 0; i < matriz.length; i++) {
                aux += matriz[i][j];
            }
            aux += "\n";
        }
        try {
            Thread.sleep(velocidade);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(aux);
    }

    public static void setVelocidadePrint(int velocidade) {
        Algoritmos.velocidade = velocidade;
    }
}
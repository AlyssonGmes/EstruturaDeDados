package ifs.ED.bingo;

import ifs.ED.lista.Lista;
import ifs.ED.lista.ListaEncOrdenada;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Cartela implements ICartelaJogo {
    protected Lista<Lista<NumeroCartela>> dados = new ListaEncOrdenada<>();
    protected Integer identificador = 0;
    protected Date dataGeracao;
    private static int idsGerados = 0;
    boolean estahEmUso = true;
    int qtdColunas;
    int qtdLinhas;
    int casasRestantes;

    static int posicao = 0;

    Random rnd = new Random();

    public Cartela(int tamanhoMatriz, int identificador) throws Exception {
        this(tamanhoMatriz, tamanhoMatriz, identificador);
    } //ok

    /**
     * Cria a cartela com os números conforme a matriz N x M.
     * Um número identificador (geralmente um sequencial) deverá ser informado.
     *
     * @param N
     * @param M
     * @param identificador
     * @throws Exception
     */
    public Cartela(int N, int M, int identificador) throws Exception {

        if ((N * M) > 60) {
            throw new Exception("A quantidade de linhas e colunas ultrapassam o limite de 60 casas.");
        }

        this.identificador = identificador;
        this.dataGeracao = Calendar.getInstance().getTime();
        this.qtdLinhas = N;
        this.qtdColunas = M;
        this.casasRestantes = N * M;

        int[][] casas = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                casas[i][k] = rnd.nextInt(60) + 1;
            }
        }

        //este método ordena antes pra funcionar
        casas = removerDuplicados(casas);

        transferir(casas);
    } //ok

    public int[][] getDados() throws Exception {
        int N = this.dados.getTamanho();
        int M = this.dados.get(0).getTamanho();
        int[][] valores = new int[N][M];
        for (int i = 0; i < N; i++) {
            Lista<NumeroCartela> linha = dados.get(i);
            for (int j = 0; j < M; j++) {
                valores[i][j] = linha.get(j).getNumero();
            }
        }
        return valores;
    } //ok

    public Integer getIdentificador() {
        return identificador;
    } //ok

    public Date getDataGeracao() {
        return dataGeracao;
    } //ok

    /**
     * Procura se o número está na cartela e o marca como sorteado.
     *
     * @param numero número que acabou de ser sorteado e que deve ser marcado na cartela
     * @throws Exception
     */
    @Override
    public void marcarNumeroSorteado(int numero) throws Exception {
        if (!estahEmUso) {
            return;
        }

        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                if ((dados.get(i).get(j)).getNumero() == numero && !(dados.get(i).get(j)).isSorteado()) {
                    (dados.get(i).get(j)).setSorteado(true);
                    casasRestantes--;
                }
            }
        }
    } //ok

    /**
     * Identifica se a cartela é vencedora conforme o parâmetro @verificarPorLinha
     *
     * @param verificarPorLinha caso verdadeiro (@true) o programa deverá verificar
     *                          por linha (horizontal). Caso seja falso (@false) deverá verificar se todos os números
     *                          foram sorteados.
     * @return
     * @throws Exception
     */
    @Override
    public boolean ehCartelaVencedora(boolean verificarPorLinha) throws Exception {
        int temp = 0;

        if (!estahEmUso) {
            return false;
        }

        if (verificarPorLinha) {
            for (int i = 0; i < qtdLinhas; i++) {
                for (int j = 0; j < qtdColunas; j++) {
                    if (dados.get(i).get(j).isSorteado()) {
                        temp++;
                    } else {
                        break;
                    }
                }

                if (temp == qtdColunas) {
                    System.out.println("\nBINGO! " + (++posicao) + "º colocado");
                    listarNumeros();
                    System.out.println("Fechou a " + (i + 1) + "ª linha");
                    System.out.println();
                    setEstahEmUso(false);
                    Thread.sleep(3000);
                    return true;
                } else {
                    temp = 0;
                }
            }
        } else {
            if (casasRestantes == 0) {
                System.out.println("\nBINGO! " + (++posicao) + "º colocado");
                listarNumeros();
                System.out.println("Fechou a cartela toda");
                System.out.println();
                setEstahEmUso(false);
                Thread.sleep(3000);
                return true;
            }
        }

        return false;
    } //ok

    /**
     * Retorna uma lista encadeada ordenada com os números da cartela.
     * Poderão existir números duplicados
     *
     * @return
     */
    @Override
    public ListaEncOrdenada<Integer> getNumerosNaoSorteados() {
        ListaEncOrdenada<Integer> lista = new ListaEncOrdenada();

        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                try {
                    if (!dados.get(i).get(j).isSorteado()) {
                        lista.incluir(dados.get(i).get(j).getNumero());
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }

        return lista;
    } //ok

    /**
     * Deverá observar se os números das duas cartelas são iguais por linha.
     *
     * @param iCartelaJogo
     * @return
     */
    @Override
    public int compareTo(ICartelaJogo iCartelaJogo) {

        try {
            for (int i = 0; i < qtdLinhas; i++) {
                for (int j = 0; j < qtdColunas; j++) {
                    if (dados.get(i).get(j).getNumero() != ((Cartela) iCartelaJogo).dados.get(i).get(j).getNumero()) {
                        return -1;
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return 0;
    } //ok

    @Override
    public void setEstahEmUso(boolean estahEmUso) {
        this.estahEmUso = estahEmUso;
    } //ok

    @Override
    public boolean estahEmUso() {
        return estahEmUso;
    } //ok

    public static ICartelaJogo gerarCartelaJogo(int N, int M) throws Exception {
        return new Cartela(N, M, ++idsGerados);
    } //ok

    //MÉTODOS ADICIONAIS
    public void transferir(int[][] arr) throws Exception {

        ListaEncOrdenada<NumeroCartela> novaColuna;

        for (int i = 0; i < qtdLinhas; i++) {
            novaColuna = new ListaEncOrdenada<>();

            for (int k = 0; k < qtdColunas; k++) {
                novaColuna.incluir(new NumeroCartela(arr[i][k]));
            }

            this.dados.incluir(novaColuna);
        }
    } //ok

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
    } //ok

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
    } //ok

    public void listarNumeros() throws Exception {
        int temp;

        System.out.println("Nº ID: " + identificador);
        System.out.println("Gerado em: " + dataGeracao);
        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {

                temp = (dados.get(i).get(j)).getNumero();

                if (temp < 10 && (dados.get(i).get(j)).isSorteado()) {
                    System.out.print("[0" + temp + "] ");
                } else if (temp >= 10 && (dados.get(i).get(j)).isSorteado()) {
                    System.out.print("[" + temp + "] ");
                } else if (temp < 10) {
                    System.out.print(" 0" + temp + "  ");
                } else {
                    System.out.print(" " + temp + "  ");
                }
            }
            System.out.println();
        } //ok
    }

    public static void eliminarUmId() {
        if (idsGerados > 0) {
            Cartela.idsGerados--;
        }
    }
}
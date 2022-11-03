package br.com.edu.bingo.product;

//Questao 4.1
public class Bingo {
    public Cartela[] conjuntoBingo = new Cartela[10];

    Premio[] premios = new Premio[3];
    static int contPremio = 0;

    //índice geral de bingos
    private static int pos = 0;

    public static int[] dezenas = new int[60];

    //Gera n cartelas e coloca na conjuntoBingo
    public void gerarBingo(int numDeCartelas, int m, int n) {
        Cartela[] arrCartelas = new Cartela[numDeCartelas];
        for (int i = 0; i < numDeCartelas; i++) {
            arrCartelas[i] = new Cartela(m, n);
        }

        armazenarBingo(arrCartelas);
    }

    //Cria 1/3 prêmios e coloca na premios
    public void criarPremio(double valor, String nome, String descricao) {
        Premio p1 = new Premio(valor, nome, descricao);
        adicionarPremio(p1);
    }

    //Questao 5
    //Armazena bingos criados no conjuntoBingo
    public void armazenarBingo(Cartela[] bingo) {

        if (bingo.length >= conjuntoBingo.length - pos) {
            Cartela[] novoConjunto = new Cartela[conjuntoBingo.length + bingo.length + 30];
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

    //Coloca 1/3 prêmios no premios
    public void adicionarPremio(Premio premio) {
        if (contPremio < premios.length) {
            premios[contPremio] = premio;
            contPremio++;
        } else {
            System.out.println("Já existem três prêmios.");
        }
    }

    public void verPremios() {
        for (Premio p1 : premios) {
            System.out.println("Nome: " + p1.getNome());
            System.out.println("Valor: " + p1.getValor());
            System.out.println("Descrição: " + p1.getDescricao() + "\n");
        }
    }

    public static void inserirDezenas() {
        for (int i = 1; i <= 60; i++) {
            dezenas[i - 1] = i;
        }
    }

    public Cartela[] getConjuntoBingo() {
        return conjuntoBingo;
    }

    public void setConjuntoBingo(Cartela[] conjuntoBingo) {
        this.conjuntoBingo = conjuntoBingo;
    }

    public Premio[] getPremios() {
        return premios;
    }

    public void setPremios(Premio[] premios) {
        this.premios = premios;
    }

    public static int getContPremio() {
        return contPremio;
    }

    public static void setContPremio(int contPremio) {
        Bingo.contPremio = contPremio;
    }

    public static int getPos() {
        return pos;
    }

    public static void setPos(int pos) {
        Bingo.pos = pos;
    }

    public static int[] getDezenas() {
        return dezenas;
    }

    public static void setDezenas(int[] dezenas) {
        Bingo.dezenas = dezenas;
    }

    //Zera todos os atributos de classe (static)
    public void zerarBingo() {
        conjuntoBingo = null;
        premios = null;
        System.out.println("Bingo excluído.");
        Cartela.setId_cartela(0);
        pos = 0;
    }
}
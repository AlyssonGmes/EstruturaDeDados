package br.com.edu.bingo.product;

import java.util.Random;
import java.util.Scanner;

public class Premio {
    static Random rnd = new Random();
    double valor;
    String nome;
    String descricao;
    static int numeroDoPremio = 0;
    static Cartela[] cartelasGanhadoras = new Cartela[3];
    static int[] numerosSorteados = new int[60];
    static int contadorGanhadores = 0;
    static int contadorDezenas = 0;

    public Premio(double valor, String nome, String descricao) {
        this.valor = valor;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static void sortearNumeros(Cartela[] conjuntoBingo, int linhas, int colunas) {
        Bingo.inserirDezenas();
        int numSorteado;

        do {
            numSorteado = rnd.nextInt(60);

            if (Bingo.dezenas[numSorteado] != -1) {
                numerosSorteados[numSorteado] = numSorteado + 1;
                Bingo.dezenas[numSorteado] = -1;
                for (Cartela jogador : conjuntoBingo) {
                    if (jogador != null) {
                        jogador.marcarNumeroSorteado(numSorteado + 1);
                    }
                }
                contadorDezenas++;
            } else {
                for (int i = numSorteado; i < 60; i++) {
                    if (Bingo.dezenas[i] != -1) {
                        numerosSorteados[i] = i + 1;
                        Bingo.dezenas[i] = -1;
                        for (Cartela jogador : conjuntoBingo) {
                            if (jogador != null) {
                                jogador.marcarNumeroSorteado(i + 1);
                            }
                        }
                        contadorDezenas++;
                        break;
                    }
                }
            }

            if (contadorDezenas % 5 == 0) {
                buscarGanhadores(conjuntoBingo, linhas, colunas, true);
            }
        }
        while (contadorGanhadores < 3);

    }

    //Insere cartela ganhadora na cartelasGanhadora
    public static void inserirGanhador(Cartela cartela) {
        if (contadorGanhadores < 3) {
            cartelasGanhadoras[contadorGanhadores] = cartela;
            contadorGanhadores++;
        }
    }

    public static void buscarGanhadores(Cartela[] conjuntoBingo, int linha, int colunas, boolean verificarPorLinha) {
        if (numeroDoPremio < 3) {
            for (Cartela jogador : conjuntoBingo) {
                if (jogador != null && jogador.vencedor == false) {
                    if (jogador.ehCartelaVencedora(verificarPorLinha)) {
                        jogador.numeroDoPremio = numeroDoPremio;
                        inserirGanhador(jogador);
                        conjuntoBingo[jogador.getIdentificador()].vencedor = true;
                        numeroDoPremio++;
                        return;
                    }
                }
            }
        }
    }

    public static void verGanhadores(Cartela[] cartelas) {
        for (Cartela ganhador : cartelasGanhadoras) {
            if (ganhador != null) {
                if (ganhador.numeroDoPremio == 0) {
                    System.out.println("Vencedor Prêmio Ouro");
                    Cartela.mostrarCatela(ganhador);
                } else if (ganhador.numeroDoPremio == 1) {
                    System.out.println("Vencedor Prêmio Prata");
                    Cartela.mostrarCatela(ganhador);
                } else {
                    System.out.println("Vencedor Prêmio Bronze");
                    Cartela.mostrarCatela(ganhador);
                }
            } else {
                System.out.println("Apenas " + contadorDezenas + " foram sorteadas. Faltam ganhadores.");

            }
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroDoPremio() {
        return numeroDoPremio;
    }

    public void setNumeroDoPremio(int numeroDoPremio) {
        this.numeroDoPremio = numeroDoPremio;
    }

    public Cartela[] getCartelasGanhadora() {
        return cartelasGanhadoras;
    }

    public void setCartelasGanhadora(Cartela[] cartelasGanhadora) {
        this.cartelasGanhadoras = cartelasGanhadora;
    }

    public static int[] getNumerosSorteados() {
        return numerosSorteados;
    }

    public static void setNumerosSorteados(int[] numerosSorteados) {
        Premio.numerosSorteados = numerosSorteados;
    }

    public static int getContadorGanhadores() {
        return contadorGanhadores;
    }

    public static void setContadorGanhadores(int contadorGanhadores) {
        Premio.contadorGanhadores = contadorGanhadores;
    }

    public static int getContadorDezenas() {
        return contadorDezenas;
    }

    public static void setContadorDezenas(int contadorDezenas) {
        Premio.contadorDezenas = contadorDezenas;
    }


    public static int[] ordenarArr(int[] vetor) {
        for (int i = 0, aux = 0; i < vetor.length - 1; ) {
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

}
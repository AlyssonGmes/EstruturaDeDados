package br.com.ed.bingo;

public class
Premio {
    static Premio premio = new Premio();

    private Premio() {

    }

    double valor = 0;
    String nome;
    String descricao;
    int numero;
    Object[] cartelasGanhadoras;
    int[] numerosSorteados;

    public void gerenciarPremio(double valor, String nome, String descricao, int numero, Object[] cartelasGanhadoras, int[] numerosSorteados) {
        premio.valor = valor;
        premio.nome = nome;
        premio.descricao = descricao;
        premio.numero = numero;
        premio.cartelasGanhadoras = cartelasGanhadoras;
        premio.numerosSorteados = numerosSorteados;
    }
}
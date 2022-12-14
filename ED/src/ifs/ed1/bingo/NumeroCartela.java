package ifs.ed1.bingo;

public class NumeroCartela implements Comparable<NumeroCartela> {
    int valor;
    private boolean sorteado = false;

    public int getNumero() {
        return valor;
    }

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = sorteado;
    }
    public NumeroCartela(int numero){
        this.valor = numero;
    }
    @Override
    public String toString(){
        return "[" +this.getNumero() + (this.isSorteado()? "*":"") +"]";
    }

    @Override
    public int compareTo(NumeroCartela numeroCartela) {
        return this.getNumero() - numeroCartela.getNumero();
    }
} //ok

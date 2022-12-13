package ifs.ED.lista;

public abstract class Lista<T extends Comparable> implements Comparable<Lista<T>> {

    public abstract void incluir(T elemento) throws Exception;

    public abstract void incluirInicio(T elemento) throws Exception;

    public abstract void incluir(T elemento, int posicao) throws Exception;

    public abstract T get(int posicao)  throws Exception;

    public abstract int getPosElemento(T elemento)  throws Exception;

    public abstract void remover(int posicao) throws Exception;

    public abstract void limpar();

    public abstract int getTamanho();

    public abstract boolean contem(T elemento) throws Exception;

    @Override
    public int compareTo(Lista<T> item) {
        if ( item instanceof Lista ) {
            Lista<T> lista = (Lista<T>) item;

            int comparacao1 = ((Integer) this.getTamanho()).compareTo(lista.getTamanho());
            if (comparacao1 != 0)
                return comparacao1;
            boolean ehIgual = true;
            int i = 0;
            while (ehIgual && i < this.getTamanho()) {
                try {
                    ehIgual = lista.get(i).equals(this.get(i));
                } catch (Exception e) {
                    return -1;
                }
            }
            return ehIgual ? 0 : -1;

        }
        return -1;
    }
}
package ifs.ed1.lista;

public class ListaSequencial<T extends Comparable<T>> extends Lista<T> {
    T[] lista;
    int qtdMax;
    int finalLista;
    Class<T> dataType;

    public ListaSequencial(Class<T> dataType) {
        super();
        qtdMax = 10;
        this.dataType = dataType;
        this.lista = (T[]) java.lang.reflect.Array.newInstance(dataType, qtdMax);
        finalLista = 0;
    }

    @Override
    public void limpar() {
        this.lista = (T[]) java.lang.reflect.Array.newInstance(dataType, qtdMax);
        finalLista = 0;
    } //ok

    @Override
    public T get(int posicao) throws Exception {
        if (posicao < 0 || posicao > finalLista) {
            throw new Exception("Posição solicitada não existe na lista");
        }

        if (posicao < finalLista && posicao >= 0) {
            return (T) lista[posicao];
        }

        return null;
    } //ok

    @Override
    public int getPosElemento(T elemento) throws Exception {
        int pos = 0;

        for (Object i : lista) {
            if (i != null) {
                if (i.equals(elemento)) {
                    return pos;
                }
            }
            pos++;
        }

        return -1;
    } //ok

    @Override
    public void incluir(T elemento) throws Exception {
        if (finalLista + 1 < lista.length) {
            lista[finalLista] = elemento;
            finalLista++;
        } else {
            throw new Exception("Lista cheia");
        }
    }//ok

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if (finalLista + 1 < lista.length) {
            for (int i = finalLista; i >= 0; i--) {
                lista[i + 1] = lista[i];
            }

            lista[0] = elemento;
            finalLista++;
        } else {
            throw new Exception("Lista cheia");
        }
    } //ok

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao < 0 || posicao > finalLista) {
            throw new Exception("Posição solicitada não existe na lista");
        }

        if (finalLista + 1 < lista.length) {
            for (int i = finalLista; i >= 0; i--) {
                lista[i + 1] = lista[i];
                if (i == posicao) {
                    lista[posicao] = elemento;
                    finalLista++;
                    i = -1;
                }
            }
        } else {
            throw new Exception("Lista cheia");
        }
    } //ok

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao < 0 || posicao > finalLista) {
            throw new Exception("Posição solicitada não existe na lista");
        }

        lista[posicao] = null;
        finalLista--;


        for (int i = posicao; i < lista.length - 1; i++) {
            lista[i] = lista[i + 1];
        }
    } //ok

    @Override
    public int getTamanho() {
        return finalLista;
    } //ok

    @Override
    public boolean contem(T elemento) throws Exception {
        for (Object i : lista) {
            if (i != null) {
                if (i.equals(elemento)) {
                    return true;
                }
            }
        }

        return false;
    } //ok

    public void listar() {
        for (int i = 0; i < finalLista; i++) {
            System.out.print(lista[i]+" ");
        }
        System.out.println();
    } //adicional - ok
}

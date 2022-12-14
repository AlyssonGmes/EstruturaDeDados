package ifs.ed1.lista;

public class Pilha<T extends Comparable<T>>   {

    No<T> noInicioLista;
    No<T> noFimLista;
    int contadorNos = 0;

    public void incluir(T elemento) throws Exception {
        incluirInicio(elemento);
    } //ok

    public void incluirInicio(T elemento) throws Exception {
        if (noInicioLista.getDado() == null) {
            noInicioLista.setDado(elemento);
            noInicioLista.setProximo(noFimLista);
            contadorNos++;
        } else {
            No<T> novoInicio = new No<>();
            novoInicio.setDado(elemento);
            novoInicio.setProximo(noInicioLista);
            noInicioLista = novoInicio;
            contadorNos++;
        }
    } //ok

    public T get(int posicao) throws Exception {
        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else {
            No<T> auxiliar = noInicioLista;

            for (int i = 0; i < posicao; i++) {
                auxiliar = auxiliar.getProximo();
            }
            return auxiliar.getDado();
        }
    } //ok

    public int getPosElemento(T elemento) throws Exception {
        No<T> auxiliar = noInicioLista;
        for (int i = 0; i < contadorNos; i++) {
            if (auxiliar.getDado().equals(elemento)) {
                return i;
            }
            auxiliar = auxiliar.getProximo();
        }

        return -1;
    } //ok

    public void shift() throws Exception {
        if (contadorNos == 0) {
            throw new Exception("A lista está vazia");
        } else if (contadorNos == 1) {
            limpar();
        } else {
            noInicioLista = noInicioLista.getProximo();
            contadorNos--;
        }
    } //ok

    public void limpar() {
        noInicioLista = new No<>();
        noFimLista = new No<>();
        contadorNos = 0;
    }

    public int getTamanho() {
        return contadorNos;
    } //ok

    public boolean contem(T elemento) throws Exception {
        No<T> auxiliar = noInicioLista;

        while (auxiliar.getProximo() != null) {
            if (auxiliar.dado.equals(elemento)) {
                return true;
            }
            auxiliar = auxiliar.getProximo();
        }

        return false;
    }

    public void listar() {
        No<T> auxiliar = noInicioLista;
        while (auxiliar.getProximo() != null && auxiliar.getProximo().dado != null) {
            System.out.print(auxiliar.dado + " ");
            auxiliar = auxiliar.getProximo();
        }
        if (noInicioLista.dado == null) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println(auxiliar.dado);
        } //ok
    }
}

package ifs.ed1.lista;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {
    No<T> noInicioLista;
    No<T> noFimLista;
    int contadorNos = 0;

    public ListaEnc() {
        noInicioLista = new No<>();
        noFimLista = new No<>();
    } //ok

    @Override
    public void incluir(T elemento) throws Exception {
        if (noInicioLista.getDado() == null) {
            noInicioLista.setDado(elemento);
            noInicioLista.setProximo(noFimLista);
            contadorNos++;
        } else {
            No<T> novoNo = new No<>();
            noFimLista.setDado(elemento);
            noFimLista.setProximo(novoNo);
            noFimLista = novoNo;
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

    @Override
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

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else if (posicao == contadorNos) {
            incluir(elemento);
        } else if (posicao == 0) {
            incluirInicio(elemento);
        } else {
            No<T> auxiliar = noInicioLista;
            for (int i = 0; i < posicao - 1; i++) {
                auxiliar = auxiliar.getProximo();
            }
            No<T> novoNo = new No<>();
            novoNo.setDado(elemento);
            novoNo.setProximo(auxiliar.getProximo());
            auxiliar.setProximo(novoNo);

            if (posicao == contadorNos) {
                noFimLista = novoNo;
            }

            contadorNos++;
        }
    } //ok

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else if (contadorNos == 1) {
            limpar();
        } else {
            No<T> auxiliar = noInicioLista;

            for (int i = 0; i < posicao - 1; i++) {
                auxiliar = auxiliar.getProximo();
            }

            if (posicao == 0) {
                //se for o primeiro da lista
                noInicioLista = noInicioLista.getProximo();
            } else if (posicao + 1 <= contadorNos - 1) {
                //se for qualquer outro entre o início e o fim
                auxiliar.setProximo(auxiliar.prox.prox);
            } else {
                //se for o fim da lista
                auxiliar.setProximo(noFimLista);
            }

            contadorNos--;
        }
    } //ok

    @Override
    public int getTamanho() {
        return contadorNos;
    } //ok

    public void limpar() {
        noInicioLista = new No<>();
        noFimLista = new No<>();
        contadorNos = 0;
    } //ok

    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> auxiliar = noInicioLista;

        while (auxiliar.getProximo() != null) {
            if (auxiliar.dado.equals(elemento)) {
                return true;
            }
            auxiliar = auxiliar.getProximo();
        }

        return false;
    } //ok

    public void listar() {
        No<T> auxiliar = noInicioLista;
        while (auxiliar.getProximo() != null && auxiliar.getProximo().dado != null) {
            System.out.print(auxiliar.dado +" ");
            auxiliar = auxiliar.getProximo();
        }
        if (noInicioLista.dado == null) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println(auxiliar.dado);
        }
    } //ok

}

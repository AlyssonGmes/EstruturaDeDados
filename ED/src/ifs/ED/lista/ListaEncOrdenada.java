package ifs.ED.lista;

public class
ListaEncOrdenada<T extends Comparable<T>> extends ListaEnc<T> {
    public ListaEncOrdenada() {
        super();
    }

    @Override
    public void incluir(T elemento) throws Exception {
        if (noInicioLista.getDado() == null) {
            noInicioLista.setDado(elemento);
            noInicioLista.setProximo(noFimLista);
            contadorNos++;
        } else {
            int valor;
            No<T> aux = noInicioLista;
            No<T> novoNo = new No<>();

            do {
                valor = aux.getDado().compareTo(elemento);
                if (valor < 0 && aux.getProximo() != noFimLista) {
                    aux = aux.getProximo();
                } else {
                    break;
                }
            } while (true);

            valor = aux.getDado().compareTo(elemento);
            if (valor == 1) {
                novoNo.setDado(aux.getDado());
                novoNo.setProximo(aux.getProximo());
                aux.setProximo(novoNo);
                aux.setDado(elemento);
            } else {
                novoNo.setProximo(aux.getProximo());
                aux.setProximo(novoNo);
                novoNo.setDado(elemento);
            }
            contadorNos++;
        }
    } //ok

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if (noInicioLista.getDado() == null) {
            noInicioLista.setDado(elemento);
            noInicioLista.setProximo(noFimLista);
            contadorNos++;
        } else {
            int valor = elemento.compareTo(noInicioLista.getDado());
            if (valor <= 0) {
                No<T> novoNo = new No<>();
                novoNo.setDado(elemento);
                novoNo.setProximo(noInicioLista);
                noInicioLista = novoNo;
                contadorNos++;
            } else {
                throw new Exception("Elemento é maior do que o início");
            }
        }
    } //ok

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        No<T> aux = noInicioLista;
        No<T> novoNo = new No<>();
        int valor;

        if (posicao > contadorNos - 1 || posicao < 0) {
            throw new Exception("Posição solicitada não existe na lista");
        } else if (posicao == 0) {
            incluirInicio(elemento);
        } else {
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.getProximo();
            }

            valor = elemento.compareTo(aux.getDado());

            if (valor >= 0) {
                valor = elemento.compareTo(aux.getProximo().getDado());
                if (valor <= 0) {
                    novoNo.setProximo(aux.getProximo());
                    aux.setProximo(novoNo);
                    novoNo.setDado(elemento);
                } else {
                    throw new Exception("Inserção inválida em lista ordenada");
                }
            } else {
                throw new Exception("Inserção inválida em lista ordenada");
            }
            contadorNos++;
        }
    } //ok

    @Override
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

    @Override
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
    public void limpar() {
        noInicioLista = new No<>();
        noFimLista = new No<>();
        contadorNos = 0;
    } //ok

    @Override
    public int getTamanho() {
        return contadorNos;
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
            System.out.print(auxiliar.dado+" ");
            auxiliar = auxiliar.getProximo();
        }
        if (noInicioLista.dado == null) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println(auxiliar.dado);
        }
    } //ok

}

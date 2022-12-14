package ifs.ed1.lista;

public class No<T> {
    public T dado;
    public No prox;

    public void setDado(T dado) {
        this.dado = dado;
    }

    public void setProximo(No<T> prox) {
        this.prox = prox;
    }

    public No<T> getProximo() {
        return prox;
    }

    public T getDado() {
        return dado;
    }
}

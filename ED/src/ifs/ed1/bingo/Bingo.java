package ifs.ed1.bingo;
import ifs.ed1.lista.*;
import java.util.Random;

public class Bingo {
    final private Lista<Cartela> cartelas;
    private ListaEncOrdenada<Integer> globo;

    private ListaEnc<Integer> dezenasSorteadas = new ListaEnc<>();

    Random rnd = new Random();

    /**
     * Cria a classe gerenciadora do bingo, com as cartelas.
     *
     * @param qtd
     * @param qtdLinhas
     * @param qtdColunas
     * @throws Exception
     */
    public Bingo(int qtd, int qtdLinhas, int qtdColunas) throws Exception {
        int tentativas = 5;
        int qtdCartelas;
        inserirDezenasNoGlobo();
        cartelas = new ListaEnc();
        Cartela temp;

        for (int i = 0; i < qtd; i++) {
            temp = (Cartela) Cartela.gerarCartelaJogo(qtdLinhas, qtdColunas);

            if (cartelas.getTamanho() == 0) {
                cartelas.incluir(temp);
            } else {
                qtdCartelas = cartelas.getTamanho();
                for (int j = 0; j < qtdCartelas; j++) {
                    if (temp.compareTo(cartelas.get(j)) == 0) {
                        if (tentativas == 0) {
                            System.out.println("\nMuitas cartelas estão se repetindo... então apenas "+qtdCartelas+" foram criadas.\n");
                            Thread.sleep(3000);
                            i = qtd;
                            break;
                        }
                        Cartela.eliminarUmId();
                        --tentativas;
                        --i;
                        break;
                    }

                    if (j == qtdCartelas - 1) {
                        cartelas.incluir(temp);
                    }
                }

            }
        }
        //estado atual
    } //ok

    public Lista<Cartela> getCartelas(SituacaoCartela situacaoCartela) throws Exception {
        Lista<Cartela> lista = new ListaEnc();

        if (situacaoCartela == SituacaoCartela.Valida) {
            for (int i = 0; i < cartelas.getTamanho(); i++) {
                if (cartelas.get(i).estahEmUso) {
                    lista.incluir(cartelas.get(i));
                }
            }
            return lista;
        } else if (situacaoCartela == SituacaoCartela.Cancelada) {
            for (int i = 0; i < cartelas.getTamanho(); i++) {
                if (!cartelas.get(i).estahEmUso) {
                    lista.incluir(cartelas.get(i));
                }
            }
            return lista;
        }

        return cartelas;
    } //ok

    public Lista<Cartela> getCartelasVencedoras(boolean verificarPorLinha) throws Exception {
        Lista<Cartela> cartelas = new ListaEnc();

        for (int i = 0; i < cartelas.getTamanho(); i++) {
            if (this.cartelas.get(i).ehCartelaVencedora(verificarPorLinha)) {
                cartelas.incluir(this.cartelas.get(i));
            }
        }

        return cartelas;
    } //ok

    /**
     * Realiza o sorteio de um número e marca na cartela o número sorteado;
     *
     * @return
     */
    public int SortearNumero() throws Exception {
        int qtdLinhas;
        int qtdColunas;
        int temp;

        int num = rnd.nextInt(globo.getTamanho());

        dezenasSorteadas.incluir(globo.get(num));
        temp = globo.get(num);
        globo.remover(num);

        qtdColunas = cartelas.get(0).qtdColunas;
        qtdLinhas = cartelas.get(0).qtdLinhas;

        if (temp < 10) {
            System.out.println("Bola sorteada: Nº 0" + temp + "!");
        } else {
            System.out.println("Bola sorteada: Nº " + temp + "!");
        }

        checarVencedores(qtdLinhas, qtdColunas, temp);

        return temp;
    } //ok

    /**
     * Limpa o número sorteado da cartela em questão
     *
     * @param cartela
     * @throws Exception
     */
    public void LimparNumerosSorteados(Cartela cartela) throws Exception {
        int pos = cartelas.getPosElemento(cartela);
        int qtdLinhas = cartelas.get(pos).qtdLinhas;
        int qtdColunas = cartelas.get(pos).qtdColunas;

        cartelas.get(pos).setEstahEmUso(true);
        cartelas.get(pos).casasRestantes = 0;
        for (int i = 0; i < qtdLinhas * qtdColunas; i++) {
            for (int j = 0; j < qtdLinhas; j++) {
                for (int k = 0; k < qtdColunas; k++) {
                    cartelas.get(pos).dados.get(j).get(k).setSorteado(false);
                }
            }
        }
    } //ok

    /**
     * Limpa todos os números marcados em todas as cartelas para permitir realizar o bingo com um novo
     * prêmio;
     *
     * @throws Exception
     */

    public void LimparNumerosSorteados() throws Exception {

    } //ok

    public void RemoverCartelaDoBingo(Cartela cartela) throws Exception {
        cartelas.remover(cartelas.getPosElemento(cartela));
    } //ok

    public int obterQuantidadeDeCartelas(SituacaoCartela situacaoCartela) throws Exception {
        int qtd = 0;

        if (situacaoCartela == SituacaoCartela.Valida) {
            for (int i = 0; i < cartelas.getTamanho(); i++) {
                if (cartelas.get(i).estahEmUso) {
                    qtd++;
                }
            }
            return qtd;
        } else if (situacaoCartela == SituacaoCartela.Cancelada) {
            for (int i = 0; i < cartelas.getTamanho(); i++) {
                if (!cartelas.get(i).estahEmUso) {
                    qtd++;
                }
            }
            return qtd;
        }

        return cartelas.getTamanho();
    } //ok

    public Lista<Cartela> getCartelas() {
        return cartelas;
    } //ok

    public void listarNaoSorteados() {
        globo.listar();
    } //ok

    private void inserirDezenasNoGlobo() throws Exception {
        globo = new ListaEncOrdenada<>();
        for (int i = 1; i <= 60; i++) {
            this.globo.incluir(i);
        }
    } //ok

    public void listarCartelas() throws Exception {
        for (int i = 0; i < cartelas.getTamanho(); i++) {
            cartelas.get(i).listarNumeros();
            System.out.println();
        }
    }

    public int getQtdDezenasRestantes() {
        return globo.getTamanho();
    }

    public void checarVencedores(int qtdLinhas, int qtdColunas, int temp) throws Exception {
        for (int i = 0; i < cartelas.getTamanho(); i++) {
            for (int j = 0; j < qtdLinhas; j++) {
                for (int k = 0; k < qtdColunas; k++) {
                    if (cartelas.get(i).dados.get(j).get(k).getNumero() == temp) {
                        cartelas.get(i).dados.get(j).get(k).setSorteado(true);
                        cartelas.get(i).ehCartelaVencedora(true);
                        cartelas.get(i).ehCartelaVencedora(false);
                    }
                }
            }
        }
    }

}

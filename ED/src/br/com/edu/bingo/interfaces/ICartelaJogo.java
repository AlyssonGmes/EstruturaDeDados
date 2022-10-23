package br.com.edu.bingo.interfaces;

public interface ICartelaJogo {
    static ICartelaJogo gerarCartelaJogo(int N, int M){
        return null;
    }

    /**
     * Marca o número como sorteado caso ele exista na matriz NxM
     * @param N número que deve ser encontrado na matriz NxM
     */

    void marcarNumeroSorteado(int N);

    /**
     * Identifica se todos os números em uma  determinada linha ou coluna foram
     sorteados.
     * @param verificarPorLinha caso verdadeiro (@true) o programa deverá verificar
    por
     * linha (horizontal). Caso seja falso (@false) deverá verificar
     * por coluna (vertical)
     *
     * @return Verdadeiro se todos os números de uma linha ou coluna foram sorteados.
     */
    boolean ehCartelaVencedora(boolean verificarPorLinha);
}

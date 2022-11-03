package br.com.edu.bingo;

import br.com.edu.bingo.product.Bingo;
import br.com.edu.bingo.product.Cartela;
import br.com.edu.bingo.product.Premio;

public class ModuloGerenciador {
    Bingo b1;

    public void menu(int opcao) {
        switch (opcao) {
            case 1:
                b1 = criarPartida();
                break;
            case 2:
                Cartela.mostrarCartelas(b1.conjuntoBingo);
                break;
            case 3:
                Premio.sortearNumeros(b1.conjuntoBingo, 5, 5);
                break;
            case 4:
                Premio.verGanhadores(b1.conjuntoBingo);
                break;
            case 5:
                for (int i : Premio.getNumerosSorteados()) {
                    if (i != 0) {
                        System.out.print(i + " - ");
                    }
                }
                System.out.println();
                break;
            case 6:
                System.out.println("Bingo encerrado.");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida.");
                menu(opcao);
        }
    }

    public Bingo criarPartida() {
        Bingo b1 = new Bingo();
        Bingo.setContPremio(0);
        Bingo.setPos(0);
        Bingo.inserirDezenas();
        Bingo.setPos(0);
        Cartela.setId_cartela(0);
        b1.conjuntoBingo = new Cartela[10];

        b1.criarPremio(500, "Primeiro lugar", "Primeiro jogador a preencher a cartela.");
        b1.criarPremio(250, "Segundo lugar", "Segundo jogador a preencher a cartela.");
        b1.criarPremio(100, "Terceiro lugar", "Terceiro jogador a preencher a cartela.");

        b1.gerarBingo(50, 5, 5);
        return b1;
    }
}


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bingo b1 = new Bingo();
        Bingo.armazenarBingo(b1.gerarBingo(2, 5,5));
        Bingo.armazenarBingo(b1.gerarBingo(2, 4, 4));
        Bingo.armazenarBingo(b1.gerarBingo(2, 2,2));
        Bingo.armazenarBingo(b1.gerarBingo(2, 1,1));
        Bingo.armazenarBingo(b1.gerarBingo(2, 2,2));
        Bingo.armazenarBingo(b1.gerarBingo(2, 5,5));
     //  Cartela.mostrarCartelas(Bingo.getConjuntoBingo());

    }

    public static double[] criarVetor(int tamanho){
        double [] vetor = new double[tamanho];

        for(int i = 0; i < tamanho; i++){

            vetor[i] = ((double)(new Random().nextInt(100)))/10;
        }
        return vetor;
    }
}

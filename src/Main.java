import br.com.cod3r.cm.model.Tabuleiro;

public class Main {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);

        tabuleiro.abrir(2,2);
        tabuleiro.alternarMarcacao(3,3);

        System.out.println(tabuleiro);
    }
}
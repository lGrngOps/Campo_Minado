import br.com.cod3r.cm.model.Tabuleiro;
import br.com.cod3r.cm.view.TabuleiroConsole;

public class Main {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);

        new TabuleiroConsole(tabuleiro);
    }
}4
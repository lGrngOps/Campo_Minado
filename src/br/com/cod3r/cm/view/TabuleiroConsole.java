package br.com.cod3r.cm.view;

import br.com.cod3r.cm.exception.ExplosaoException;
import br.com.cod3r.cm.exception.SairException;
import br.com.cod3r.cm.model.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabuleiroConsole {

    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;

        executarJogo();
    }
    private void executarJogo(){
        try{
            boolean contiuar = true;
            while (contiuar){
                loopJogo();
                System.out.println(" Outra partida ? (S/n ");
                String resposta = entrada.nextLine();
                if ("n".equalsIgnoreCase(resposta)){
                    contiuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (SairException e){
            System.out.println(" Finish !!!");
        } finally {
          entrada.close();
        }
    }
    private void loopJogo() {
        try{
            while(!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);
                String digitado = capturarValorDigitado("Digite (x,y) : ");

                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                        .map(e -> Integer.parseInt(e.trim()))
                        .iterator();

                digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar");

                if ("1".equals(digitado)){
                    tabuleiro.abrir(xy.next(), xy.next());
                }else  if ("2".equals(digitado)){
                    tabuleiro.alternarMarcacao(xy.next(),xy.next());
                }
            }
            System.out.println(" You Win !!!");
        } catch (ExplosaoException e){
            System.out.println("You Lose !!!");
        }
    }
    private String capturarValorDigitado(String texto){
        System.out.println(texto);
        String digitado = entrada.nextLine();

        if("sair".equalsIgnoreCase(digitado)){
            throw new SairException();
        }
        return digitado;
    }
}

package systemTruco;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.util.*;

public class Jogo {

    private ArrayList<Carta> baralho = new ArrayList<>();
    private Random randomico = new Random();
    private Carta manilha;
    private Carta vira;
    private ArrayList<Jogador> jogador = new ArrayList<>();

    public Jogo(String playerNome, int numeroJogadores) {
        this.criaBaralho();
        this.embaralhaCartas();
        this.criaJogadores(playerNome, numeroJogadores);
    }

    public void criaBaralho() {
        for (int n = 0; n < 4; n++) {
            for (int f = 0; f < 10; f++) {
                Carta ca = new Carta(f, n);
                this.baralho.add(ca);
            }
        }
    }

    public void criaNovoBaralho() {
        baralho.clear();
        criaBaralho();
    }

    public void embaralhaCartas() {

        Collections.shuffle(baralho, this.randomico);
    }

    private void criaJogadores(String playerNome, int numeroJogadores) {

        int timeAdversarioIA;

        Jogador jogador1 = new Jogador(playerNome);

        jogador.add(jogador1);

        do {
            timeAdversarioIA = randomico.nextInt(6) + 1;
        } while (timeAdversarioIA == jogador.get(0).getTime().getNome().codigo());

        /*Jogador jogadorIA = new Jogador(timeIA);
        jogador.add(jogadorIA);
        Jogador jogadorIA2 = new Jogador(jogador.get(0).getTime());
        jogador.add(jogadorIA2);
        Jogador jogadorIA3 = new Jogador(timeIA);
        jogador.add(jogadorIA3);*/
        Time timeIA = new Time(timeAdversarioIA);
        for (int i = 1; i < numeroJogadores; i++) {
            if (i < 3) {
                Jogador jogadorIA = new Jogador(timeIA);
                jogador.add(jogadorIA);
            } else {
                Jogador jogadorIA = new Jogador(jogador.get(0).getTime());
                jogador.add(jogadorIA);
            }
        }
        ativarIA();
    }

    public void ativarIA() {

        jogador.get(0).ativarIA();
        for (Jogador aJogador : jogador) {
            if (aJogador.getIA() == null) {
                aJogador.ativarIA(jogador.get(0).getIA());
            }
        }
    }

    public ArrayList<Jogador> getJogador() {
        return jogador;
    }

    public ArrayList<Carta> getBaralho() {
        return baralho;
    }

    public Carta getVira() {
        return vira;
    }

    public Carta getManilha() {
        return manilha;
    }

}

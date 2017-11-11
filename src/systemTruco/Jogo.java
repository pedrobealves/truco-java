package systemTruco;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Jogo {

    private ArrayList<Carta> baralho = new ArrayList<>();
    private Random randomico = new Random();
    private Carta manilha;
    private Carta vira;
    private ArrayList<Jogador> jogador = new ArrayList<>();

    public Jogo() {
        this.criaBaralho();
        this.embaralhaCartas();
        this.criaJogadores(4);
    }

    public void criaBaralho() {

        for (int n = 0; n < 4; n++) {
            for (int f = 0; f < 10; f++) {
                Carta ca = new Carta(f, n);
                this.baralho.add(ca);
            }
        }
    }

    public void embaralhaCartas() {

        Collections.shuffle(baralho, this.randomico);
    }

    private void criaJogadores(int numeroJogadores) {

        System.out.println("Digite seu nome: ");
        int timeAdversarioIA;
        Scanner ler = new Scanner(System.in);
        String nomeJogador = ler.next();

        Jogador jogador1 = new Jogador(nomeJogador);

        jogador.add(jogador1);

        do {
            timeAdversarioIA = randomico.nextInt(7) + 1;
        } while (timeAdversarioIA == jogador.get(0).getTime().getNome().codigo());

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

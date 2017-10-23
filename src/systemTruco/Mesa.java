package systemTruco;

import java.util.ArrayList;
import java.util.Scanner;

public class Mesa {

    private ArrayList<Carta> baralho = new ArrayList<Carta>();
    private ArrayList<Jogador> jogador = new ArrayList<Jogador>();
    private Carta manilha;
    private Carta vira;
    private int rodada = 0;
    private int valorTruco = 1;
    private boolean acabar = false;
    private boolean[] empate = new boolean[3];

    public Mesa(ArrayList<Carta> baralho, ArrayList<Jogador> jogador) {
        this.baralho = baralho;
        this.jogador = jogador;
        rodada = 0;
        manilha();
        distribuirCartas();
    }

    public void iniciaJogo() {
        while (rodada < 3) {
            System.out.println("\nVira - " + getVira().getValor() + " " + getVira().getNaipe());
            jogador.get(0).verCartasJogador();
            Scanner ler = new Scanner(System.in);
            int suaJogada = ler.nextInt();
            jogador.get(0).jogada(suaJogada);
            jogador.get(1).jogada(jogador.get(1).gerarJogada());
            jogador.get(1).visualCartaJogada();
            jogador.get(3).jogada(jogador.get(3).gerarJogada());
            jogador.get(3).visualCartaJogada();
            jogador.get(2).jogada(jogador.get(2).gerarJogada());
            jogador.get(2).visualCartaJogada();
            verificarGanhador();
            vencedorRodada();
            vencedorJogo();
            proximaRodada();
        }
    }

    public void manilha() {
        vira = baralho.get(2);
        for (Carta c : baralho) {
            if (c.getId() == (vira.getId() + 1)) {
                manilha = c;
            }
        }
        if (manilha == null)
            manilha = baralho.get(0);
        baralho.remove(0);
    }


    private void distribuirCartas() {
        for (int i = 0; i < jogador.size(); i++)
            jogador.get(i).distribuiCartas(baralho);
    }

    public void verificarGanhador() {
        Jogador vencedor = null;
        int valorMaior = -1;
        for (Jogador aJogador : jogador)
            if (manilha.getValor() == aJogador.cartaJogada().getValor()) {
                if (aJogador.cartaJogada().getId() > valorMaior) {
                    valorMaior = aJogador.cartaJogada().getId();
                    vencedor = aJogador;
                }
            }
        if (vencedor == null) {
            for (int j = 0; j < jogador.size(); j++) {
                for (int i = 0; i < jogador.size(); i++) {
                    if ((jogador.get(j).cartaJogada().getId() % 10 > jogador.get(i).cartaJogada().getId() % 10) && (jogador.get(j).getTime() != jogador.get(i).getTime())) {
                        vencedor = jogador.get(j);
                    }
                }
            }
        }

        vencedor.getTime().setPlacarRodada();
    }

    public void vencedorRodada() {
        if (rodada == 2) {
            if (jogador.get(0).getTime().getPlacarRodada() > jogador.get(1).getTime().getPlacarRodada()) {
                System.out.println("\n VENCEDOR RODADA - " + jogador.get(0).getTime().getNome());
            } else {
                System.out.println("\n VENCEDOR RODADA - " + jogador.get(1).getTime().getNome());
            }
        }
        jogador.get(1).getTime().zerarRodada();
        jogador.get(2).getTime().zerarRodada();

    }

    public void vencedorJogo() {
        if (jogador.get(0).getTime().getPlacarGeral() == 12) {
            System.out.println("\n VENCEDOR JOGO - " + jogador.get(0).getTime().getNome());
        }
        if (jogador.get(1).getTime().getPlacarGeral() == 12) {
            System.out.println("\n VENCEDOR JOGO - " + jogador.get(0).getTime().getNome());
        }


    }

    public void proximaRodada() {
        this.rodada++;
    }

    public boolean isAcabar() {
        return acabar;
    }

    public void setAcabar(boolean acabar) {
        this.acabar = acabar;
    }

    public Carta getVira() {
        return vira;
    }
}

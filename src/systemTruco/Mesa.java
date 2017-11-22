package systemTruco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Mesa {

    private ArrayList<Carta> baralho = new ArrayList<>();
    private ArrayList<Jogador> jogador = new ArrayList<>();
    private Carta manilha;
    private Carta vira;
    Jogador vencedor = null;
    private int rodada = 0;
    private int valorTruco = 1;
    private boolean acabar = false;
    private boolean[] empate = new boolean[3];

    public Mesa(ArrayList<Carta> baralho, ArrayList<Jogador> jogador) {
        this.baralho = baralho;
        this.jogador = jogador;
        rodada = 0;
        vencedor = jogador.get(0);
        manilha();
        distribuirCartas();
    }

    public void iniciaJogo() {
       /* while (rodada < 3) {
            System.out.println("\nVira - " + getVira().getValor() + " " + getVira().getNaipe());
            ordemJogadas();
            verificarGanhador();
            vencedorMao();
            vencedorRodada();
            vencedorJogo();
            limparMesa();
            proximaRodada();
        }*/
    }

    public void limparMesa() {
        for (Jogador aJogador : jogador)
            aJogador.limparCartaJogada();
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
        for (Jogador aJogador : jogador) aJogador.distribuiCartas(baralho);
    }

    public void verificarGanhador() {

        vencedor = null;
        int valorMaior = -1;
        for (Jogador aJogador : jogador) {
            if (aJogador.cartaJogada() != null) {
                if (Objects.equals(manilha.getValor(), aJogador.cartaJogada().getValor())) {
                    if (aJogador.cartaJogada().getId() > valorMaior) {
                        valorMaior = aJogador.cartaJogada().getId();
                        vencedor = aJogador;
                    }
                }
            }
        }
        if (vencedor == null) {
            vencedor = jogador.get(0);
            for (Jogador bJogador : jogador) {
                if (bJogador.cartaJogada() != null) {
                    if ((bJogador.cartaJogada().getId() % 10 > vencedor.cartaJogada().getId() % 10) && (bJogador.getTime() != vencedor.getTime())) {
                        vencedor = bJogador;
                    }
                }
            }
        }
    }

    public void vencedorMao() {
        System.out.println("\nMaior carta - " + vencedor.cartaJogada().getValor() + " " + vencedor.cartaJogada().getNaipe());
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

    public ArrayList<Jogador> getJogador() {
        return jogador;
    }

    public Carta getManilha() {
        return manilha;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public int getRodada() {
        return rodada;
    }
}

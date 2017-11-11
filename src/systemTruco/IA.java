package systemTruco;

import java.util.ArrayList;

public class IA {

    private ArrayList<Jogador> jogador = new ArrayList<>();
    private Jogador vencedorTemp;

    public void ativarIA(Jogador jogador) {
        this.jogador.add(jogador);
    }

    public int gerarJogada(Jogador vezJogador) {

       /* if (vencedorTemp.getTime() == vezJogador.getTime()) {
            return menorCarta(vezJogador);
        }*/

        for (Jogador aJogador : jogador) {
            if ((aJogador.cartaJogada() != null) && (aJogador.getTime() != vezJogador.getTime())) {
                for (int i = 0; i < vezJogador.getCartasJogador().size(); i++) {
                    if (vezJogador.getCartasJogador().get(i).getId() % 10 > aJogador.cartaJogada().getId() % 10) {
                        return i + 1;
                    }
                }
            }
        }

        return menorCarta(vezJogador);
    }

    public int menorCarta(Jogador vezJogador) {
        int menor = vezJogador.getCartasJogador().get(0).getId() % 10;
        for (int i = 0; i < vezJogador.getCartasJogador().size(); i++) {
            if (vezJogador.getCartasJogador().get(0).getId() % 10 < menor) {
                return i + 1;
            }
        }
        return 1;
    }

    public void setVencedorTemp(Jogador vencedorTemp) {
        this.vencedorTemp = vencedorTemp;
    }

}
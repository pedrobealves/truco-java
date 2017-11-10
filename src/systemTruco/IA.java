package systemTruco;

import java.util.ArrayList;

public class IA {

    private ArrayList<Jogador> jogador = new ArrayList<>();

    public void ativarIA(Jogador jogador) {
        this.jogador.add(jogador);
    }

    public int gerarJogada(Jogador vezJogador) {
        for (Jogador aJogador : jogador) {
            if ((aJogador.cartaJogada() != null) && (aJogador.getTime() != vezJogador.getTime())) {
                if (vezJogador.cartaJogada().getId() % 10 > aJogador.cartaJogada().getId() % 10) {
                    return vezJogador.cartaJogada().getValor().indexOf(vezJogador.cartaJogada().getValor());
                }
            }
        }
        return 0;
    }

}

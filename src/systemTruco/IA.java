package systemTruco;

import java.util.ArrayList;
import java.util.Objects;

public class IA {

    private ArrayList<Jogador> jogador = new ArrayList<>();
    private Jogador vencedorTemp;
    private Carta manilha;
    Jogador vezJogador;

    public void ativarIA(Jogador jogador) {
        this.jogador.add(jogador);
    }


    public int gerarJogada(Jogador vezJogador) {

        //Vezjogador recebe jogador
        this.vezJogador = vezJogador;

        //Verifica se não exite ganhador no momento
        if (vencedorTemp != null) {
            //Se ganhador for da mesma equipe
            if (vencedorTemp.getTime() == vezJogador.getTime())
                return menorCarta();
        }

        if (Objects.nonNull(isManilha()))
            return manilha();

        return maiorCarta();
    }

    public int menorCarta() {
        int menor = vezJogador.getCartasJogador().get(0).getId() % 10;
        for (int i = 0; i < vezJogador.getCartasJogador().size(); i++) {
            if (vezJogador.getCartasJogador().get(0).getId() % 10 < menor) {
                return i + 1;
            }
        }
        return 1;
    }

    public int maiorCarta() {
        for (Jogador aJogador : jogador) {
            if ((Objects.nonNull(aJogador.cartaJogada())) && (aJogador.getTime() != vezJogador.getTime())) {
                for (int i = 0; i < vezJogador.getCartasJogador().size(); i++) {
                    if (vezJogador.getCartasJogador().get(i).getId() % 10 > aJogador.cartaJogada().getId() % 10) {
                        return i + 1;
                    }
                }
            }
        }
        return menorCarta();
    }

    public Jogador isManilha() {
        for (Jogador aJogador : jogador) {
            if (Objects.nonNull(aJogador.cartaJogada()) && Objects.equals(aJogador.cartaJogada().getValor(), manilha.getValor()))
                return aJogador;
        }
        if (manilhaJogador() > 0)
            return vezJogador;
        return null;
    }

    public int manilha() {

        if (Objects.equals(isManilha(), vezJogador))
            return manilhaJogador();
        else if (Objects.isNull(isManilha()))
            return -1;
        return menorCarta();
    }

    public int manilhaJogador() {
        for (int i = 0; i < vezJogador.getCartasJogador().size(); i++) {
            if (Objects.equals(vezJogador.getCartasJogador().get(i), manilha)) {
                return i + 1;
            }
        }
        return -1;
    }

    public void setVencedorTemp(Jogador vencedorTemp) {
        this.vencedorTemp = vencedorTemp;
    }

    public void truco(Jogador jogadorTrucado) {

    }

    public Jogador getVencedorTemp() {
        return vencedorTemp;
    }

    public void setManilha(Carta manilha) {
        this.manilha = manilha;
    }
}
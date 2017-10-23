package systemTruco;

public class Principal {

    public Principal() {
        Jogo jogo = new Jogo();
        boolean acabar = false;
        while (!acabar) {
            Mesa mesa = new Mesa(jogo.getBaralho(), jogo.getJogador());
            mesa.iniciaJogo();
            jogo.criaBaralho();
            jogo.embaralhaCartas();
            acabar = mesa.isAcabar();
        }
    }


    public static void main(String[] args) {
        new Principal();
    }


}

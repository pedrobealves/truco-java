package systemTruco;

import java.util.ArrayList;

public class IniciaJogo {

    private ArrayList<Carta> baralho;
    private String apelido;
    private String cartas;

    public static void main(String[] args) {
        IniciaJogo j = new IniciaJogo();
    }

    public IniciaJogo(){
        this.baralho = new ArrayList<Carta>();
        this.criaBaralho();
        this.apelido = "Pedro";
    }

    private void criaBaralho() {

        String naipe = "OECP";
        String frente = "1234567KJQ";

        this.baralho.clear();

        for (int n = 0; n < naipe.length(); n++) {
            for (int f = 0; f < frente.length(); f++) {
                Carta ca = new Carta(f, n,false);
                this.baralho.add(ca);
            }
        }
    }
}

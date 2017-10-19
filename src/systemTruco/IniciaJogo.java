package systemTruco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class IniciaJogo {

    private ArrayList<String> baralho = new ArrayList<String>();
    private Random sementeAleatoria = new Random();
    private String apelido;
    private String cartas;
    private String manilha;
    private int jogada = 0;
    private int rodada = 0;
    private int valorTruco = 1;
    private boolean acabar = false;
    private boolean[] empate = new boolean[3];

    public IniciaJogo(){
        this.criaBaralho();
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
        Collections.shuffle(baralho, this.sementeAleatoria);
        manilha = baralho.get(0);

        baralho.remove(0);
    }

    public String distribuir() { // cria a mensagem que sera enviada para o cliente 3 cartas e a manilha
        String cartas = "";
        for (int i = 0; i <= 2; i++) {
            if (i == 0) {
                cartas = "" + baralho.get(i);
            } else {
                cartas = cartas + ":" + baralho.get(i);
            }
            baralho.remove(i);
        }
        cartas = cartas + ":" + manilha;
        return cartas;
    }

    public String verMaior(String carta1, String carta2) {
        String maior = "";
        // carta1,carta2,manilha
        String[] svalor = new String[3];
        String[] snaipe = new String[3];
        int[] valor = new int[3];
        int[] naipe = new int[3];

        svalor[0] = "" + carta1.charAt(0);
        svalor[1] = "" + carta2.charAt(0);
        svalor[2] = "" + manilha.charAt(0);

        snaipe[0] = "" + carta1.charAt(1);
        snaipe[1] = "" + carta2.charAt(1);
        snaipe[2] = "" + manilha.charAt(1);

        for (int i = 0; i < 3; i++) { //valor da força das cartas

            try {
                if (Integer.parseInt(svalor[i]) < 8) {
                    valor[i] = Integer.parseInt(svalor[i]);
                    if (i < 2) {
                        if (valor[i] <= 3) {
                            valor[i] += 7;
                        } else {
                            valor[i] -= 3;
                        }
                    } else {
                        if (valor[i] < 3) {
                            valor[i] += 8;
                        } else {
                            if (valor[i] == 3) {
                                valor[i] = 1;
                            } else {
                                valor[i] -= 2;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                if (svalor[i].equals("d")) {
                    if (i == 2) {
                        valor[i] = 6;
                    } else {
                        valor[i] = 5;
                    }
                }
                if (svalor[i].equals("j")) {
                    if (i == 2) {
                        valor[i] = 7;
                    } else {
                        valor[i] = 6;
                    }
                }
                if (svalor[i].equals("q")) {
                    if (i == 2) {
                        valor[i] = 8;
                    } else {
                        valor[i] = 7;
                    }
                }
                /*
                 *  4   5   6   7   d   j   q   1   2   3
                 *  1   2   3   4   5   6   7   8   9   10
                 */
            }

            if (snaipe[i].equals("o")) {
                naipe[i] = 1;
            }
            if (snaipe[i].equals("e")) {
                naipe[i] = 2;
            }
            if (snaipe[i].equals("c")) {
                naipe[i] = 3;
            }
            if (snaipe[i].equals("p")) {
                naipe[i] = 4;
            }
        }

        if ((valor[0] != valor[2]) && (valor[1] != valor[2])) { // se carta1 e carta2 nao forem a manilha
            if (valor[0] > valor[1]) { // se carta1 maior que carta2
                maior = carta1;
            } else {
                if (valor[0] == valor[1]) {
                    maior = "empate";
                } else {
                    maior = carta2;
                }
            }
        } else {
            if ((valor[0] == valor[2]) && (valor[1] == valor[2])) {
                if (naipe[0] > naipe[1]) {
                    maior = carta1;
                } else {
                    if (naipe[0] == naipe[1]) {
                        //deve ser impossivel
                        maior = "bug";
                    } else {
                        maior = carta2;
                    }
                }
            }
            if ((valor[0] == valor[2]) && (valor[1] != valor[2])) {
                maior = carta1;
            }
            if ((valor[0] != valor[2]) && (valor[1] == valor[2])) {
                maior = carta2;
            }
        }
        if (carta1.equals("00") && !carta2.equals("00")) {
            maior = carta2;
        }
        if (carta2.equals("00") && !carta1.equals("00")) {
            maior = carta1;
        }
        if (carta1.equals("00") && carta2.equals("00")) {
            maior = "empate";
        }
        return maior;
    }
    /*
     *  4   5   6   7   d   j   q   1   2   3
     *  1   2   3   4   5   6   7   8   9   10
     */

    public int getJogada() {
        return jogada;
    }

    public void setJogada(int jogada) {
        this.jogada = jogada;
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada){
        this.rodada = rodada;
    }

    public int nextRodada() {
        if (rodada < 2) {
            this.rodada++;
        } else {
            rodada = 0;
        }
        return rodada;
    }

    public int getValorTruco() {
        return valorTruco;
    }

    public void setValorTruco(int valorTruco) {
        this.valorTruco = valorTruco;
    }

}

package systemTruco;

import java.util.Scanner;

public class Time {
    private timesNomes nome;
    private int placarRodada;
    static private int placarGeral;

    public static enum timesNomes {
        VERMELHO(1), AZUL(2), VERDE(3), AMARELO(4), CIANO(5), ROXO(6), BRANCO(7);
        private final int codigo;

        timesNomes(int codigo) {
            this.codigo = codigo;
        }

        int codigo() {
            return codigo;
        }
    }

    public Time() {
        int time = exibir();
        for (timesNomes p : timesNomes.values())
            if (p.codigo == time) {
                this.nome = p;
            }
        this.placarGeral = 0;
        this.placarRodada = 0;
    }

    public Time(int time) {
        for (timesNomes p : timesNomes.values())
            if (p.codigo == time) {
                this.nome = p;
            }
        this.placarGeral = 0;
        this.placarRodada = 0;
    }


    public int exibir() {
        int i = 0;
        for (timesNomes p : timesNomes.values()) {
            System.out.println((i + 1) + " " + p.name());
            i++;
        }
        Scanner ler = new Scanner(System.in);
        int time = ler.nextInt();
        return time;
    }

    public timesNomes getNome() {
        return nome;
    }

    public void zerarRodada() {
        this.placarRodada = 0;
    }

    public int getPlacarRodada() {
        return placarRodada;
    }

    public void setPlacarRodada() {
        this.placarRodada += 1;
    }

    public int getPlacarGeral() {
        return placarGeral;
    }

    public void setPlacarGeral(int valorTruco) {
        this.placarGeral += valorTruco;
    }
}

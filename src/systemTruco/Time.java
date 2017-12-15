package systemTruco;

import javax.swing.*;
import java.awt.*;

public class Time {
    private timesNomes nome;
    private int placarRodada;
    private int placarGeral;

    public static enum timesNomes {
        VERMELHO(1), AZUL(2), VERDE(3), AMARELO(4), CIANO(5), ROXO(6);
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

        String[] opcoes = {"VERMELHO", "AZUL", "VERDE", "AMARELO", "CIANO", "ROXO"};

        String resposta = (String) JOptionPane.showInputDialog(null,
                "Selecione seu time", "TIME",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, null);

        int time = timesNomes.valueOf(resposta).codigo;
        return time;
    }

    public void retonarValorTimes() {
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

    //Retorna cor de time
    public Color coresTimes(Jogador j) {
        Color cor = new Color(0x000000);
        switch (j.getTime().nome.codigo) {
            case 1:
                return cor = new Color(0x990000);
            case 2:
                return cor = new Color(0x1f1f7a);
            case 3:
                return cor = new Color(0x006622);
            case 4:
                return cor = new Color(0xD1CD45);
            case 5:
                return cor = new Color(0x778081);
            case 6:
                return cor = new Color(0x8B3F80);
        }
        return cor;
    }

}

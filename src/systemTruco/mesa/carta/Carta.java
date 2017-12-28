package systemTruco.mesa.carta;

import javax.swing.*;
import java.awt.*;

public class Carta {
    private boolean verso = true;
    private String valor;
    private String naipe;
    public static int cont = 0;
    private int id;
    private final static String caminhoImg = "src/resources/cartas/";
    private ImageIcon imagem = new ImageIcon(caminhoImg + "fundov.png");
    public Carta(int valor, int naipe) {

        //Cada carta tem seu id, medido também sua força
        this.id = cont++;

        switch (naipe) {
            case 0:
                this.naipe = "OUROS";
                break;
            case 1:
                this.naipe = "ESPADAS";
                break;
            case 2:
                this.naipe = "COPAS";
                break;
            case 3:
                this.naipe = "PAUS";
                break;
        }
        switch (valor) {
            case 9:
                this.valor = "TRÊS";
                break;
            case 8:
                this.valor = "DOIS";
                break;
            case 7:
                this.valor = "ÁS";
                break;
            case 6:
                this.valor = "REI";
                break;
            case 5:
                this.valor = "VALETE";
                break;
            case 4:
                this.valor = "DAMA";
                break;
            case 3:
                this.valor = "SETE";
                break;
            case 2:
                this.valor = "SEIS";
                break;
            case 1:
                this.valor = "CINCO";
                break;
            case 0:
                this.valor = "QUATRO";
                break;
        }
    }


    public boolean isVerso() {
        return verso;
    }

    public String getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    //Ao virar carta ele deve receber sua imagem correpondente
    public void virar() {
        this.verso = !this.verso;
        ImageIcon icon = new ImageIcon(caminhoImg + getId() + ".png");
        this.imagem = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Ao virar carta ele deve receber sua imagem correpondente
    public ImageIcon vira() {
        ImageIcon icon = new ImageIcon(caminhoImg + getId() + ".png");
        return icon;
    }

    //Pegar imagem de carta
    public ImageIcon getImagem() {
        return imagem;
    }
}
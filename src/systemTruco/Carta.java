package systemTruco;

public class Carta {
    private boolean verso;
    private String valor;
    private String naipe;
    private static int cont = 0;
    private int id;

    public Carta(int valor, int naipe) {

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

    public void virar() {
        this.verso = !this.verso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
package systemTruco;

public class Carta {
    private boolean verso;
    private String valor;
    private String naipe;

    public Carta(int valor, int naipe, boolean emVerso) {

        switch (naipe){
            case 0: this.naipe = "OUROS";
            break;
            case 1: this.naipe = "ESPADAS";
                break;
            case 2: this.naipe = "COPAS";
                break;
            case 3: this.naipe = "PAUS";
                break;
        }

        if (valor < 7) {
            this.valor = "" + (valor + 1);
        } else {

            switch (valor){
                case 7: this.valor = "REI";
                    break;
                case 8: this.valor = "VALETE";
                    break;
                case 9: this.valor = "RAINHA";
                    break;
            }
        }

        this.verso = emVerso;
    }

    public boolean isVirada() {
        return verso;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getValor() {
        return valor;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
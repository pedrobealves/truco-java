package systemTruco;

import javax.swing.*;

import systemTruco.Carta;

public class CartaButton extends JButton {
    private Carta carta;

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public CartaButton() {
        this.setVisible(true);
    }

    public CartaButton(Carta carta) {
        this.setVisible(true);
        this.setName(carta.getValor() + carta.getNaipe());

    }

    public CartaButton(String name) {
        super(name);
    }
}

package systemTruco;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import systemTruco.Jogador;
import systemTruco.Carta;

public class CartasPanel extends JPanel {
    private CartaButton cartas;
    private ArrayList<CartaButton> cartabuttons;

    public CartasPanel(Jogador j) {
        super();
        //this.removeAll();
        //this.revalidate();
        cartabuttons = new ArrayList<CartaButton>(3);
        //setPreferredSize(new Dimension(500,150));
        this.setOpaque(false);

        for (int i = 0; i < 1; i++) {
            CartaButton b = new CartaButton();
            b.setVisible(false);
            this.add(b);
            cartabuttons.add(b);
        }

        if (j.getJogada() != null) {
            ArrayList<Carta> hand = new ArrayList<>();
            hand.add(j.cartaJogada());
            this.setLayout(new FlowLayout());

            for (int i = 0; i < 1; i++) {
                //if(hand.get(i) instanceof MonsterCard){
                //monsterbuttons.get(i).setText(hand.get(i).getName());
                cartabuttons.get(i).setCarta((Carta) hand.get(i));
                cartabuttons.get(i).setVisible(true);
                ImageIcon img = new ImageIcon(hand.get(i).getImagem().getImage());
                Image img2 = img.getImage();
                Image newimg = img2.getScaledInstance(80, 116, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                cartabuttons.get(i).setIcon(newIcon);
                cartabuttons.get(i).setPreferredSize(new Dimension(80, 116));
                cartabuttons.get(i).revalidate();
                cartabuttons.get(i).setOpaque(false);
                cartabuttons.get(i).repaint();
            }
        }
    }

    public ArrayList<CartaButton> getCartas() {
        return cartabuttons;
    }

    public void setCartas(ArrayList<CartaButton> cartabuttons) {
        this.cartabuttons = cartabuttons;
    }
}

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
        //monsterbuttons.add(mb);
        //this.add(mb);
       /*setPreferredSize(new Dimension(500, 100));
        cartas = new CartaButton();
        this.setLayout(new GridLayout(1,1));
        this.setOpaque(true);
        this.setVisible(true);
        CartaButton cartabutton = new CartaButton();
        cartas.add(cartabutton);
        cartabutton.setBackground(Color.GRAY);
        cartabutton.setOpaque(false);
        this.add(cartabutton);
        //if (j.getJogada()!=null) {
        //cartas.setCarta(j.getJogada());
        cartas.setCarta(j.getCartasJogador().get(0));
        cartas.setVisible(true);
        ImageIcon newIcon;
        //ImageIcon img = new ImageIcon(j.getJogada().getImagem().getImage());
        ImageIcon img = new ImageIcon(j.getCartasJogador().get(0).getImagem().getImage());
        Image img2 = img.getImage();
        Image newimg = img2.getScaledInstance(62, 91, java.awt.Image.SCALE_SMOOTH);
        newIcon = new ImageIcon(newimg);
        cartas.setIcon(newIcon);
        cartas.setPreferredSize(new Dimension(62, 91));
        cartas.revalidate();
        cartas.setOpaque(false);
        cartas.repaint();*/
        //}
    }

    public ArrayList<CartaButton> getCartas() {
        return cartabuttons;
    }

    public void setCartas(ArrayList<CartaButton> cartabuttons) {
        this.cartabuttons = cartabuttons;
    }
}

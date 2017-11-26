package systemTruco;

import javax.swing.*;

import systemTruco.Carta;
import systemTruco.Jogador;
import systemTruco.CartaButton;

import java.awt.*;
import java.util.ArrayList;

public class MaoPanel extends JPanel {
    private ArrayList<CartaButton> cartabuttons;
    private JLabel pNome;

    public MaoPanel(Jogador p) {
        super();
        update(p);
    }

    public ArrayList<CartaButton> getMaoButtons() {
        return this.cartabuttons;
    }

    public void setMaoButtons(ArrayList<CartaButton> hb) {
        this.cartabuttons = hb;
    }

    public void update(Jogador p) {
        this.removeAll();
        this.revalidate();
        cartabuttons = new ArrayList<CartaButton>(3);
        //setPreferredSize(new Dimension(500,150));
        ArrayList<Carta> hand = p.getCartasJogador();
        this.setLayout(new FlowLayout());
        this.setOpaque(false);

        pNome = new JLabel(p.getNome());
        pNome.setOpaque(true);
        pNome.setFont(new Font("Century Gothic", Font.BOLD, 25));
        pNome.setForeground(Color.WHITE);
        pNome.setBackground(p.getTime().coresTimes(p));
        this.add(pNome);

        for (int i = 0; i < 3; i++) {
            CartaButton b = new CartaButton();
            b.setVisible(false);
            this.add(b);
            cartabuttons.add(b);
        }

        for (int i = 0; i < hand.size(); i++) {
            //if(hand.get(i) instanceof MonsterCard){
            //monsterbuttons.get(i).setText(hand.get(i).getName());
            cartabuttons.get(i).setCarta((Carta) hand.get(i));
            cartabuttons.get(i).setVisible(true);
            ImageIcon img = new ImageIcon(hand.get(i).getImagem().getImage());
            Image img2 = img.getImage();
            Image newimg = img2.getScaledInstance(100, 146, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            cartabuttons.get(i).setIcon(newIcon);
            cartabuttons.get(i).setPreferredSize(new Dimension(100, 146));
            cartabuttons.get(i).revalidate();
            cartabuttons.get(i).setOpaque(false);
            cartabuttons.get(i).repaint();
            //monsterbuttons.add(mb);
            //this.add(mb);
            //  }
        }
    }

    public JLabel getpNome() {
        return pNome;
    }

    public void setpNome(JLabel pNome) {
        this.pNome = pNome;
    }

    public ArrayList<CartaButton> getCartabuttons() {
        return cartabuttons;
    }

    public void setCartabuttons(ArrayList<CartaButton> cartabuttons) {
        this.cartabuttons = cartabuttons;
    }
}

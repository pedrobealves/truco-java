/*

@author Pedro Bernardi Alves

 */

package systemTruco.gui;

import systemTruco.controle.Controle;
import systemTruco.controle.Jogo;
import systemTruco.mesa.Mesa;
import systemTruco.mesa.carta.Carta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class Gui extends JFrame {

    private Jogo jogo;
    private Mesa mesa;
    private JPanel panelPrincipal;
    private JPanel panelP1;
    private JPanel panelP2;
    private JPanel panelP3;
    private JPanel panelP4;
    private CartasPanel cartasPanel1;
    private CartasPanel cartasPanel2;
    private CartasPanel cartasPanel3;
    private CartasPanel cartasPanel4;
    private Rodada rodada;
    private MaoPanel maop1;
    private MaoPanel maop2;
    private MaoPanel maop3;
    private MaoPanel maop4;
    private JScrollPane sp1;
    private JScrollPane sp2;
    private JScrollPane sp3;
    private JScrollPane sp4;
    private JButton vira;
    private JButton truco;
    private JLabel placar;
    private JLabel valorPlacar;
    private JLabel valorRodada;
    private RodadaPanel rodadaPanel;

    //Criar interface jframe
    public Gui(String playerNome, int numeroJogadores) throws IOException {
        super("SystemTRUCO");
        //Recebe fundo de jogo
        ImageIcon bg = new ImageIcon("src/resources/fundo.png");
        JLabel g = new JLabel(bg);
        g.setVisible(true);
        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("src/resources/fundo-mesa.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, 1350, 750, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.add(g);
        setResizable(false);
        setSize(1920, 1080);
        this.getContentPane().setLayout(null);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Cria novo jogo com nome de jogador já recebido e numero de jogadores
        jogo = new Jogo(playerNome, numeroJogadores);
        //Faz o update em desenho do visual
        mesa = new Mesa(jogo.getBaralho(), jogo.getJogador());

        //Criar painel de cartas de jogadores
        cartasPanel1 = new CartasPanel(jogo.getJogador().get(0));
        cartasPanel2 = new CartasPanel(jogo.getJogador().get(3));
        cartasPanel3 = new CartasPanel(jogo.getJogador().get(2));
        cartasPanel4 = new CartasPanel(jogo.getJogador().get(1));

        maop1 = new MaoPanel(jogo.getJogador().get(0));
        maop2 = new MaoPanel(jogo.getJogador().get(3));
        maop3 = new MaoPanel(jogo.getJogador().get(2));
        maop4 = new MaoPanel(jogo.getJogador().get(1));

        panelP1 = new JPanel();
        panelP1.setLayout(new BorderLayout());
        panelP1.add(cartasPanel1, BorderLayout.NORTH);
        panelP1.setOpaque(false);

        sp1 = new JScrollPane(maop1);
        sp1.setBorder(null);
        sp1.getViewport().setOpaque(false);
        sp1.setPreferredSize(new Dimension(500, 150));
        sp1.setOpaque(false);
        sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelP1.add(sp1, BorderLayout.SOUTH);
        this.revalidate();

        panelP2 = new JPanel();
        panelP2.setLayout(new BorderLayout());
        panelP2.add(cartasPanel2, BorderLayout.SOUTH);
        panelP2.setOpaque(false);


        sp2 = new JScrollPane(maop2);
        sp2.setBorder(null);
        sp2.getViewport().setOpaque(false);
        sp2.setPreferredSize(new Dimension(500, 150));
        sp2.setOpaque(false);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelP2.add(sp2, BorderLayout.NORTH);
        this.revalidate();

        panelP3 = new JPanel();
        panelP3.setLayout(new BorderLayout());
        panelP3.add(cartasPanel3, BorderLayout.NORTH);
        panelP3.setOpaque(false);

        sp3 = new JScrollPane(maop3);
        sp3.setBorder(null);
        sp3.getViewport().setOpaque(false);
        sp3.setPreferredSize(new Dimension(500, 150));
        sp3.setOpaque(false);
        sp3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelP3.add(sp3, BorderLayout.WEST);
        this.revalidate();

        panelP4 = new JPanel();
        panelP4.setLayout(new BorderLayout());
        panelP4.add(cartasPanel4, BorderLayout.NORTH);
        panelP4.setOpaque(false);

        sp4 = new JScrollPane(maop4);
        sp4.setBorder(null);
        sp4.getViewport().setOpaque(false);
        sp4.setPreferredSize(new Dimension(500, 150));
        sp4.setOpaque(false);
        sp4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelP4.add(sp4, BorderLayout.EAST);
        this.revalidate();

        //p1hid = new HiddenHandPanel(p1);
        //p2hid = new HiddenHandPanel(p2);

        rodada = new Rodada("Próxima Rodada");
        truco = new Rodada("Truco");
        vira = new JButton();
        ImageIcon imagePlacar = new ImageIcon("src/resources/placar.png");
        Image imagePlacarR = imagePlacar.getImage().getScaledInstance(331, 129, Image.SCALE_SMOOTH);
        imagePlacar = new ImageIcon(imagePlacarR);
        placar = new JLabel(imagePlacar);
        valorPlacar = new JLabel("0");
        valorPlacar.setFont(new Font("Century Gothic", Font.BOLD, 25));
        valorRodada = new JLabel("0");
        valorRodada.setFont(new Font("Century Gothic", Font.BOLD, 25));
        panelPrincipal = new JPanel();
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(null);
        panelPrincipal.add(truco);
        panelPrincipal.add(rodada);
        panelPrincipal.add(vira);
        panelPrincipal.add(valorRodada);
        panelPrincipal.add(valorPlacar);
        panelPrincipal.add(placar);
        rodadaPanel = new RodadaPanel();
        panelPrincipal.add(rodadaPanel);
        this.add(panelPrincipal);
        panelPrincipal.setBounds(0, 0, 1300, 800);
        truco.setBounds(5, 645, 157, 39);
        rodada.setBounds(5, 690, 157, 39);
        vira.setBounds(1200, 600, 80, 116);
        placar.setBounds(0, 0, 400, 150);
        valorPlacar.setBounds(95, 85, 20, 20);
        valorRodada.setBounds(250, 85, 20, 20);

        this.add(panelP1);
        panelP1.setBounds(300, 430, 700, 300);
        this.add(panelP2);
        panelP2.setBounds(300, 0, 700, 300);
        this.add(panelP3);
        panelP3.setBounds(0, 200, 700, 300);
        this.add(panelP4);
        panelP4.setBounds(500, 200, 700, 300);

        this.validate();
        //Cria classe que controla operações do jogo em sua interface
        new Controle(jogo, this, mesa);
    }

    public void setValorPlacar(int valorPlacar) {
        this.valorPlacar.setText(String.valueOf(valorPlacar));
    }

    public void setValorRodada(int valorRodada) {
        this.valorRodada.setText(String.valueOf(valorRodada));
    }

    public JButton getVira() {
        return vira;
    }

    public void setVira(Carta vira) {
        this.vira.setVisible(true);
        ImageIcon img = new ImageIcon(vira.vira().getImage());
        Image img2 = img.getImage();
        Image newimg = img2.getScaledInstance(80, 116, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        this.vira.setIcon(newIcon);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public JPanel getPanelP2() {
        return panelP2;
    }

    public void setPanelP2(JPanel panelP2) {
        this.panelP2 = panelP2;
    }

    public JPanel getPanelP3() {
        return panelP3;
    }

    public void setPanelP3(JPanel panelP3) {
        this.panelP3 = panelP3;
    }

    public JPanel getPanelP4() {
        return panelP4;
    }

    public void setPanelP4(JPanel panelP4) {
        this.panelP4 = panelP4;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelP1() {
        return panelP1;
    }

    public void setPanelP1(JPanel panelP1) {
        this.panelP1 = panelP1;
    }

    public CartasPanel getCartasPanel1() {
        return cartasPanel1;
    }

    public void setCartasPanel1(CartasPanel cartasPanel1) {
        this.cartasPanel1 = cartasPanel1;
    }

    public CartasPanel getCartasPanel2() {
        return cartasPanel2;
    }

    public void setCartasPanel2(CartasPanel cartasPanel2) {
        this.cartasPanel2 = cartasPanel2;
    }

    public CartasPanel getCartasPanel3() {
        return cartasPanel3;
    }

    public void setCartasPanel3(CartasPanel cartasPanel3) {
        this.cartasPanel3 = cartasPanel3;
    }

    public CartasPanel getCartasPanel4() {
        return cartasPanel4;
    }

    public void setCartasPanel4(CartasPanel cartasPanel4) {
        this.cartasPanel4 = cartasPanel4;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    public MaoPanel getMaop1() {
        return maop1;
    }

    public void setMaop1(MaoPanel maop1) {
        this.maop1 = maop1;
    }

    public MaoPanel getMaop2() {
        return maop2;
    }

    public void setMaop2(MaoPanel maop2) {
        this.maop2 = maop2;
    }

    public MaoPanel getMaop3() {
        return maop3;
    }

    public void setMaop3(MaoPanel maop3) {
        this.maop3 = maop3;
    }

    public MaoPanel getMaop4() {
        return maop4;
    }

    public void setMaop4(MaoPanel maop4) {
        this.maop4 = maop4;
    }

    public JScrollPane getSp1() {
        return sp1;
    }

    public void setSp1(JScrollPane sp1) {
        this.sp1 = sp1;
    }

    public JScrollPane getSp2() {
        return sp2;
    }

    public void setSp2(JScrollPane sp2) {
        this.sp2 = sp2;
    }

    public JScrollPane getSp3() {
        return sp3;
    }

    public void setSp3(JScrollPane sp3) {
        this.sp3 = sp3;
    }

    public JScrollPane getSp4() {
        return sp4;
    }

    public void setSp4(JScrollPane sp4) {
        this.sp4 = sp4;
    }

    public JButton getTruco() {
        return truco;
    }

    public void setTruco(JButton truco) {
        this.truco = truco;
    }

    public static void main(String[] args) {
        JFrame start = new JFrame();
        start.setSize(1920, 1080);
        start.setVisible(true);
        start.setContentPane(new JLabel(new ImageIcon("src/resources/start.png")));

        start.revalidate();
        start.setLayout(null);
        JTextField p1 = new JTextField();
        start.add(p1);
        p1.setBounds(475, 350, 400, 50);

        JLabel myLabel = new JLabel("Números de jogadores");
        JRadioButton quart = new JRadioButton("4 Jogadores", false);
        JRadioButton dupla = new JRadioButton("2 Jogadores", false);
        start.add(quart);
        quart.setBounds(475, 450, 400, 50);
        start.add(dupla);
        dupla.setBounds(475, 487, 400, 50);

        JButton startbut = new JButton(new ImageIcon("Start Button.png"));
        startbut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (p1.getText().length() == 0 || !dupla.isSelected() && !quart.isSelected()) {
                    JOptionPane.showMessageDialog(start, "Por favor, preencha com todos dados");
                } else if (p1.getText().length() >= 14) {
                    JOptionPane.showMessageDialog(start, "Nome não deve possuir mais que 14 caracteres");
                } else {
                    start.setVisible(false);
                    try {
                        if (quart.isSelected()) {
                            Gui gui = new Gui(p1.getText(), 4);
                        } else {
                            Gui gui = new Gui(p1.getText(), 2);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        startbut.setBounds(510, 637, 311, 57);
        startbut.setVisible(true);
        startbut.setOpaque(true);
        startbut.revalidate();
        startbut.repaint();
        start.add(startbut);
        start.validate();
    }
}

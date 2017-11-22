package systemTruco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

    private Jogo jogo;
    private Mesa mesa;
    private JPanel panelPrincipal;
    private JPanel panelJogo;
    private JPanel panelMenu;
    private JButton Truco;
    private JButton Sair;
    private JPanel panelJogador2;
    private JPanel panelJogador1;
    private JPanel panelJogador3;
    private JPanel panelJogador4;
    private JPanel panelMesa;
    private JPanel imageJogador;
    private JPanel imageJogador1;
    private JButton cartaJogador4;
    private JButton cartaJogador3;
    private JLabel nomeJogador2;
    private JPanel imageJogador3;
    private JPanel imageJogador4;
    private JButton cartaJogador2;
    private JButton buttons[][];
    private JButton vira;
    private JLabel Placar;
    private JButton cartaJogador1;
    private JLabel nomeJogador1;
    private JLabel nomeJogador4;
    private JLabel nomeJogador3;
    private boolean clique;


    public Principal() {
        configuraTela();
        iniciaJogo();
    }

    public void iniciaJogo() {
        inicializaButtons();
        adicionaComponentes();
        jogo = new Jogo();
        boolean acabar = false;
            mesa = new Mesa(jogo.getBaralho(), jogo.getJogador());
            iniciaComponentes();


    }

    public void configuraTela() {
        JFrame frame = new JFrame("SystemTRUCO");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void inicializaButtons() {
        buttons = new JButton[4][3];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].addActionListener(new Eventos());
                //buttons[i][j].setEnabled(false);
            }
        }
    }

    private void adicionaComponentes() {

        for (int i = 0; i < 3; i++) {
            panelJogador1.add(buttons[0][i]);
        }

        for (int i = 0; i < 3; i++) {
            panelJogador2.add(buttons[1][i]);
        }

        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < 3; i++) {
            c.gridx = 0;
            c.gridy = i + 2;
            panelJogador3.add(buttons[2][i], c);
        }

        for (int i = 0; i < 3; i++) {
            c.gridx = 0;
            c.gridy = i + 2;
            panelJogador4.add(buttons[3][i], c);
        }

    }

    public void iniciaComponentes() {

        nomeJogador1.setText(mesa.getJogador().get(0).getNome());
        nomeJogador2.setText(mesa.getJogador().get(1).getNome());
        nomeJogador3.setText(mesa.getJogador().get(2).getNome());
        nomeJogador4.setText(mesa.getJogador().get(3).getNome());

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setBorder(null);
                buttons[i][j].setIcon(mesa.getJogador().get(i).getCartasJogador().get(j).getImagem());
            }
        }

        mesa.iniciaJogo();
        vira.setIcon(mesa.getVira().getImagem());
        vira.setBorder(null);

        /*while (mesa.getRodada()<3) {
            ordemJogadas();
        }*/
    }

    public void ordemJogadas() {
        /*clique = false;
        if (!mesa.vencedor.isJogadorIA())
            JOptionPane.showMessageDialog(null, "Faça sua jogada");
        while (!clique) {
        }
        mesa.vencedor.getIA().setManilha(mesa.getManilha());
        mesa.vencedor.gerarJogada();
        mesa.vencedor.visualCartaJogada();

        for (Jogador aJogador : mesa.getJogador()) {
            if (aJogador.getJogada() == null) {
                if (!aJogador.isJogadorIA())
                    JOptionPane.showMessageDialog(null, "Faça sua jogada");
                while (!clique);
                aJogador.gerarJogada();
                aJogador.cartaJogada().virar();
                aJogador.visualCartaJogada();
                mesa.verificarGanhador();
                aJogador.getIA().setVencedorTemp(mesa.vencedor);
            }
        }
        cartaJogador1.setIcon(mesa.getJogador().get(0).cartaJogada().getImagem());
        cartaJogador1.setBorder(null);
        cartaJogador2.setIcon(mesa.getJogador().get(1).cartaJogada().getImagem());
        cartaJogador2.setBorder(null);
        cartaJogador3.setIcon(mesa.getJogador().get(2).cartaJogada().getImagem());
        cartaJogador3.setBorder(null);
        cartaJogador4.setIcon(mesa.getJogador().get(3).cartaJogada().getImagem());
        cartaJogador4.setBorder(null);*/
    }

    private class Eventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();

            if (b.getParent() == panelJogador1) {

                clique = false;
                if (!mesa.vencedor.isJogadorIA())
                    JOptionPane.showMessageDialog(null, "Faça sua jogada");
                while (!clique) {
                    if (b == buttons[0][0]) {
                        mesa.getJogador().get(0).jogada(1);
                    }
                    if (b == buttons[0][1]) {
                        mesa.getJogador().get(0).jogada(2);
                    }
                    if (b == buttons[0][2]) {
                        mesa.getJogador().get(0).jogada(3);
                    }
                    clique = true;
                }
                mesa.vencedor.getIA().setManilha(mesa.getManilha());
                mesa.vencedor.gerarJogada();
                mesa.vencedor.visualCartaJogada();

                for (Jogador aJogador : mesa.getJogador()) {
                    if (aJogador.getJogada() == null) {
                        if (!aJogador.isJogadorIA())
                            JOptionPane.showMessageDialog(null, "Faça sua jogada");
                        while (!clique) ;
                        aJogador.gerarJogada();
                        aJogador.cartaJogada().virar();
                        aJogador.visualCartaJogada();
                        mesa.verificarGanhador();
                        aJogador.getIA().setVencedorTemp(mesa.vencedor);
                    }
                }
                cartaJogador1.setIcon(mesa.getJogador().get(0).cartaJogada().getImagem());
                cartaJogador1.setBorder(null);
                cartaJogador2.setIcon(mesa.getJogador().get(1).cartaJogada().getImagem());
                cartaJogador2.setBorder(null);
                cartaJogador3.setIcon(mesa.getJogador().get(2).cartaJogada().getImagem());
                cartaJogador3.setBorder(null);
                cartaJogador4.setIcon(mesa.getJogador().get(3).cartaJogada().getImagem());
                cartaJogador4.setBorder(null);
                mesa.verificarGanhador();
                mesa.vencedorMao();
                mesa.vencedorRodada();
                mesa.vencedorJogo();
                mesa.limparMesa();
                mesa.proximaRodada();
            }
        }

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

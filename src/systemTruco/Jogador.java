package systemTruco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private ArrayList<Carta> cartasJogador = new ArrayList<>();
    private Random randomico = new Random();
    private Carta jogada;
    private Time time;
    private boolean jogadorIA;
    private IA ia;

    public Jogador(Time time) {
        this.time = time;
        this.setNome();
        this.jogadorIA = true;
    }

    public Jogador(String nome) {
        System.out.println("Digite seu time: ");
        Time time = new Time();
        this.time = time;
        this.nome = nome;
    }

    public void ativarIA() {
        IA ia = new IA();
        this.ia = ia;
        this.ia.ativarIA(this);
    }

    public void ativarIA(IA ia) {
        this.ia = ia;
        this.ia.ativarIA(this);
    }


    public void visualCartaJogada() {
        System.out.println("\n" + nome + " " + time.getNome());
        System.out.println("\n" + jogada.getValor() + " " + jogada.getNaipe());
    }

    private void setNome() {
        File arq = new File("src\\systemTruco\\Nomes");
        try (Reader in = new FileReader(arq); BufferedReader br = new
                BufferedReader(in)) {
            String linha;
            int count = 0, rand = randomico.nextInt(25);
            while ((linha = br.readLine()) != null) {
                if (count == rand)
                    this.nome = linha;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void distribuiCartas(ArrayList<Carta> c) {
        for (int i = 0; i < 3; i++)
            cartasJogador.add(c.remove(i));
    }

    public String getNome() {
        return nome;
    }

    public void jogada(int suaJogada) {
        this.jogada = cartasJogador.get(suaJogada - 1);
        cartasJogador.remove(suaJogada - 1);
    }

    public Carta cartaJogada() {
        return jogada;
    }

    public Time getTime() {
        return time;
    }

    public void verCartasJogador() {
        int i = 0;
        for (Carta c : cartasJogador) {
            System.out.println((i + 1) + " " + c.getValor() + " " + c.getNaipe());
            i++;
        }

    }

    public void gerarJogada() {
        int suaJogada = 0;

        if (!this.jogadorIA) {
            verCartasJogador();
            Scanner ler = new Scanner(System.in);
            suaJogada = ler.nextInt();
        } else {
            suaJogada = ia.gerarJogada(this);
        }
        jogada(suaJogada);
    }

    public boolean isJogadorIA() {
        return jogadorIA;
    }

    public IA getIA() {
        return ia;
    }

    public ArrayList<Carta> getCartasJogador() {
        return cartasJogador;
    }

    public Carta getJogada() {
        return jogada;
    }
}

package systemTruco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Jogador {
    private String nome;
    private ArrayList<Carta> cartasJogador = new ArrayList<Carta>();
    private Random randomico = new Random();
    private Carta jogada;
    private Time time;

    public Jogador(Time time) {
        this.time = time;
        this.setNome();
    }

    public Jogador(String nome) {
        System.out.println("Digite seu time: ");
        Time time = new Time();
        this.time = time;
        this.nome = nome;
    }

    public void visualCartaJogada() {
        System.out.println("\n" + nome + " " + time.getNome());
        System.out.println("\n" + jogada.getValor() + " " + jogada.getNaipe());
    }

    private void setNome() {
        try {
            FileReader arq = new FileReader("C:\\Users\\Pedro\\Desktop\\UTFPR\\POO\\systemTruco\\src\\systemTruco\\Nomes");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            int count = 0, rand = randomico.nextInt(25);
            while (linha != null) {
                if (count == rand)
                    this.nome = linha;
                count++;
                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
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
        switch (suaJogada) {
            case 1:
                this.jogada = cartasJogador.get(0);
                cartasJogador.remove(0);
                break;
            case 2:
                this.jogada = cartasJogador.get(1);
                cartasJogador.remove(1);
                break;
            case 3:
                this.jogada = cartasJogador.get(2);
                cartasJogador.remove(2);
                break;
        }
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

    public int gerarJogada() {
        return randomico.nextInt(getCartasJogador().size()) + 1;
    }

    public ArrayList<Carta> getCartasJogador() {
        return cartasJogador;
    }

}

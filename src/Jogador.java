package src;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    public List<Carta> cartas;
    public String nome;

    public Jogador(String nome) {
        this.cartas = new ArrayList<>();
        this.nome = nome;
    }

    public Carta jogada(Carta cartaNaMesa) {
        if (cartas.isEmpty()) {
            return null; // ou lança uma exceção, dependendo do comportamento desejado
        }

        boolean temManilha = false;
        Carta cartaJogada = null;

        // Verifica se o jogador possui manilha na mão
        for (Carta carta : cartas) {
            if (carta.valor == 10000) { // Exemplo de verificação para manilha de paus
                cartaJogada = carta;
                temManilha = true;
                break;
            }
        }

        // Se não tiver manilha, joga a carta mais forte possível
        if (!temManilha) {
            cartaJogada = cartas.get(0); // Supondo que a primeira carta é a mais forte sem manilha
        }

        cartas.remove(cartaJogada);
        return cartaJogada;
    }

    public void exibeCartas() {
        cartas.forEach(c -> {
            System.out.print(c + " ");
        });
        System.out.println();
    }
}

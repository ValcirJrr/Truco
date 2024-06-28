package src;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

    public List<Jogador> jogadores;
    public List<Rodada> rodadas;
    public Baralho baralho;
    public Carta cartaVirada;
    public byte pontuacaoA;
    public byte pontuacaoB;

    public Jogo(Jogador jogadorUm, Jogador jogadorDois) {
        this.jogadores = new ArrayList<>(List.of(jogadorUm, jogadorDois));
        this.baralho = new Baralho();
        this.rodadas = new ArrayList<>();
        pontuacaoA = 0;
        pontuacaoB = 0;
    }

    public boolean alguemGanhou() {
        return pontuacaoA >= 2 || pontuacaoB >= 2; // Mudança para 2, pois o jogo de truco brasileiro é melhor de 2 rodadas
    }

    public void distribuirCartas() {
        cartaVirada = baralho.cartas.get(6);
        UserIteract.exibeCartaVirada(cartaVirada);

        for (Jogador jogador : jogadores) {
            jogador.cartas.clear(); // Limpa as cartas do jogador antes de distribuir novamente
            for (int i = 0; i < 3; i++) {
                jogador.cartas.add(baralho.cartas.remove(0));
            }
        }
    }

    public void iniciarRodada() {
        rodadas.add(new Rodada());
        final Rodada rodada = rodadas.get(rodadas.size() - 1);
        for (int i = 0; i < 3; i++) {
            rodada.cartaJogadorUm[i] = jogada(0, null);
            rodada.cartaJogadorDois[i] = jogada(1, rodada.cartaJogadorUm[i]);
        }
        defineVencedorRodada(rodada);
        distribuirCartas(); // Distribui as cartas novamente após cada rodada
    }

    private Carta jogada(int index, Carta cartaMesa) {
        Jogador jogador = jogadores.get(index);
        if (jogador.cartas.isEmpty()) {
            System.out.println("Erro: O jogador " + jogador.nome + " não tem cartas para jogar.");
            return null;
        }

        Carta carta = jogador.jogada(cartaMesa);
        if (carta == null) {
            System.out.println("Erro: O jogador " + jogador.nome + " tentou jogar uma carta nula.");
            return null;
        }

        removeCartaJogadaDaMaoDoJogador(index, carta);
        UserIteract.exibeCartaJogada(jogador.nome, carta);
        return carta;
    }

    private void removeCartaJogadaDaMaoDoJogador(int index, Carta carta) {
        Jogador jogador = jogadores.get(index);
        jogador.cartas.remove(carta);
    }

    private void defineVencedorRodada(Rodada rodada) {
        int ganhadorRodada = 0;
        int pontosJogadorUm = 0;
        int pontosJogadorDois = 0;

        for (int i = 0; i < 3; i++) {
            if (rodada.cartaJogadorUm[i].valor > rodada.cartaJogadorDois[i].valor) {
                pontosJogadorUm++;
            } else if (rodada.cartaJogadorUm[i].valor < rodada.cartaJogadorDois[i].valor) {
                pontosJogadorDois++;
            }
        }

        if (pontosJogadorUm > pontosJogadorDois) {
            ganhadorRodada = 1;
        } else if (pontosJogadorUm < pontosJogadorDois) {
            ganhadorRodada = 2;
        }

        if (ganhadorRodada == 1) {
            pontuacaoA++;
        } else if (ganhadorRodada == 2) {
            pontuacaoB++;
        }

        UserIteract.vencedorRodada(ganhadorRodada, jogadores.get(0), jogadores.get(1));
    }

    public boolean alguemPontuou() {
        return pontuacaoA >= 2 || pontuacaoB >= 2; // Mudança para 2, pois o jogo de truco brasileiro é melhor de 2 rodadas
    }
}

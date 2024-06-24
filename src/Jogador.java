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

    public Carta jogada(Carta cartaNaMesa){
        if (cartaNaMesa == null) {
            // Se não há carta na mesa, joga a carta de maior valor
            Carta cartaEscolhida = cartas.get(0); // Começa com a primeira carta
            for (Carta carta : cartas) {
                if (carta.valor > cartaEscolhida.valor) {
                    cartaEscolhida = carta;
                }
            }
                return cartaEscolhida;
        }else{
            Carta cartaEscolhida = null;
            List<Carta> cartasMaiores = new ArrayList<>();
            // Encontra as cartas maiores que a carta na mesa
            for (Carta carta : cartas) {
                if (carta.valor > cartaNaMesa.valor) {
                    cartasMaiores.add(carta);
                }
            }

            // Se houver mais de uma carta maior, escolhe a mais fraca
            if (cartasMaiores.size() > 1) {
                cartaEscolhida = cartasMaiores.get(0); // Começa com a primeira carta maior
                for (Carta carta : cartasMaiores) {
                    if (carta.valor < cartaEscolhida.valor) {
                        cartaEscolhida = carta;
                    }
                }
            } else if (cartasMaiores.size() == 1) {
                // Se houver apenas uma carta maior, joga ela
                cartaEscolhida = cartasMaiores.get(0);
            } else {
                // Se não houver cartas maiores, encontra a menor
                cartaEscolhida = cartas.get(0); // Começa com a primeira carta
                for (Carta carta : cartas) {
                    if (carta.valor < cartaEscolhida.valor) {
                        cartaEscolhida = carta;
                }
            }
            }
            
        
        return cartaEscolhida; // Retorna a carta escolhida
    }
}


    public void exibeCartas(){
        cartas.forEach(c -> {
            System.out.print(c + " ");
        });
        System.out.println();
    }
}
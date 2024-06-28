package src;

public class UserIteract {

    private static final String EMBARALHANDO = "Embaralhando...";
    private static final String PLACAR = "%s: %d || %s: %d%n";
    private static final String CARTA_JOGADA = "%s jogou %s%n";
    private static final String GANHADOR_RODADA = ">>>>>>>> %s venceu%n";
    private static final String EMBUCHOU = ">>>>>>>>>>> embuchou%n";
    private static final String DIVISOR = "=========================================";
    private static final String VIROU = "<< Virou %s >>%n";

    public static void mensagemEmbaralhando() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(EMBARALHANDO);
    }

    public static void exibirPlacar(String nome1, int pontos1, String nome2, int pontos2) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        divisor();
        System.out.printf(PLACAR, nome1, pontos1, nome2, pontos2);
        divisor();
    }

    public static void exibeCartaJogada(String nome, Carta carta) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf(CARTA_JOGADA, nome, carta);
    }

    public static void vencedorRodada(int ganhador, Jogador j1, Jogador j2) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf(ganhador != 0 ? GANHADOR_RODADA : EMBUCHOU, ganhador == 1 ? j1.nome : j2.nome);
    }

    public static void divisor() {
        System.out.println(DIVISOR);
    }

    public static void exibeCartaVirada(Carta carta) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf(VIROU, carta);
    }
}

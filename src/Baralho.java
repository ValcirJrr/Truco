package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static src.Naipe.*;

public class Baralho {

    public List<Carta> cartas = new ArrayList<>();

    public Baralho() {
        this.cartas.addAll(List.of(
                new Carta(1, PAUS, 11), new Carta(2, PAUS, 12), new Carta(3, PAUS, 13),
                new Carta(4, PAUS, 4), new Carta(5, PAUS, 5), new Carta(6, PAUS, 6),
                new Carta(7, PAUS, 7), new Carta(8, PAUS, 8), new Carta(9, PAUS, 9),
                new Carta(10, PAUS, 10), new Carta(1, COPAS, 11), new Carta(2, COPAS, 12),
                new Carta(3, COPAS, 13), new Carta(4, COPAS, 4), new Carta(5, COPAS, 5),
                new Carta(6, COPAS, 6), new Carta(7, COPAS, 7), new Carta(8, COPAS, 8),
                new Carta(9, COPAS, 9), new Carta(10, COPAS, 0), new Carta(1, ESPADAS, 11),
                new Carta(2, ESPADAS, 12), new Carta(3, ESPADAS, 13), new Carta(4, ESPADAS, 4),
                new Carta(5, ESPADAS, 5), new Carta(6, ESPADAS, 6), new Carta(7, ESPADAS, 7),
                new Carta(8, ESPADAS, 8), new Carta(9, ESPADAS, 9), new Carta(10, ESPADAS, 10),
                new Carta(1, OUROS, 11), new Carta(2, OUROS, 12), new Carta(3, OUROS, 13),
                new Carta(4, OUROS, 4), new Carta(5, OUROS, 5), new Carta(6, OUROS, 6),
                new Carta(7, OUROS, 7), new Carta(8, OUROS, 8), new Carta(9, OUROS, 9),
                new Carta(10, OUROS, 10)));
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }
}

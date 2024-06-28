package src;

public class Carta {

    public final Integer numero;
    public final Naipe naipe;
    public Integer valor;

    public Carta(Integer numero, Naipe naipe, Integer valor) {
        this.numero = numero;
        this.naipe = naipe;
        this.valor = valor;
    }

    @Override
    public String toString() {
        if (numero == 8) return "J " + naipe.toString();
        if (numero == 9) return "Q " + naipe.toString();
        if (numero == 10) return "K " + naipe.toString();
        return numero + " " + naipe.toString();
    }
}

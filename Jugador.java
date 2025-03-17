import java.util.ArrayList;
import java.util.List;

public class Jugador {  // Mantén el nombre de la clase como 'Jugador'
    public String nombre; // Nombre del jugador (puede ser modificado por otras clases)
    private List<Carta> mano; // Lista de cartas del jugador
    private Mazo mazo; // Referencia al mazo de cartas

    /**
     * Constructor de la clase Jugador.
     * Inicializa el nombre del jugador y su mano de cartas.
     *
     * @param nombre Nombre del jugador.
     * @param mazo   Mazo del cual se repartirán las cartas.
     */
    public Jugador(String nombre, Mazo mazo) {  // Se mantiene el constructor con el nombre de 'Jugador'
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new ArrayList<>();
    }

    /**
     * Asigna cartas al jugador desde el mazo.
     *
     * @param cantidad Número de cartas a asignar.
     */
    public void asignarCartas(int cantidad) {
        List<Carta> cartasRepartidas = mazo.repartirCartas(cantidad);
        mano.addAll(cartasRepartidas);
    }

    /**
     * Permite al jugador deshacerse de una carta específica.
     *
     * @param carta Carta que el jugador desea descartar.
     */
    public void descartarCarta(Carta carta) {
        if (mano.contains(carta)) { // Verifica si el jugador tiene la carta en su mano
            mano.remove(carta); // La elimina de la mano
            mazo.devolverCarta(carta); // La devuelve al mazo
            System.out.println(nombre + " ha descartado la carta: " + carta);
        } else {
            System.out.println("No tienes esta carta en tu mano.");
        }
    }

    /**
     * Devuelve la información del jugador, incluyendo su nombre y las cartas en su mano.
     *
     * @return Cadena con la información del jugador.
     */
    public String obtenerInformacionJugador() {
        return "Jugador: " + nombre + "\nCartas en mano: " + mano;
    }

}

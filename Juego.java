import java.util.ArrayList;
import java.util.List;

public class Juego {
    public String nombre; // Nombre del jugador (puede ser modificado por otras clases)
    private List<Carta> mano; // Lista de cartas del jugador
    private Mazo mazo; // Referencia al mazo de cartas

    // Constructor de la clase Juego
    public Juego(String nombre, Mazo mazo) {
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new ArrayList<>();
    }

    // Asigna cartas al jugador desde el mazo
    public void asignarCartas(int cantidad) {
        List<Carta> cartasRepartidas = mazo.repartirCartas(cantidad);
        mano.addAll(cartasRepartidas);
    }

    // Permite al jugador deshacerse de una carta específica
    public void descartarCarta(Carta carta) {
        if (mano.contains(carta)) { // Verifica si el jugador tiene la carta en su mano
            mano.remove(carta); // La elimina de la mano
            mazo.devolverCarta(carta); // La devuelve al mazo
            System.out.println(nombre + " ha descartado la carta: " + carta);
        } else {
            System.out.println("No tienes esta carta en tu mano.");
        }
    }

    // Devuelve la información del jugador, incluyendo su nombre y las cartas en su mano
    public String obtenerInformacionJugador() {
        return "Jugador: " + nombre + "\nCartas en mano: " + mano;
    }

    // Método main para probar el juego
    public static void main(String[] args) {
        Mazo mazo = new Mazo(); // Se crea el mazo
        mazo.barajar(); // Se baraja el mazo

        // Crear jugadores
        Juego jugador1 = new Juego("Carlos", mazo);  // Se usa 'Juego' para los jugadores
        Juego jugador2 = new Juego("Ana", mazo);     // Se usa 'Juego' para los jugadores

        // Asignar cartas a los jugadores
        jugador1.asignarCartas(5);
        jugador2.asignarCartas(5);

        // Mostrar información inicial de los jugadores
        System.out.println("=== Estado Inicial ===");
        System.out.println(jugador1.obtenerInformacionJugador());
        System.out.println(jugador2.obtenerInformacionJugador());

        // Mostrar cartas disponibles en el mazo después de repartir
        System.out.println("\nCartas restantes en el mazo: " + mazo.obtenerCartasDisponibles().size());

        // Jugador 1 descarta una carta si tiene cartas
        if (!jugador1.mano.isEmpty()) {
            Carta cartaADescartar = jugador1.mano.get(0);
            jugador1.descartarCarta(cartaADescartar);
        }

        // Jugador 2 descarta una carta si tiene cartas
        if (!jugador2.mano.isEmpty()) {
            Carta cartaADescartar = jugador2.mano.get(0);
            jugador2.descartarCarta(cartaADescartar);
        }

        // Mostrar información de los jugadores después de descartar
        System.out.println("\n=== Después de descartar una carta ===");
        System.out.println(jugador1.obtenerInformacionJugador());
        System.out.println(jugador2.obtenerInformacionJugador());

        // Mostrar cartas disponibles en el mazo después de devolver cartas
        System.out.println("\nCartas restantes en el mazo: " + mazo.obtenerCartasDisponibles().size());
    }
}

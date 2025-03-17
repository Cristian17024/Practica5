import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas; // Lista de cartas disponibles en el mazo
    private List<Carta> cartasRepartidas; // Lista de cartas que han sido repartidas

    // Constructor: inicializa las listas y llena el mazo con cartas
    public Mazo() {
        this.cartas = new ArrayList<>();
        this.cartasRepartidas = new ArrayList<>();
        inicializarMazo();
    }

    // Restablece el mazo a su configuración inicial
    public void inicializarMazo() {
        cartas.clear(); // Se vacía el mazo
        for (Carta.Palo palo : Carta.Palo.values()) { // Recorre cada tipo de palo
            for (int valor = 1; valor <= 13; valor++) { // Valores del 1 (As) al 13 (Rey)
                cartas.add(new Carta(valor, palo)); // Se crea y agrega una carta al mazo
            }
        }
        cartasRepartidas.clear(); // Se vacía la lista de cartas repartidas
    }

    // Baraja las cartas del mazo de manera aleatoria
    public void barajar() {
        Collections.shuffle(cartas); // Mezcla aleatoriamente la lista de cartas
    }

    // Reparte una cantidad específica de cartas
    public List<Carta> repartirCartas(int numeroDeCartas) {
        if (numeroDeCartas > cartas.size()) { // Verifica si hay suficientes cartas
            throw new IllegalArgumentException("No hay suficientes cartas en el mazo.");
        }

        List<Carta> cartasRepartidasAhora = new ArrayList<>();
        for (int i = 0; i < numeroDeCartas; i++) {
            Carta carta = cartas.remove(0); // Saca la primera carta del mazo
            cartasRepartidas.add(carta); // Se agrega a la lista de cartas repartidas
            cartasRepartidasAhora.add(carta); // Se agrega a la lista de retorno
        }
        return cartasRepartidasAhora;
    }

    // Permite devolver una carta al mazo y removerla de las cartas repartidas
    public void devolverCarta(Carta carta) {
        if (cartasRepartidas.contains(carta)) { // Verifica si la carta fue repartida
            cartas.add(carta); // Se devuelve al mazo
            cartasRepartidas.remove(carta); // Se elimina de la lista de cartas repartidas
        }
    }

    // Obtiene la lista de cartas disponibles en el mazo
    public List<Carta> obtenerCartasDisponibles() {
        return new ArrayList<>(cartas);
    }

    // Obtiene la lista de cartas que han sido repartidas
    public List<Carta> obtenerCartasRepartidas() {
        return new ArrayList<>(cartasRepartidas);
    }
}

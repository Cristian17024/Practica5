public class Carta {
    // Enum que guarda los tipos de cartas
    public enum Palo {
        CORAZONES,
        DIAMANTES,
        TREBOLES,
        PICAS
    }
    // Atributos de las cartas
    private int valor;
    private Palo tipo; // Cambiado a Palo (enum)

    // Métodos getters para regresar y poder obtener los valores de tipo y valor de cada carta
    public int getValor() {
        return valor;
    }

    public Palo getTipo() {
        return tipo;
    }

    // Constructor que inicia los atributos
    public Carta(int valor, Palo tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    // Método toString para representar la carta en formato legible
    public String toString() {
        String valorRepresentacion;
        switch (valor) {
            case 1:
                valorRepresentacion = "A";
                break;
            case 11:
                valorRepresentacion = "J";
                break;
            case 12:
                valorRepresentacion = "Q";
                break;
            case 13:
                valorRepresentacion = "K";
                break;
            default:
                valorRepresentacion = String.valueOf(valor);
        }
        return valorRepresentacion + " de " + tipo;
    }
}

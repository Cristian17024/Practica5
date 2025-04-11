public class Cuadrado extends Square {
    private Posicion posicion;
    private Carta carta;

    /**
     * Constructor para crear un Cuadrado con una carta y una posición específica.
     */
    public Cuadrado(Carta carta, Posicion posicion) {
        super(); // Llama al constructor de Square
        this.carta = carta;
        this.posicion = posicion;

        // Coloca el cuadrado en la posición definida por el objeto Posicion
        moverA(posicion.getX(), posicion.getY());
    }

    //Cambia la carta contenida en este Cuadrado.
    public void establecerCarta(Carta nuevaCarta) {
        this.carta = nuevaCarta;
    }

    // Obtiene la carta actual del Cuadrado.

    public Carta obtenerCarta() {
        return carta;
    }

    // Cambia la posición del Cuadrado.
     
    public void establecerPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
        moverA(posicion.getX(), posicion.getY());
    }
    public Posicion obtenerPosicion() {
        return posicion;
    }

    //Mueve el cuadrado directamente a una posición específica.
    
    public void moverA(int x, int y) {
        hacerInvisible(); // Borra el cuadrado actual
        moverHorizontal(x - obtenerX());
        moverVertical(y - obtenerY());
        hacerVisible();
    }

    // Accede al valor actual de xPosition desde la clase padre
    private int obtenerX() {
        try {
            java.lang.reflect.Field campo = Square.class.getDeclaredField("xPosition");
            campo.setAccessible(true);
            return campo.getInt(this);
        } catch (Exception e) {
            return 0;
        }
    }

    // Accede al valor actual de yPosition desde la clase padre
    private int obtenerY() {
        try {
            java.lang.reflect.Field campo = Square.class.getDeclaredField("yPosition");
            campo.setAccessible(true);
            return campo.getInt(this);
        } catch (Exception e) {
            return 0;
        }
    }

    // Muestra una representación del cuadrado en forma de texto.
    
    public String toString() {
        return "Cuadrado en (" + posicion.getX() + ", " + posicion.getY() + ") con carta: " + carta;
    }

    public void hacerVisible() {
        super.makeVisible();
    }

    public void hacerInvisible() {
        super.makeInvisible();
    }

    public void moverHorizontal(int distancia) {
        super.moveHorizontal(distancia);
    }

    public void moverVertical(int distancia) {
        super.moveVertical(distancia);
    }

    public void cambiarColor(String nuevoColor) {
        super.changeColor(nuevoColor);
    }

    public void cambiarTamaño(int nuevoTamaño) {
        super.changeSize(nuevoTamaño);
    }
}

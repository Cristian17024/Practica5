public class Triangulo extends Triangle {
    
    // Posición actual del triángulo en x y
    private Posicion posicion;

    // Carta asociada a este triángulo
    private Carta carta;

    //Constructor que rea un nuevo Triángulo con una carta y una posicin
    public Triangulo(Carta carta, Posicion posicion) {
        super(); // Llama al constructor de la clase base Triangle
        this.carta = carta; // Asigna la carta al atributo
        this.posicion = posicion; // Asigna la posición al atributo

        // Mueve el triángulo a la posición inicial indicada
        moverA(posicion.getX(), posicion.getY());
    }

    public void establecerCarta(Carta nuevaCarta) {
        this.carta = nuevaCarta;
    }

    // Obtiene la carta actualmente asociada al triángulo
    public Carta obtenerCarta() {
        return carta;
    }

    // Establece una nueva posición para el triángulo
    public void establecerPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
        moverA(posicion.getX(), posicion.getY());
    }

    //Obtiene la posición actual del triángulo

    public Posicion obtenerPosicion() {
        return posicion;
    }

    // Mueve el triángulo a una posición x y y
     
    public void moverA(int x, int y) {
       // hacerInvisible(); 
        moverHorizontal(x - obtenerX()); // Calcula y mueve la diferencia horizontal
        moverVertical(y - obtenerY());   // Calcula y mueve la diferencia vertical
        hacerVisible(); // Muestra el triángulo en su nueva posición
    }

    //Obtiene el valor actual de la coordenada X usando reflexión
    private int obtenerX() {
        try {
            java.lang.reflect.Field campo = Triangle.class.getDeclaredField("xPosition");
            campo.setAccessible(true);
            return campo.getInt(this);
        } catch (Exception e) {
            return 0;
        }
    }
    private int obtenerY() {
        try {
            java.lang.reflect.Field campo = Triangle.class.getDeclaredField("yPosition");
            campo.setAccessible(true);
            return campo.getInt(this);
        } catch (Exception e) {
            return 0;
        }
    }

    // Representación en texto del triángulo, mostrando su carta y posición
    public String toString() {
        return "Triángulo en (" + posicion.getX() + ", " + posicion.getY() + ") con carta: " + carta;
    }

    //Hace visible el triángulo
    public void hacerVisible() {
        super.makeVisible();
    }
    public void hacerInvisible() {
        super.makeInvisible();
    }

    //Mueve el triángulo en horizontal
    public void moverHorizontal(int distancia) {
        super.moveHorizontal(distancia);
    }
    public void moverVertical(int distancia) {
        super.moveVertical(distancia);
    }

    public void cambiarColor(String nuevoColor) {
        super.changeColor(nuevoColor);
    }

    //Cambia el tamaño del triángulo
    
    public void cambiarTamaño(int nuevaAltura, int nuevoAncho) {
        super.changeSize(nuevaAltura, nuevoAncho);
    }
}

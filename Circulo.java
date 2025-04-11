public class Circulo extends Circle {
    
    // Atributo que representa la posición en el plano del círculo
    private Posicion posicion;
    
    // Atributo que representa la carta asociada a este círculo
    private Carta carta;

    // Constructor: crea un nuevo Circulo con una carta y una posición dadas
        public Circulo(Carta carta, Posicion posicion) {
        super(); // Llama al constructor de la clase base 
        this.carta = carta; // Asigna la carta al atributo
        this.posicion = posicion; // Asigna la posición al atributo

        // Mueve el círculo a la posición inicial proporcionada
        moverA(posicion.getX(), posicion.getY());
    }

    // Establece una nueva carta para este círculo
    public void establecerCarta(Carta nuevaCarta) {
        this.carta = nuevaCarta;
    }

    //Devuelve la carta actual del círculo
    
    public Carta obtenerCarta() {
        return carta;
    }

    //Establece una nueva posición para el círculo
    
    public void establecerPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion; // Actualiza la posición
        moverA(posicion.getX(), posicion.getY()); // Mueve el círculo a la nueva posición
    }

    // Devuelve la posición actual del círculo

    public Posicion obtenerPosicion() {
        return posicion;
    }

    // Mueve el círculo directamente a la posición x y 
    
    public void moverA(int x, int y) {
        hacerInvisible(); // Oculta el círculo actual para evitar parpadeos o residuos visuales
        moverHorizontal(x - obtenerX()); // Mueve horizontalmente la distancia necesaria
        moverVertical(y - obtenerY());   // Mueve verticalmente la distancia necesaria
        hacerVisible(); // Muestra el círculo en la nueva posición
    }

    // Método privado para obtener el valor actual de la coordenada x
     
    private int obtenerX() {
        try {
            // Accede al campo privado xPosition usando reflexión
            java.lang.reflect.Field campo = Circle.class.getDeclaredField("xPosition");
            campo.setAccessible(true); // Permite acceso al campo privado
            return campo.getInt(this); // Devuelve el valor del campo
        } catch (Exception e) {
            return 0; 
        }
    }

    
     //Método privado para obtener el valor actual de la coordenada y
     //Usa reflexión para acceder al atributo privado yPosition de la clase base
     
    private int obtenerY() {
        try {
            // Accede al campo privado yPosition usando reflexión
            java.lang.reflect.Field campo = Circle.class.getDeclaredField("yPosition");
            campo.setAccessible(true); // Permite acceso al campo privado
            return campo.getInt(this); // Devuelve el valor del campo
        } catch (Exception e) {
            return 0;
        }
    }

    // Devuelve una cadena de texto con la información del círculo
     
    public String toString() {
        return "Círculo en (" + posicion.getX() + ", " + posicion.getY() + ") con carta: " + carta;
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

    public void cambiarTamaño(int nuevoDiametro) {
        super.changeSize(nuevoDiametro);
    }
}

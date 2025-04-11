import java.awt.*;

public class Visualizador {
    public static void main(String[] args) {
        // Cada carta tiene un valor numérico y un palo 
        // Se crean 4 objetos Carta, uno por cada tipo de palo
        Carta cartaTrébol = new Carta(0, Carta.Palo.TREBOLES);     // Trébol Negro
        Carta cartaDiamante = new Carta(1, Carta.Palo.DIAMANTES);   // Diamante Rojo
        Carta cartaPica = new Carta(2, Carta.Palo.PICAS);       // Pica Negro
        Carta cartaCorazón = new Carta(3, Carta.Palo.CORAZONES);    // Corazón Rojo
        // El trébol se forma con un círculo en la parte superior
        // y tres cuadrados formando la base
        // Primero se define el círculo que representa la parte superior del trébol
        Circulo trebolCirculo = new Circulo(cartaTrébol, new Posicion(250, 40));
        // Luego se crean tres cuadrados posicionados para simular una base en forma de T invertida
        Cuadrado trebolBase1 = new Cuadrado(cartaTrébol, new Posicion(245, 50));
        Cuadrado trebolBase2 = new Cuadrado(cartaTrébol, new Posicion(255, 50));
        Cuadrado trebolBase3 = new Cuadrado(cartaTrébol, new Posicion(250, 55));

        // se colorean las partes del trébol en negro
        trebolCirculo.cambiarColor("black");
        trebolBase1.cambiarColor("black");
        trebolBase2.cambiarColor("black");
        trebolBase3.cambiarColor("black");

        // Hacemos visibles todas las partes del trébol
        trebolCirculo.hacerVisible();
        trebolBase1.hacerVisible();
        trebolBase2.hacerVisible();
        trebolBase3.hacerVisible();
        // El diamante se forma con dos triángulos
        // Un triángulo apuntando hacia arriba y otro hacia abajo
        // Esta forma crea visualmente un rombo o diamante
        Triangulo diamanteArriba = new Triangulo(cartaDiamante, new Posicion(250, 110));
        Triangulo diamanteAbajo = new Triangulo(cartaDiamante, new Posicion(250, 120));

        // Color a los triángulos en rojo para el diamante
        diamanteArriba.cambiarColor("red");
        diamanteAbajo.cambiarColor("red");

        // Hacemos visibles ambas partes del diamante
        diamanteArriba.hacerVisible();
        diamanteAbajo.hacerVisible();
        // La pica se forma con la punta hacia arriba
        // Se utilizan dos triángulos como cuerpo de la pica y un cuadrado como base
        Triangulo picaArriba = new Triangulo(cartaPica, new Posicion(250, 180));
        Triangulo picaAbajo = new Triangulo(cartaPica, new Posicion(250, 190));
        Cuadrado picaBase = new Cuadrado(cartaPica, new Posicion(250, 200));

        // Coloreamos todas las partes de la pica en negro
        picaArriba.cambiarColor("black");
        picaAbajo.cambiarColor("black");
        picaBase.cambiarColor("black");

        // Hacemos visibles todas las partes de la pica
        picaArriba.hacerVisible();
        picaAbajo.hacerVisible();
        picaBase.hacerVisible();
        // El corazón se forma con dos círculos en la parte superior
        // y dos cuadrados en la parte inferior formando una punta
        Circulo corazonIzq = new Circulo(cartaCorazón, new Posicion(245, 250));
        Circulo corazonDer = new Circulo(cartaCorazón, new Posicion(255, 250));
        Cuadrado corazonCentro = new Cuadrado(cartaCorazón, new Posicion(250, 260));
        Cuadrado corazonBase = new Cuadrado(cartaCorazón, new Posicion(250, 265));

        // Coloreamos todas las partes del corazón en rojo
        corazonIzq.cambiarColor("red");
        corazonDer.cambiarColor("red");
        corazonCentro.cambiarColor("red");
        corazonBase.cambiarColor("red");

        // Hacemos visibles todas las partes del corazón
        corazonIzq.hacerVisible();
        corazonDer.hacerVisible();
        corazonCentro.hacerVisible();
        corazonBase.hacerVisible();
    }
}

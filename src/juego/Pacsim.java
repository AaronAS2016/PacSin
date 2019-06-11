package juego;

import casillero.jugador.Pac;
import tablero.Direcciones;
import tablero.Tablero;

public class Pacsim {
	
	
	private static Tablero tablero;
	private static Pac pacsim;
	
	public static void main (String[] args) {
		iniciarJuego();
		imprimirEstadistica();
		imprimirControles();
		imprimirTablero();
	}
	
	private static void iniciarJuego() {
		tablero = new Tablero(4,4);
		pacsim = new Pac();
		System.out.println("============= PACSIM =============");
		System.out.println("Bienvenido a Pacsin para jugar siga las instuccciones \ny muevase por el tablero, trate de encontrar la salida sin que Pac muera");
		System.out.println("Suerte :)");
		imprimirSeparador();
	}
	
	
	private static void imprimirControles() {
		System.out.println("Ingrese la letra de la direccion donde quiera ir: ");
		System.out.println("A - Izquierda");
		System.out.println("S - Abajo");
		System.out.println("W - Arriba");
		System.out.println("D - Derecha");
		imprimirSeparador();
	}
	
	private static void imprimirEstadistica() {
		System.out.println("La cantida de vidas del Pac: " + pacsim.obtenerVidas());
		System.out.println("La cantidad de escudo del Pac es de:" + pacsim.obtenerEscudo());
		imprimirSeparador();

	}
	
	private static void imprimirTablero() {
		tablero.imprimirEnPantalla();
	}
	
	private static void moverJugador(Direcciones direccion) {
		tablero.moverJugador(direccion);
	}
	
	private static void imprimirSeparador() {
		System.out.println();
		System.out.println();
	}
	
	
	

}

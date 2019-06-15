package juego;

import casillero.jugador.Pac;
import tablero.Direcciones;
import tablero.PacSim;
import tablero.Tablero;

public class Main {


	private static PacSim pacsim;

	public static void main (String[] args) {
		iniciarJuego();
		imprimirEstadistica();
		imprimirControles();
		imprimirTablero();
	}
	
	private static void iniciarJuego() {
		pacsim = new PacSim();

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
		System.out.println("La cantida de vidas del Pac: " + pacsim.obtenerVidaDelJugador());
		System.out.println("La cantidad de escudo del Pac es de:" + pacsim.obtenerCantidadDeEscudoDelJugador());
		imprimirSeparador();

	}
	
	private static void imprimirTablero() {

	}
	
	private static void moverJugador(Direcciones direccion) {

	}
	
	private static void imprimirSeparador() {
		System.out.println();
		System.out.println();
	}
	
	
	

}

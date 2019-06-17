package juego;

import casillero.Casillero;
import casillero.jugador.Pac;
import tablero.Direcciones;
import tablero.PacSim;
import tablero.Tablero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {


	private static PacSim pacsim;

	public static void main (String[] args) {
		iniciarJuego();
		imprimirEstadistica();
		imprimirTablero();
		imprimirControles();

		BufferedReader entradaDelUsuario =
				new BufferedReader(new InputStreamReader(System.in));
		while(pacsim.termino()){

			String direccion = null;
			try {
				direccion = entradaDelUsuario.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			moverJugador(direccion.toUpperCase());
			imprimirEstadistica();
			imprimirTablero();
			System.out.println("Ingrese la letra de la direccion donde quiera ir: ");
		}
		System.out.println("==========JUEGO TERMINADO =========");
		boolean gano = pacsim.obtenerResultado();
		if(gano){

			System.out.println("Ganaste!, encontraste la salida y lograste que Pac saliera, gracias por jugar :D");
		}else{
			System.out.println("Perdiste!, Pac se quedo sin vidas :(, volve a intentarlo devuelta!");
		}


	}
	
	private static void iniciarJuego() {
		pacsim = new PacSim();

		System.out.println("============= PACSIM =============");
		System.out.println("Bienvenido a Pacsin para jugar siga las instuccciones \ny muevase por el tablero, trate de encontrar la salida sin que Pac muera");
		System.out.println("Suerte :)");
		imprimirSeparador();

	}
	
	
	private static void imprimirControles() {
		imprimirSeparador();
		System.out.println("Ingrese la letra de la direccion donde quiera ir: ");
		imprimirSeparador();
		System.out.println("A - Izquierda");
		System.out.println("S - Abajo");
		System.out.println("W - Arriba");
		System.out.println("D - Derecha");
	}
	
	private static void imprimirEstadistica() {
		System.out.println("==========INFORMACION DEL PAC =============");
		System.out.println("La cantida de vidas del Pac: " + pacsim.obtenerVidaDelJugador());
		System.out.println("La cantidad de escudo del Pac es de:" + pacsim.obtenerCantidadDeEscudoDelJugador());
		imprimirSeparador();

	}
	
	private static void imprimirTablero() {
		Tablero tablero = pacsim.obtenerTablero();
		int[] coordenadasDelJugador = pacsim.obtenerPosicionDelJugador();
		int[] coordenadasDeLaSalida = pacsim.obtenerPosicionDeLaSalida();

		Casillero[][] casilleros = tablero.obtenerCasilleros();
		String[][] tableroImprimibles = new String[casilleros.length][casilleros[0].length];
		String columnas = "   |";

		for (int i = 0; i < casilleros.length; i++){
			for (int j = 0; j < casilleros[i].length; j++ ){
				if(i == 0){
					columnas= columnas + (j+1) + "|";
				}

				if(i == (coordenadasDelJugador[0] - 1) && j == (coordenadasDelJugador[1] - 1)){
					tableroImprimibles[i][j] = "J";
				}else if(i == coordenadasDeLaSalida[0] - 1 && j == coordenadasDeLaSalida[1] -1 ){
					tableroImprimibles[i][j] = "S";
				}else{
					if (casilleros[i][j].estaLibre()) {
						tableroImprimibles[i][j] = " ";
					}else{
						tableroImprimibles[i][j] = "X";
					}
				}

			}
		}

		System.out.println("===========INFORMACION DEL TABLERO ========");


		System.out.println(columnas);

		for (int i = 0; i < casilleros.length; i++){
			String fila = "|" + (i+1);
			if(i >= 9){
				fila = fila + "|";
			}else{
				fila = fila + " |";
			}
			for (int j = 0; j < casilleros[i].length; j++){
				fila = fila + tableroImprimibles[i][j];
			}
			System.out.println(fila );
		}








	}
	
	private static void moverJugador(String direccion) {

		if (direccion.equals("A")){
			System.out.println("El jugador se mueve hacia la izquierda");
			pacsim.moverJugadorIzquierda();
		}else if(direccion.equals("D")){
			System.out.println("El jugador se mueve hacia la derecha");
			pacsim.moverJugadorDerecha();
		}else if(direccion.equals("W")){
			System.out.println("El jugador se mueve hacia arriba");
			pacsim.moverJugadorArriba();
		}else if(direccion.equals("S")){
			System.out.println("El jugador se mueve hacia abajo");
			pacsim.moverJugadorAbajo();
		}else{
			System.out.println("Por favor ingrese un movimiento valido");
		}
	}
	
	private static void imprimirSeparador() {
		System.out.println();
	}
	
	
	

}

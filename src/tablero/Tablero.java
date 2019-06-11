package tablero;

import casillero.Casillero;

public class Tablero {
	
	
	
	private Casillero[][] casilleros;
	
	public Tablero(int cantidadDeFilas, int cantidadDeColumnas) {
		if(cantidadDeColumnas < 4 && cantidadDeFilas < 4) {
			throw new Error("Tablero de dimensión no valida");
		}
		casilleros = new Casillero[cantidadDeFilas][cantidadDeColumnas];
	}
	
	
	public Casillero obtenerCasillero(int fila, int columna) {
		return this.casilleros[fila][columna];
	}
	
	public void agregarCasillero(int posicion , Casillero casillero) {
		
	}

	public void imprimirEnPantalla() {
		// TODO Auto-generated method stub
		
	}

	public void moverJugador(Direcciones direccion) {
		// TODO Auto-generated method stub
		
	}

}

package tablero;

import casillero.Casillero;
import casillero.Ficha;

public class Tablero {
	
	
	
	private Casillero[][] casilleros;
	
	public Tablero(int cantidadDeFilas, int cantidadDeColumnas) {
		if(cantidadDeColumnas < 4 && cantidadDeFilas < 4) {
			throw new Error("Tablero de dimensión no valida");
		}
		casilleros = new Casillero[cantidadDeFilas][cantidadDeColumnas];
	}
	
	
	public Casillero obtenerCasillero(int fila, int columna) {
		return this.casilleros[fila-1][columna-1];
	}
	
	public void agregarCasillero(int fila, int columna , Casillero casillero) {
		this.casilleros[fila-1][columna-1] = casillero;
	}

	public void agregarFichas(int fila, int columna, Ficha ficha){
		this.casilleros[fila-1][columna-1].agregarFichas(ficha);
	}

	public Casillero[][] obtenerCasilleros(){
		return this.casilleros;
	}

	public int obtenerCantidadDeFilas(){
		return this.casilleros.length;
	}

	public int obtenerCantidadDeColumnas(){
		return this.casilleros[0].length;
	}

}

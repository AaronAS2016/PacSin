package casillero.jugador;

public abstract class Jugador {
	protected int vidas;
	protected int escudo;
	
	public int obtenerVidas() {
		return this.vidas;
	}
	
	public int obtenerEscudo() {
		return this.escudo;
	}
	
	public boolean estaVivo() {
		return this.vidas > 0;
	}
	
	public boolean tieneEscudo() {
		return this.escudo > 0;
	}
	
	
}

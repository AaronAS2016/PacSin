package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tablero.PacSim;

public class casilleroTest {

	@Test
	public void obtenerEscudoDelJugadorAlInicioDeLaPartida(){
		PacSim pacsim;
		pacsim = new PacSim();
		assertEquals( 0, pacsim.obtenerCantidadDeEscudoDelJugador());
	}
	
	@Test
	public void obtenerVidasDelJugadorAlInicioDeLaPartida(){
		PacSim pacsim;
		pacsim = new PacSim();
		assertEquals( 3, pacsim.obtenerVidaDelJugador());
	}
	
	@Test
	public void obtenerVidaDelJugadorLuegoDePisarUnaMina() {
		PacSim pacsim;
		pacsim = new PacSim();
		pacsim.moverJugadorArriba();
		pacsim.moverJugadorDerecha();
		assertEquals( 3, pacsim.obtenerVidaDelJugador());
	}
	
	@Test
	public void obtenerEscudoDelJugadorAlLlegarATresEscudosYPisarUnaMina() {
		PacSim pacsim;
		pacsim = new PacSim();
		pacsim.moverJugadorArriba();
		pacsim.moverJugadorIzquierda();
		assertEquals( 0, pacsim.obtenerCantidadDeEscudoDelJugador());
	}
	
	@Test
	public void obtenerCantidadDeVidasDelJugadorAlPasarPorUnaMinaYAgarrarUnaVitamina(){
		PacSim pacsim;
		pacsim = new PacSim();
		pacsim.moverJugadorArriba();
		pacsim.moverJugadorDerecha();
		pacsim.moverJugadorArriba();
		pacsim.moverJugadorArriba();
		assertEquals( 3, pacsim.obtenerVidaDelJugador());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
